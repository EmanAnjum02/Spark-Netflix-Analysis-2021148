
---

# 🎬 EDA on Netflix TV Shows & Movies Dataset with **Spark** & **Scala** 💻

## 👀 Project Overview

Welcome to the **Netflix TV Shows & Movies Analysis** project! 🎉 In this project, we dive into the Netflix dataset to uncover some interesting insights using **Apache Spark** and **Scala**. Whether you're interested in understanding genre popularity, viewing trends over the years, or comparing movie vs. TV show data, this project will reveal it all!

> **Technologies Used:**
> - **Apache Spark** 🔥
> - **Scala** 🛠️
> - **Docker** 🐳

---

## 🔍 Key Concepts
---

### 💡 **Distributed Computing**

Apache Spark works by breaking down large data sets into smaller parts and processing them across multiple computers. This means Spark can handle big data much faster than a single computer could, by running tasks in parallel. It's like having a team of workers each doing a part of the job at the same time!

### ⚡ **In-Memory Processing**

Spark speeds things up by storing data in **RAM** (memory) instead of writing it to a hard drive after every operation. This **in-memory processing** makes it quicker to work with the data because Spark doesn't need to constantly read and write data to disk.

### 🔗 **RDD (Resilient Distributed Dataset)**

An **RDD** is a collection of data that Spark can process in parallel. It’s **fault-tolerant**, which means if something goes wrong, Spark can rebuild the data from the original source. Think of an RDD as a reliable, distributed collection that can be worked on simultaneously by multiple machines.

### 🌍 **Fault Tolerance**

Spark is great at **recovering from errors**. If a part of the data is lost or something goes wrong, Spark can rebuild the lost data from the original source. It makes sure your analysis keeps running smoothly without any data getting lost.

---

## 📦 Installation

### Requirements

Before running this project, you’ll need to have a couple of things installed on your local machine:

- **Docker** 🐳
- **Git** 💻

### 🔧 Clone the Repository

```bash
git clone <repository-url>
cd <project-folder>
```

---

## 🚀 Running the Project

### 🏗️ Build the Docker Image

Run the following command to build the Docker image for your Spark and Scala application:

```bash
docker build -t netflix-spark-scala .
```

### 🏃‍♂️ Run the Docker Container

Start the application using Docker:

```bash
docker run --rm -v $(pwd)/output:/app/output netflix-spark-scala
```

### 🧐 View the Results

After running the container, the output will be saved in the `output/` directory. This is where you can check out all the cool analysis results.

---

## 📊 Results & Insights

### 📂 **Schema Information**
Explore the schema structure of the dataset, available in the file: `output/schema.txt`.

### 📝 **Sample Data**
Check out a preview of the first 10 records in the dataset to get a quick snapshot of the data in `output/sample_data/`.

### 🎬 **Movies vs. TV Shows Breakdown**
See how the dataset is divided between movies and TV shows in the `output/type_count/` directory.

### 🌎 **Top Countries with Titles**
Find out which countries have the most titles in our collection, available in `output/top_countries/`.

### 🎶 **Most Popular Genres**
Get insights into which genres are the most popular across the dataset in `output/popular_genres/`.

### 📅 **Titles Released Per Year**
Understand how titles are distributed over the years, with results stored in `output/titles_per_year/`.

### 🕵️‍♂️ **Null Values Analysis**
Dive into the null value analysis, which highlights missing values across different columns, in `output/null_counts.txt`.

---

## 🎯 Next Steps

- **Refine the Analysis**: Maybe you can explore further relationships between genres, release years, and countries.
- **Integrate More Data**: Add more datasets to enrich your analysis and get deeper insights.
- **Scale Up**: Try scaling this project by adding more sophisticated features, such as recommendation systems or user sentiment analysis!

---

## 💬 Contact & Feedback

Feel free to reach out or open issues if you run into any problems! We'd love to hear your thoughts and any improvements you can suggest. 

---

