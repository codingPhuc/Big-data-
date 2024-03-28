
#Question  
- Define Hadoop 
- Explain the history of Hadoop 
- List reasones why Hadoop was the answer to Big Data processing 
- Outline some of the challenges of Hadoop 
- List the stages of the Hadoop Ecosystem 
- Differentiate between the core componets and the extended componets 
- List some example of tools used in each stage 


# What is Hadoop 
Hadoop is an open-source framework used to process enormous data sets 
Hadoop is a set of open source programs and procedure 
used  for processing large amount of data 
server run application on [[cluster architecture]]
Handle [[parallel processing]] or processes 
## Why Hadoop ? 
Hadoop was designed to  help organization manage terabytes of data
used to process unstructured data combine with  relational Data 
# How does Hadoop work 
Hadoop Common is an essential part of Apache Hadoop framework that refers to the collection of common utilities and libraries that support other Hadoop modules 
[[HDFS]] 
- Hadoop Distributed File System  
- Handles and stores large data 
- Scales a single Hadoop Cluster into as much as thounsand cluster 
[[MapReduce]]  
- known as Hadoop processing unit 
- Process  Big Data by splitting the data into smaller units
- The first method used to query data stored in HDFS 
[[Yarn]] 
- Yet Another resource Negotiator acronym 
- Prepares , Hadoop for batch , stream , interactive and graph processing 
# The challenges of Hadoop  
processing transaction (random access)
when work cannot be parallelized 
when there are dependencies in the data 
low latency data access 
- low latency allow small delay  unnoticeable  by human by input being process and  corresponding output providing real time characteristics 
Processing lot of small files 
Intensive calculation with little data 


# Hadoop Ecosystem 

__Hadoop Ecosystem__ is a platform or a suite which provides various services to solve the big data problems. It includes Apache projects and various commercial tools and solutions. There are __four major elements of Hadoop__ i.e. ***HDFS, MapReduce, YARN, and Hadoop Common Utilities****. Most of the tools or solutions are used to supplement or support these major elements. All these tools work collectively to provide services such as absorption, analysis, storage and maintenance of data etc.
![[hadoop Ecosystem framwork.PNG]]
### Ingesting

Ingesting is the first stage of Big Data processing. When dealing with big data, you collect data from different sources. Let’s explore two key tools for data ingestion:
1. **Flume**:
    - Flume is used to **collect, aggregate, and transfer** big data.
    - It has a simple and flexible architecture based on streaming data flows.
    - Flume’s single extensible data model allows for online analytic applications.
2. **Sqoop**:
    - Sqoop is designed to **transfer data between relational database systems and Hadoop**.
    - It accesses the database to understand the schema of the data.
    - Sqoop generates a MapReduce application to import data into HDFS.
### Storing Data

Now let’s look at storage options:

1. **[[HBase]]**:
    - HBase is a **non-relational database** that runs on top of HDFS.
    - It provides real-time wrangling on data.
    - HBase stores data as indexes, allowing for random and faster access.
2. **Cassandra**:
    - Cassandra is a **scalable NoSQL database** designed to have no single point of failure.
### Anayzing Data

For data analysis, consider the following tools:

1. **Pig**:
    - Pig analyzes large amounts of data.
    - It operates on the client side of a cluster and uses a procedural data flow language.

2. **[[Hive]]**:
    - Hive is used for creating reports.
    - It operates on the server side of a cluster and uses a declarative programming language.

### Accessing Data

Finally, let’s explore data access tools:
1. **Impala**:
    - Impala is a **scalable and user-friendly platform**.
    - No programming skills are required to use it.

2. **Hue** (Hadoop User Experience):
    - Hue allows you to **upload, browse, and query data**.
    - You can run Pig jobs and workflows using Hue.
    - It provides an editor for server SQL query languages like Hive and MySQL.


Hadoop [cheat sheet](https://author-ide.skills.network/render?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJtZF9pbnN0cnVjdGlvbnNfdXJsIjoiaHR0cHM6Ly9jZi1jb3Vyc2VzLWRhdGEuczMudXMuY2xvdWQtb2JqZWN0LXN0b3JhZ2UuYXBwZG9tYWluLmNsb3VkL0lCTS1CRDAyMjVFTi1Ta2lsbHNOZXR3b3JrL2xhYnMvTW9kdWxlMi9DaGVhdF9TaGVldC9JbnRyb2R1Y3Rpb25fdG9fdGhlX0hhZG9vcF9FY29zeXN0ZW0ubWQiLCJ0b29sX3R5cGUiOiJpbnN0cnVjdGlvbmFsLWxhYiIsImFkbWluIjpmYWxzZSwiaWF0IjoxNzAwNjc1MDkwfQ.LeDHZRzRDl0Ddt2jgpmaM1ZuoIe7-OJiymnLmaZ6k_Q)
Hadoop [ fundamental cheat sheet ](https://author-ide.skills.network/render?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJtZF9pbnN0cnVjdGlvbnNfdXJsIjoiaHR0cHM6Ly9jZi1jb3Vyc2VzLWRhdGEuczMudXMuY2xvdWQtb2JqZWN0LXN0b3JhZ2UuYXBwZG9tYWluLmNsb3VkL0lCTS1CRDAyMjVFTi1Ta2lsbHNOZXR3b3JrL2xhYnMvTW9kdWxlMi9HbG9zc2FyeS9JbnRyb2R1Y3Rpb25fdG9fSGFkb29wX0Vjb3N5c3RlbS5tZCIsInRvb2xfdHlwZSI6Imluc3RydWN0aW9uYWwtbGFiIiwiYWRtaW4iOmZhbHNlLCJpYXQiOjE3MDA2NzUwMTF9.7QefhIh1_LFx0owUfvATTvm8eKdbwKklhz8EwqQWuzI)







 Storage infrastructure - file system  là nơi lưu trữ thao túng xử lý tập tin và thư mục 
	- Google : GFS 
	- file trong course này cắt nhỏ thành các chunk xong xử lý nó nhiều nơi 
- Programming model 
	- MapReduce 
	- Spark 
Problem : 
- if nodes fail how to store data persistently ? 
Typical usage pattern : 

- data is rarly change 
trong môt distributed system có những loại máy tính sau 
- chunk server hay data node dùng để lưu trữ các chunk 
	- chunk là mỗi loại data nhỏ thường từ 16-64 mb các chunk thường dc nhân bản lên (x2 và x3 )
	- giữ nhân bản của chunk 
Master node 
- Name Node in hadoop HDFS
	- lưu trữ metadata (cấu trúc và vị trí lưu trữ các chunk)
 - master node is improtance if it is destroy  it is more costly to replace than data node 
- Stores metadata about where files are stored 
- Master nodes are typically  more robust to hardware failure and run critical cluster services 