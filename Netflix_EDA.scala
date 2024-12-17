import org.apache.spark.sql.{SparkSession, DataFrame}
import org.apache.spark.sql.functions._
import org.apache.log4j.{Level, Logger}
import java.nio.file.{Files, Paths, StandardOpenOption}

object NetflixDataAnalysis {
  def main(args: Array[String]): Unit = {
    
    // Adjusting log level to show only warnings
    Logger.getLogger("org").setLevel(Level.WARN)
    Logger.getLogger("akka").setLevel(Level.WARN)

    // Creating SparkSession for data processing
    val spark = SparkSession.builder()
      .appName("Netflix Data Analysis")
      .master("local[*]") // Utilizing all available cores on the local machine
      .getOrCreate()

    // Loading the Netflix dataset from a CSV file
    val dataset = spark.read
      .option("header", "true")
      .option("inferSchema", "true")
      .csv("./netflix_titles.csv") // Specify the dataset's path

    // Specifying the output directory where results will be saved
    val outputFolder = "./results"
    Files.createDirectories(Paths.get(outputFolder)) // Ensures output directory exists

    // Writing schema details to a text file
    saveContentToFile(s"${outputFolder}/schema_info.txt", dataset.schema.treeString)

    // Saving the first 10 rows of data to a file
    storeDataFrame(dataset.limit(10), s"${outputFolder}/sample_data.csv")

    // Analyzing the distribution of different content types
    val contentTypeCount = dataset.groupBy("type").count()
    storeDataFrame(contentTypeCount, s"${outputFolder}/content_type_distribution.csv")

    // Identifying the top 10 countries with the highest number of titles
    val topCountriesList = dataset.groupBy("country")
      .count()
      .orderBy(desc("count"))
      .limit(10)
    storeDataFrame(topCountriesList, s"${outputFolder}/top_countries.csv")

    // Determining the most popular genres based on their occurrence
    val topGenresList = dataset.groupBy("listed_in")
      .count()
      .orderBy(desc("count"))
      .limit(10)
    storeDataFrame(topGenresList, s"${outputFolder}/popular_genres.csv")

    // Counting the number of titles released each year
    val releaseCountByYear = dataset.filter(col("release_year").isNotNull)
      .groupBy("release_year")
      .count()
      .orderBy("release_year")
    storeDataFrame(releaseCountByYear, s"${outputFolder}/titles_by_year.csv")

    // Counting missing (null) values in each column
    val missingDataCount = dataset.columns.map { columnName =>
      val missingValues = dataset.filter(col(columnName).isNull || col(columnName) === "").count()
      s"$columnName: $missingValues"
    }
    saveContentToFile(s"${outputFolder}/missing_data_counts.txt", missingDataCount.mkString("\n"))

    // Shutting down the Spark session
    spark.stop()
  }

  // Function to save a DataFrame to a CSV file
  def storeDataFrame(df: DataFrame, filePath: String): Unit = {
    df.write
      .mode("overwrite") // Overwrite existing files if necessary
      .option("header", "true") // Ensure headers are written
      .csv(filePath)
  }

  // Function to write content (text) to a file
  def saveContentToFile(filePath: String, content: String): Unit = {
    Files.write(Paths.get(filePath), content.getBytes, StandardOpenOption.CREATE)
  }
}

