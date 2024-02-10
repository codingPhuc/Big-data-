# what is MapReduce 
Programming model used in Hadoop for processing Big data 
Processing technique for distributed computing bases on java
- Distributed computing is a system with multiple components located on different machines that communicate actions in one view to the end user 
consist of a Map task and a Reduce task 
can be coded in may programming language C++ , java  , python 

# How does MapReduce work   


![[map reduce.PNG]]

- Map: processes map  into key value pairs 
- Further data sorting an organizing, in this cases Performing the group by key step
	-  this is the bottle neck section of the algorithm ,this is because all the pair from the group map have to be combine and revalue here 
- Reducer aggregates and computes a set of result and produces a final output 

MapReduce keeps track of its task by creating a unique key to ensure that all process are solving the same problem 
Partitioning the input data
Scheduling the program’s execution across a set of machines

## An example :
![[mapreduce2.PNG]]
input file that have name of people we want to do a word count 
- each line in the file is split into each section 
- the map will then split combine it into key value 
- the reducer  start with suffering , you will see the key  Teju combine to [1,1,1] indicating how may time it occurred in the file it then output it in the output file




# Machine failure 
Handling machine failures
- if there is a problem with the software or hardware the environment will fix it for us 
## Map Worker failure 
When a problem occurs in the Map worker:
Any Map tasks that are either completed or still in progress , the worker are reset to their initial state and rescheduled.
The Reduce workers are informed when a Map task is rescheduled on another worker.
If a Map worker fails:
- The Reduce worker takes over the task.
If a Reduce worker fails:
- Only the tasks that are still in progress are reset to their initial state and the Reduce task is restarted.

# Why use MapReduce  
ability to allow for [[parallel processing]] across multiple node , a node is an independent computer for processing and storing big volume  of data 
Hadoop we have two types of node the name node and the data node 
Map reduce allow for splitting  and running independent task in [[parallel processing]] by dividing each task saving time 
MapReduce  can process data that come in tabular and non-tabular form 
MapReduce provides business value to organization doesn't matter how business is structure  
## common used cases 
used for social media to see who view your profile 
user for bank to flag user transaction  
advertiser  to under stand user behavior 