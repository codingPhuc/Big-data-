1. How to represent a cluster ? 
2. How to determine the nearness of clusters ? 
3. when to stop merging cluster ? 
## 1. How to represent a cluster ?  
as the cluster is getting merge , we represent the "location " of each cluster by its 
centroid = average of its (data) points 
$$(\frac{x_1 +  x_2  + ... + x_y}{n} ,\frac{y_1 +  y_2  + ... + y_y}{n}  )$$

## 2. How to determine the nearness of clusters? 
 Measure cluster distances by distances of centroids 
 Merge two clusters with the shortest distance 
![[data poibt.PNG]]

