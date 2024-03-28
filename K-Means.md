
belong to the [[Clustering#Point assignment]] [[Euclidean]]
**K-Means Clustering:** K-Means is a basic algorithm used in machine learning for cluster analysis. In this method, data is represented as vectors in Euclidean space, and the Euclidean distance is used to measure the distance between data points.

**Representation of a Cluster in Euclidean Space:**

- A cluster is represented by its centroid, which is a virtual or ‘fake’ point calculated by taking the average of all points in the cluster.
- The distance between two clusters is determined by the distance between their centroids.

**K-Means Algorithm:**

- Initialize k centroids (these are illusionary or ‘fake’ centroids).
	- To find the initial k centroids, it is recommended to choose centroids that have the smallest Euclidean distance to the other points.
- For a given number of points N, choose a random centroid.
- Repeat the following steps until convergence (hội tụ) (i.e., when the centroids move insignificantly compared to the previous iteration):
    - For each data point, assign it to the cluster whose centroid is nearest.
    - After assignment, update the centroids.

K-Means is suitable for data where the clusters are convex in shape.
