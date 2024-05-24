


# Introduction To course 
### Roles in Data Management

- **System Administrator (Store):** Primarily responsible for the installation and maintenance of software.
- **Database Administrator (Managed):** Overseeing the management of databases, ensuring their efficiency and security.
### Data Science as a Major

Data science is not a standalone course but a comprehensive major integrating various disciplines. It encompasses:

- **[[Data Mining]]:** Uncovering actionable insights from data.
- **Big Data:** Handling and analyzing massive datasets.
- **Machine Learning:** Utilizing algorithms to enable systems to learn and make predictions.

## what we will be learning 

To effectively analyze and manipulate such data, learners will delve into various tools and concepts:
1. **Linear Algebra:** Understanding and manipulating matrices and vectors, which are fundamental to handling high-dimensional data.
2. **Optimization:** Techniques for optimizing models and algorithms to improve their efficiency and performance in handling large datasets.
3. **Dynamic Programming:** A method for solving complex problems by breaking them down into simpler, overlapping subproblems, often used in optimization.
4. **Hashing (LSH and Bloom Filter):** Utilizing hashing techniques, such as Locality-Sensitive Hashing (LSH) and Bloom filters, for efficient data storage and retrieval.
In addition, the course will cover the concepts of streams and concurrency, as well as gradient vectors in machine learning and related fields. The overall goal is to equip learners with the skills necessary to work with diverse and complex data types and structures.

# Overview  
## What is big data compare with small data 
Small Data 
- Small enough for human inference 
- accumulated slowly 
- relatively consistent and structured data usually stored in known forms such as JSON and XML 
- mostly located in storage system within enterprises or data centers 
Big Data  
- Data generated in huge volumes  and could be structured , semi-structured  , or unstructured 
- Need processing to generate insights for human consumption 
- Arrives continuously at enormous speed from multiple sources 
- comprises any form of data including video , photos , and more 
- Distributed on the cloud and server farms 
# Big Data Life Cycle 
![[big data circle.PNG]]
Data Collection 
- initiated as the result of business problem 
- as data is collected , it get stored suing a framework for distributed stored 
Data Modeling 
- to make sense of all the data collected , [[MapReduce]] task and script created a data model to stored in a a database , this model is the relationship between the data 
Data Processing 
- after modeling data is ready to be process tools such as APache Spark are used to produce meaningful information form the modeled data 
Data Visualization :
- data is presented in a graphical format 
- this will lead to a meaning full business cases 
- continuing the life cycle 

## (IOT) Internet of thing in big data 

[[IOT]] an internet enabled connected  network of smart devices such as sensor , processors , embedded devices and communication hardware 
Data collected , analyzed , and acted upon for benefit such as improving customer experience , enhance productivity , and increased revenue
## Big data architecture 

 [[single node architecture]] , algorithms are executed on the CPU, and data access is directly from memory, eliminating the need for data reloading , it most used processing is [[Linear processing]] 
[[ cluster architecture ]]   , a system of interconnected nodes that cooperate with each other in sharing their workload , it most used processing is [[parallel processing]]

## Data Scaling in Big Data 
Data scaling in Big Data refers to the ability of a system to handle an increasing amount of data in a capable manner. This involves two key aspects:
- **Storage Scaling**: As the volume of data grows beyond the capacity of existing storage, new storage systems need to be added. This offense lead to a [[Storage Scaling]] 
    
- **Computational Scaling**: As data grows, the computational power required to process this data also increases. Efficient data scaling ensures that the system can process larger datasets within a reasonable time. This is often achieved through distributed computing, where the computational task is divided and processed across multiple machines
# Big data tool and ecosystem 
- identify the [[key tooling categories]] within  the big data ecosystem 
- Describe the rile of each tool 
![[cateogry.PNG]]
there are six different category to big data tools 

## Type of data 
data is high dimensional 
	- dữ liệu đa chiều là dữ liệu  vd : ma trận vector 
 data is a graph 
	 - mỗi trang web là một đỉnh mỗi link là canh đến trang web đó 
data is infinite never ending 
	- dữ liệu giao dịch rất liên tục nên ngân hàng cần dc lưu trữ 
data is labeled
### Descriptive method 
Find human interpretable patterns that describe the data  
- interpretable patterns  (là quy luật mà con người có thể hiểu để giải thích về data) 
### Predictuve method 
Use some varibables to predict unknown or future values of otheer varibales (sử dụng các biến dữ liệu cần có để dự đoán dữ liệu còn thiếu ) 
- giá vàng tuần vừa qua dự đoán cho giá vàng năm sau
-  Recommender System : hệ thống thiếu nghị dự đoán thông tin trong tương lai 

