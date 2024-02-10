


# Vertical Scaling 

![[scaling up.PNG]] 
when your data  increase beyound the amount of data that your node can handle it the node need to increase it capacity , this is call vertical scaling 

# Horizontal Scaling 


A better strategy , or at least the one most people ultimately choose , is to scale out  horizontally 
- this mean adding node with the same capacity which is call computing [[cluster architecture]] 
## embarrassingly parallel
- computing [[cluster architecture]]  can solve " embarrassingly parallel"  these are the kind of workload that can easily be divided and run independent of one another 
- if any one process fail it have no impact on the others and can simply be return 
![[horizontal scaling.PNG]]

## not so easy parallel 
![[not so easy.PNG]]
- these kind of workload requires sending messages across a network to each other or writing them to a file system  that is accessible to all process in the [[cluster architecture]]  
- the complexity is increase you are asking multiple computer to act as a single computer   
![[cluster.PNG]]
the ideal of [[Hadoop]] of bringing the computation to the data is that instead of splitting the data into different part spread in different machine , the computation will take place in the main node and output in the main node 
