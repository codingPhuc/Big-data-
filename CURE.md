Belong to the [[Clustering#Hierarchical]] [[non-Euclidean]] [[Hierarchical#Agglomerative(bottom up)]]
**CURE (Clustering Using REpresentatives):** [[CURE]] is an extension of the K-Means algorithm that can handle clusters of any shape. It does not require clusters to be of a specific shape and does not use centroids. Instead, clusters are represented by a set of representative points.

The CURE algorithm has two passes:

**Pass 1:**

- Load a small portion of the data and process it using in-memory hierarchical clustering.
- Choose representative points for each cluster. The more distant these points are from each other, the better. Move the representative points towards the center of the cluster and merge clusters that have close representative points.

**Pass 2:**

- Traverse the dataset again, assigning each data point to the cluster whose representative point is nearest to it.
![[7-picture2.jpg]]
