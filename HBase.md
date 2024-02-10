#Question 
- Define HBase 
- Describe HBase as columnar database 
- List the HBase feature and usage 
- Outline the difference between HBase and HDFS 
- Describe the HBase architecture 

HBase is a Column-oriented non-relational database management system 
HBase runs on top of HDFS 
Provides a fault tolerant way of storing sparse dataset  
- Fault tolerance refers to the working ability of a system or computer to continue working even in unfavorable condition such as when a server crashes 
works well with real time data and random read and write access to Big Data  

HBase is used for write heavy applications 
- HBase is linearly and modularly scalable 
- it is a backup support for MapReduce job 
- It provieds consistenread and writes 
- It has no fixed column schema 
- it is an easy-to-use Java API for client access
- It provides dta replication across cluster 

![[HBase.PNG]]
- HBase work in the way that there is a familles connection between the column where multiple column can be group inside into a families columns the family columns will be a add in idicator telling which group the individual columns belong to 

| HBase                                                               | HDFS                                                                           |
| ------------------------------------------------------------------- | ------------------------------------------------------------------------------ |
| HBase stored dta in the form of columsn and rows in a table         | HDFS stores data in a distribured manner across diffrerent node on the network |
| HBase allow dynamic changes                                         | HDFS has rigid architecture that deos not allow changes                        |
| HBase allow for storing and processing of Big Data                                                                    | HDFS is for storing only                                                                                |
| HBase is suitable for random writes and read of data stored in HDFS | HDFS is suited for write one and read many times                               |
![[arhichtecture HBase.PNG]]
Four component 
HMaster 
- Monitor the Region  server instances 
- assigns region to region servers 
- Manages any changes that are made to the schema 
HRegion server 
- Receives and assigns request to regions 
- Reponsible for managin regions
- Communicates directly with the client 
HRegion  
- Smallest unit of HBase cluster 
- Contain multiple stores 
- Two component -HFile and Memstore 
ZooKeeper 
- Maintains healthy link between nodes 
- Provides distributed synchronizastion 
- Track server failure 
HBase work top of HDFS 
