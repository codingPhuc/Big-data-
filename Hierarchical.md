#  Agglomerative(bottom up) : 
[[Agglomerative]] is Initially, each point is classify as a cluster , Repeatadly combine the two "nearest " cluster into one 
Three importance question : 
1. How to represent a cluster ? 
2. How to determine the nearness of clusters ? 
3. when to stop merging cluster ? 


#  Euclidean 
## 1. How to represent a cluster ?  
as the cluster is getting merge , we represent the "location " of each cluster by its 
centroid = average of its (data) points 
$$(\frac{x_1 +  x_2  + ... + x_y}{n} ,\frac{y_1 +  y_2  + ... + y_y}{n}  )$$

## 2. How to determine the nearness of clusters? 
 Measure cluster distances by distances of centroids 
 Merge two clusters with the shortest distance
![[data poibt.PNG]]


## K mean  clustering 

**K-Means Clustering:** [[K-Means]] is a basic algorithm used in machine learning for cluster analysis. In this method, data is represented as vectors in Euclidean space, and the Euclidean distance is used to measure the distance between data points.



**Choosing K in K-Means:** To evaluate the quality of the clustering, we look at the average distance of the data points to their respective centroids. This helps in determining the optimal number of clusters (k). 

![[7-picture1.jpg]]
- the chart show that the number 
-  $avg  = \frac{1}{N} *\sum^{N}_{i}{d(X_i , C_i)}$ 

##  BFG Algorithm


**BFR (Bradley-Fayyad-Reina) Algorithm:** [[BFR]] is an advanced version of the K-Means algorithm designed for large datasets and convex clusters. It is more efficient than K-Means for handling large data.
## Cure  

**CURE (Clustering Using REpresentatives):** CURE is an extension of the K-Means algorithm that can handle clusters of any shape. It does not require clusters to be of a specific shape and does not use centroids. Instead, clusters are represented by a set of representative points.

The CURE algorithm has two passes:

**Pass 1:**

- Load a small portion of the data and process it using in-memory hierarchical clustering.
- Choose representative points for each cluster. The more distant these points are from each other, the better. Move the representative points towards the center of the cluster and merge clusters that have close representative points.

**Pass 2:**

- Traverse the dataset again, assigning each data point to the cluster whose representative point is nearest to it.
![[7-picture2.jpg]]


# In non-Euclidean case : 
The only “locations” we can talk about are the points themselves. There are three main approaches 

## (1) How to represent a cluster of many points?
 pick a clustroid = point “closest” to other points 2,3. As the collection of points it is.

![[036f4519-8d2a-46f6-bea8-92ae07adcb59.png]]
- the example above is the D is choose because  C when compare in distince is the point where the other point is the longest , but CD is the shortest line  compare to the other so we choose D
## (2) How to determine the nearness of clusters? 


## Apporoach 1 : 
###  (1) How to represent a cluster:
Smallest maximum distance to other points
Smallest average distance to other points
Smallest sum of squares of distances to other points
- For  distance metrid d clustroid c of cluster C is $arg \sum_{x \in C} d(x,c)^2$ 


### 2) How to determine the nearness of clusters?
Treat clustroid as if it were centroid
Centroid is the avg. of all (data)points in the cluster.
Clustroid is an existing (data)point that is “closest” to all other points in the cluster.


## Approach 2 : 
### (1) How to represent a cluster? 
As the collection of points it is 
### (2) How to determine the nearness of clusters? 
Minimum of the distances between any two points, one from each cluster

Average distance of all pairs of points, one from each cluster

##  Approach 3 : 
### (1) How to represent a cluster?
As the collection of points it is 
### (2) How to determine the nearness of clusters? 
Define a notion of cohesion, and merge clusters whose union is most cohesive 
![[e942b0ab-9f10-4499-9e9b-3c7881dab0d2 (1).png]]
diameter of the merged cluster = maximum distance between points in the cluster 
average distance between points in the cluster 
Density of the merged cluster = divide by the number of points in the cluster by diameter or avg. distance

# (3)When do we stop merging clusters?

When some number 𝑘 of clusters are found (assumes we know the number of clusters) 
When stopping criterion is met
- § Stop if diameter exceeds threshold
- § Stop if density is below some threshold
- § Stop if merging clusters yields a bad cluster § E.g., diameter suddenly jumps
Keep merging until there is only 1 cluster left


# which design choice is the best 
It really depends on the shape of clusters. 
§ Which you may not know in advance. 
Example: we’ll compare two approaches: 
1. Merge clusters with smallest distance between centroids (or clustroids for non-Euclidean) 
2. Merge clusters with the smallest distance between two points, one from each cluster
## Case 1 : Convex Clusters 
Centroid-based merging works well. 
But merger based on closest members might accidentally merge incorrectly.
![[convd.PNG]]
## Case 2 : Concentric Clusters 

Linking based on closest members works well ¡ 
But Centroid-based linking might cause errors
![[circle.PNG]]

# Divisive  (top Down ) 
[[Divisive]] is start with one cluster and recursively split it 

## Point assignment : 
[[Point assignment]] Maintain a set of clusters Points belong to the "nearest" cluster 
