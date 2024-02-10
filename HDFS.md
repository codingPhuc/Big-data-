#Question  
- explain Hadoop Distributed File System(HDFS) and important concepts 
- Identify the key HDFS features 
- Describe the HDFS architecture 

# HDFS 
HDFS is the acronym for Hadoop distributed File System 
HDFS is a file system  that distribute  on multiple file server and allow programmer to access and store file any where on the system 
HDFS is the storage layer of Hadoop 
Split the files into blocks, create  replicas of the blocks , and stores them on different  machine  
Provides access to streaming data 
- Streaming mean that HDFS provides a constant bitrate when transferring data rather than   having the data being transfer  by waves 
HDFS used GUI interact 
## key features 
Cost efficient  
- the storage hardware is not expensive 
Large amounts of data 
- HDFS can store up to petabytes of data 
Replication 
- make copies of the data on multiple machines 
Fault tolerant 
- if one machines crashes , a copy of the data can be found somewhere else and work continues 
Scalable 
- One cluster can be scaled into hundreds of nodes 
Portable 
- can easily move across multiple platforms  

# HDFS concepts 
when HDFS receive file the file are broken into block 
block is the default block size that the file can be read in 
- minimum amount of data that can be read or written 
- Provide fault  tolerance 
- Default size is 64MB or 128MB
## Block 
![[blocksize.PNG]]
- if we have a 500 MB with the default size of 128mp 
- the file will have 4 chunk with 128mb 
- each file stored doesn't have to take up the configured space size 


## Nodes 
A node is a single system which is responsible to stores and process data 
there are two type of node in HDFS Primary node and Secondary Nodes 
![[node in HDFS.PNG]]
- Primary node aka NameNode/MasterNode  
- Secondary node aka  DataNode 
Rank awareness  in HDFS 
- Choosing data node rack  that are closest to each other  
	- A rack is the collection of about 40 to 50 data nodes using the same network switch 
 - Improves cluster performance  by reducing network traffic 
 - Name node keep the rack ID information 
 - Replication can be done thought  rack awareness 

### Master Node

**Name Node in Hadoop HDFS:**
- Manages metadata, including the structure and locations of data chunks.
**Key Functions:**
- Stores crucial metadata about data chunks.
- Costly to replace if destroyed, compared to a data node.
- Manages information about file locations in the distributed file system.
- Typically more robust against hardware failures, running critical cluster services.
- Also referred to as the Secondary Name Node, serving backup functions.
- Stores information about where files are stored; for example, if File 1 is stored across 6 chunks.
The master node is crucial for the overall system.

### Replication 
Creating a copy of the data block 
copies are created for backup purposes  
Replication factor : number of times the data block was copied  
![[repittion.PNG]]
- the number of replication can be bases on a user choice , an example is the file that was split into different chunk each chunk is replicated 2 time and store in different rack so then if one rack fail the other rack will store the file copy 
## HDFS Overall architecture 
![[file node architecture.PNG]]

- The primary node, known as the Name Node, is singular per customer. There is one Name Node and several secondary nodes. The file is split into different blocks, which are stored on the Data Nodes.
- The Name Node oversees operations such as opening, closing, and renaming files. Additionally, it maps file blocks to Data Nodes. Data Nodes handle read and write requests from the client and execute tasks such as file block creation, replication, and deletion based on instructions from the Name Node.

