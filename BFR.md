**BFR (Bradley-Fayyad-Reina) Algorithm:** BFR is an advanced version of the K-Means algorithm designed for large datasets and convex clusters. It is more efficient than K-Means for handling large data.

**Input Requirements:**

- Data is represented in Euclidean space.
- In Euclidean space, a cluster is represented by its centroid.
- The distance is measured by the distance between two centroids.

**BFG Algorithm:** Centroids cannot be created by averaging. The steps of the algorithm are as follows:

1. Initialize k distinct centroids.
2. Load a batch of data.
    - For the loaded batch of data, assign the data points to the cluster with the nearest centroid, ensuring that the distance between the data point and the centroid does not exceed a predefined threshold S (close enough).
    - For data points that are not close enough, perform clustering and create new clusters.
    - Merge the newly created clusters from step 4 with the original clusters if they are close enough.
    - Repeat steps 2 to 5 until all data has been processed.

**Step 1:** Load the first batch of data and initialize k centroids. There are several approaches:

- Approach 1: Take k random points.
- Approach 2: Perform clustering to get k centroids.
- Approach 3: Sequentially select data points such that each subsequent point chosen is as far away as possible from the previous point.

**Step 2:** Load the next batch of data.

**Step 3:** With the newly loaded batch of data, add them to the dataset DS if those point are closest in the cluster. 

**Step 4:** For data points that are not close enough, perform in-memory clustering. Points that go into a new cluster go into CS, points that are outliers go into RS.

**Step 5:** For the data points in DS:

- Update the cluster: Add N, sum, SUMSQ.
- Consider merging the newly created clusters with the original clusters.

Merge all new clusters and outlier points into the nearest cluster.


**Summary:**

- It’s necessary to store information about the number of data points (N), the sum of the data points, and the sum of squares (SUMSQ) of the data points.
- The average is calculated as
    
    $$\frac{1}{N} \sum^{N}_{i}{d(X_i , C_i)^2}N1​i∑N​d(Xi​,Ci​)2$$
    

The reason why this math is needed:

- The centroid is calculated as
    
    $$\frac{sum}{n}​$$
    
- The variance is calculated as
    
    $$\frac{SumSQ}{n} - (\frac{sum}{n})^2 = E [x^2] -(E [x]) ^2 = avg = \frac{1}{N} \sum{}(X_i - X)^2nSumSQ​−(nsum​)2=E[x2]−(E[x])2=avg=N1​∑(Xi​−X)2$$
    

In each iteration of the BFG algorithm, three sets are created:

1. **DS (Discard Set)**: Contains data points that are close enough to be assigned to the existing clusters.
2. **CS (Compression Set)**: Performs clustering.
    - For data points that are not close enough, clustering is performed to create new clusters.
    - Data points that belong to the newly created clusters are added to CS.
    - Outlier data points are added to RS.
3. **RS (Retained Set)**: Contains outlier data points.

DS contains the original cluster points, CS contains points that are close to the original cluster, and RS contains distinct points.