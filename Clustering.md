

# The Problem of Clustering 
given  a set of many points , which the notation of distince between nodes , group the points into some number of clusters , so that : 
- Members of the same clusters  are close similar to each other 
- members of different cluster are dissimilar 
usually : 
- Points are in high dimensional  space 
- Similarity is defined using a distince measure 
	- [[Math Formula#distance equation]]
# Clustering  Strategies  

## Hierarchical 
- Agglomerative
	- [[Agglomerative]] is Initially, each point is classify as a cluster , repeatedly combine the two "nearest " cluster into one 
- Divisive
	- Start with one cluster and recursively split it
## Point assignment : 
[[Point assignment]] Maintain a set of clusters Points belong to the "nearest" cluster 
# Is the space Euclidean or non Euclidean 

1. How to represent a cluster ? 
2. How to determine the nearness of clusters ? 
3. when to stop merging cluster ? 
### Euclidean 

[[Euclidean]]
- Points are vectors of a real numbers , i.e coordinates 
- summarize or give a label or id of points in a cluster as their average name centroid  
$$(\frac{x_1 +  x_2  + ... + x_y}{n} ,\frac{y_1 +  y_2  + ... + y_y}{n}  )$$
Different type of distance measure used : 
L2 norm (Mahata distance) :  $\sqrt{(x_1 - x_2)^{2} -  (y_1 - y_2)^{2}}$
L1 norm  : $|x_1  -x_2| +|y_1  -y_2|$ 

### non Euclidean 

[[non-Euclidean]]
There is no notion of location , and centroid  
We summarize a collection of points different  
Distance measure  Jaccard, Hamming, cosine
# Does the data fit in memory or does it reside on disk 
In-memory clustering
is more straightforward 
Example: K-means § Large-data clustering requires loading one batch of data at a time, cluster them in memory and keep summaries of clusters § Example: BFR, CURE


# Hierarchical vs point  assignments 

Point assignment good when clusters are nice, convex shapes:  
![[disafdsfds.PNG]]
Hierarchical can win when shapes are weird: § Note both clusters have essentially the same centroid.
![[eulice.PNG]]

# When do we stop merging clusters?

When some number 𝑘 of clusters are found (assumes we know the number of clusters) 
When stopping criterion is met
-  Stop if diameter exceeds threshold
-  Stop if density is below some threshold
-  Stop if merging clusters yields a bad cluster § E.g., diameter suddenly jumps
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


# Choosing K mean 

**Choosing K in K-Means:** To evaluate the quality of the clustering, we look at the average distance of the data points to their respective centroids. This helps in determining the optimal number of clusters (k). 

![[7-picture1.jpg]]
- the chart show that the number 
-  $avg  = \frac{1}{N} *\sum^{N}_{i}{d(X_i , C_i)}$ 
# Clustering Algorithm 
- [[CURE]]
- [[BFR]]
- [[K-Means]]