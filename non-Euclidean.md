# In non-Euclidean case : 
The only “locations” we can talk about are the points themselves. There are three main approaches 

## (1) How to represent a cluster of many points?
 pick a clustroid = point “closest” to other points 2,3. As the collection of points it is.

![[036f4519-8d2a-46f6-bea8-92ae07adcb59.png]]
- the example above is the D is choose because  C when compare in distince is the point where the other point is the longest , but CD is the shortest line  compare to the other so we choose D
## (2) How to determine the nearness of clusters? 

Treat clustroid as if it were centroid 
- **Centroid**: The centroid represents the average of all data points in a cluster. It serves as an “artificial” point.
- **Clustroid**: A clustroid is an existing data point within the cluster that is closest to all other points.
## Apporoach 1 : 
###  (1) How to represent a cluster:
Smallest maximum distance to other points
Smallest average distance to other points
Smallest sum of squares of distances to other points
- For  distance metridd clustroid c of cluster C is $arg \sum_{x \in C} d(x,c)^2$ 


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