## Large-scale Computing 
### Machine failure 
a  server may stay up for 3 year (1000 days) 
1000 servers , expect to lose 1/day 
with 1m machines 1000 machines fail every day 
Issue : 
Copying data over a network takes time 
idea : 
- bring computation to data 
	- thay vì cho một data lớn vào bộ xử lý , cắt nhỏ thành từng chunk xong xử lý trong từng máy tinh xong gửi lại kết quả 
store files multiple time for reliability (lưu file nhiều lần) : 
- để ngăn chặn tình trạng máy tính mất data thì mình phải đánh đổi bộ nhớ với dộ tin cậy , thường xuyên tạo snap shot để có bảo hiểm  lấy lại  data 
##  redundant storage infrastructure  
Storage infrastructure  (file system  là nơi lưu trữ thao túng xử lý tập tin và thư mục)  
## different type of file system
A [[distributed file system ]] is a file system that enables clients to access file storage from multiple hosts through a computer network as if the user was accessing local storage. Files are spread across multiple storage servers and in multiple locations, which enables users to share data and storage resources. A DFS can be designed so geographically distributed users, such as remote workers and distributed teams, can access and share files remotely as if they were stored locally.

# Definition In Big Data 
[[Big Data Definition]] help client and people that are framilier with big data too understand  key word and task without the need to have a long sentence 


# Different data type in spark  
[[rdd]]
[[DataFrame]]
# Algorithm 
Algorithm in big data help to identify and solve complex problem  : 
- [[PCY]]
- [[A priori]]
- [[Finding Similar Documents]]
- [[Clustering]]
#Exam 
[test](https://knowt.com/flashcards/25c41b9f-21e2-4b8e-a131-847c37e9587e) 

# AWS for big data 

Amazon EMR is an AWS offering for Apache Spark. It allows quick launch of Spark clusters, eliminating the need for node provisioning, cluster setup, or Spark configuration. EMR can provision varying compute instances in minutes and uses Auto Scaling to adjust Spark clusters based on data size. Costs can be reduced by committing to a set term, using Amazon EC2 Reserved Instances for up to 75% savings, or using spare AWS compute capacity (EC2 Spot) for up to 90% savings. To use Apache Spark on AWS, you need to create an account.

**Node Provisioning** refers to the process of acquiring and configuring a new node in your cluster for your project (pod) to be scheduled onto This process can be automated using node auto-provisioning, which eliminates the manual step of pre-creating node pools by allowing users to add high-level requirements as constraints. It automatically determines the best machine type or available node for the workload]

[On the other hand, **Cluster Setup** involves creating a group of hosts (a cluster) and managing the resources of all hosts that it contains](https://docs.vmware.com/en/VMware-vSphere/7.0/com.vmware.vsphere.vcenterhost.doc/GUID-F7818000-26E3-4E2A-93D2-FCDCE7114508.html)[3](https://docs.vmware.com/en/VMware-vSphere/7.0/com.vmware.vsphere.vcenterhost.doc/GUID-F7818000-26E3-4E2A-93D2-FCDCE7114508.html). [This process typically involves installing the required software on all nodes in the cluster, configuring the cluster settings, and adding the cluster to your system](https://hadoop.apache.org/docs/current1/cluster_setup.html)[4](https://hadoop.apache.org/docs/current1/cluster_setup.html). The setup process can vary depending on the specific technology or platform being used. [For example, in a Kubernetes cluster, you might need to configure containers for production traffic](https://www.redhat.com/en/resources/creating-a-kubernetes-cluster-16-steps-checklist)[5](https://www.redhat.com/en/resources/creating-a-kubernetes-cluster-16-steps-checklist)[, while in a Hadoop cluster, you might need to unpack the software on all the machines in the cluster](https://hadoop.apache.org/docs/current1/cluster_setup.html)[4](https://hadoop.apache.org/docs/current1/cluster_setup.html).

Both of these processes are crucial steps in setting up a distributed computing environment like Apache Spark. They ensure that the computing resources are properly allocated and managed, allowing for efficient data processing and analysis.




spark 2 pro  
- driver program single process create work for the cluster 
- executor multiple processses thougthout the cluster that can do the work  

communitcate with the cluster mangaer 
is defined in the driver driver program create work and computation that is create parrelle 
partition  tsk can run on parrelle on the executor 
executor is alloted a  number of cores that each run one task at a time 
increasing executor and cores increates cluster parallelism 
l


stages and shuffles 
sc are create in driver contenxt much be active for the time 

driver createjob into task for different clustor  

worker note is where to compute work 

![[Pasted image 20240524164553.png]]![[Pasted image 20240524164610.png]]
![[Pasted image 20240524164626.png]]![[Pasted image 20240524164641.png]]
![[Pasted image 20240524164657.png]]
![[Pasted image 20240524164717.png]]