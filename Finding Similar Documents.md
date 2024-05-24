

- The course is related to High Dimensional data.
- Vectors in big data need to be high dimensional.
- Given a query image patch, the goal is to find similar images.
- Data transformation is the act of transforming data from one form to another, usually in vector form. This includes vector features and vector embeddings.
- In computer science, we prefer to transfer the data from any type to numeric.
- There are different distance measures such as Euclidean Distance, Manhattan Distance, and Cosine Distance.



1. **High Dimensional Data Points**: These are data points that exist in a space with a high number of dimensions. For example, an image can be represented as a long vector of pixel colors.
    
2. **Distance Function 𝒅(𝒙𝟏, 𝒙𝟐)**: This is a function that quantifies the “distance” or difference between two data points 𝒙𝟏 and 𝒙𝟐.
    
3. **Goal**: Given a query point 𝒒, the goal is to find data points 𝒙𝒋 that are within a distance threshold 𝒔, i.e., 𝒅(𝒒, 𝒙𝒋) ≤ 𝒔. The naive solution would take 𝑶(𝑵) time complexity, where 𝑵 is the number of data points. However, with a suitable data structure or algorithm, this can be improved to 𝑶(1) time complexity.



# Algorithm  Finding Similar Document  

## Shingling
**Shingling**: This is a process of converting a document into a boolean vector. It involves creating ‘shingles’ or tokens from the document. For example, given a document D1 = “abcdef”, we can create shingles C1 = {ab, bc, cd, de}. This helps in comparing documents and maintaining the structure of the document even when a word changes. 
what need to do ? 
- how to convert the document into shingle  
- k is the number of character in a world 
- we need to create a set of !k  of every single word  in the document 
- we convert the shingles word into boolen matrix like bellow 
![[20240306_170311.jpg]]
    
**Jaccard Distance**: This is a measure of dissimilarity between two sets. It’s defined as the size of the intersection divided by the size of the union of the two sets. 
- the Jaccard Distance is used on the $C_1 , C_2$ Column 
- the union of  $C_1 , C_2$  is the number of time the $C_1 , C_2$   is true in a row  and 
- The Intersection of $C_1 , C_2$ is when $C_1 , C_2$ is true in the same row
    ![[20240306_163409.jpg]]

## **Min Hashing**
**Min Hashing**: This is a technique for converting a boolean vector into a signature vector. It uses a hash function to convert a boolean vector into a signature (unique vector). If two vectors are similar, their signature vectors should also be similar. The process involves permuting the rows of the boolean matrix using some permutation function 𝜋 (not to be confused with the mathematical constant 𝜋). The minhash of a vector is the first value containing a number different from 0 after applying the permutation function. 
- we have a boolean matrix with nxm 
-  the Permutation  matrix  is   K number of nx1 matrix to be apply on the boolean matrix  , The element  contain in the Permutation matrix is number from (1-> m column of the boolean  matrix)    which is randomly shuffle  in each row of the matrix 
- we have 3 matrix the k number of permutation matrix , the input matrix and the Signature matrix 
	1. We begin with a permutation matrix, which we’ll refer to as `pink`.
	2. We examine each element in `pink`.  we start from  the element with the lowest value in the pink.
	 3. we map that element with  The row number in a Permutation matrix corresponds directly to the same row number in the Input matrix  
	 4. if the element in input matrix row position is 1 then we will add the element in the pink matrix to Signature matrix if not then leave that position in the signature matrix empty 
	 5. go to the next lowest value element in the pink matrix 
	 6. repeat 2. until all row in the signature matrix is fill 
	 7. repeat the step above for all The permutation matrix until we have kxn Signature matrix with k = k number of Permutation matrix 
-  The element with the number 1 in the pink matrix is mapped to the Signature matrix. This mapping is guided by the corresponding row in the Boolean matrix. Specifically, the second and fourth positions in this row are marked as 1. Therefore, these positions in the Signature matrix are updated with the value from the pink matrix, which is 1. 
- The element with the number 2 in the pink matrix is mapped to the Signature matrix. This mapping is guided by the corresponding row in the Boolean matrix. Specifically, the first and third positions in this row are marked as 2. Therefore, these positions in the Signature matrix are updated with the value from the pink matrix, which is 2.
![[Pasted image 20240405114307.png]]

**Calculation using Jaccard Distance**
**Jaccard Distance**: This is a measure of dissimilarity between two sets. It’s defined as the size of the intersection divided by the size of the union of the two sets. it can also be used to calculate between two Column in the Signature matrix with the column being h(C1) and h(C3)
[h(C1) = h(C3)] = Sim(C1, C3)  
- in the bellow the number of row in the C1 and C3 in the input matrix that is true is 4 and the number of row which is true in both column is 3 so  the result of Jaccard is 0.75
- in the Signature matrix the number row in a column is 3 and the number of time the same number appear in the same row in the two column is 2 so the result is 0.67
![[minhashfunction_1.PNG]]



The similarity between two signature vectors is determined by the proportion of matching element pairs between them.
For example, consider two signature vectors `s1 = [2,2,1]` and `s2 = [2,4,1]`. Here, the first and third elements of `s1` match with the first and third elements of `s2`. So, out of 3 total elements, 2 elements match. Therefore, the similarity between `s1` and `s2` is `2/3 = 0.67` or 67%.

## **Locality-Sensitive Hashing (LSH)**
**Locality-Sensitive Hashing (LSH)** is a method used in data mining and machine learning to identify items that are similar. It hashes input items in such a way that similar items map to the same “buckets” with high probability. This makes it possible to identify candidate pairs of similar items without having to compare every pair of items in the dataset, which can be computationally expensive. In the context of signature vectors, LSH can be used to quickly find pairs of signatures that are similar.

![[20240306_174232.jpg]]
![[signature matrix.PNG]]
1.  **Partition Signature Vectors into Bands**: The signature vectors are divided into segments or “bands”. Each band contains a portion of the signature vector. 
	- example a  we create a boolean matrix of 100k column we convert it into a 100 integer Signature matrix of 100x100k meaning the matrix have 100 minhash function apply to it creating 100 row and 100k column 
	- we split it into 20 band so the number of band is 20 and the number of row per band is 5 integer/band 
2.  **Hash Each Band**: Each band is hashed separately. This means that a hash function is applied to the elements in each band. 
	- in a band we hash each column in that band into a bucket which will become a candidate pairs 
![[Pasted image 20240405175055.png]]
    
3. **Bucket Signature Vectors**: The hashed bands are then placed into “buckets”. Each bucket corresponds to a range of hash values. Signature vectors that hash to the same value for a particular band are placed in the same bucket.
    
4. **Candidate Pairs**: Two signature vectors are considered a “candidate pair” if they hash to the same bucket for at least one band. This means that they are likely to be similar.

# Question to ask teacher 
- does the `,` `.` count as a word to be single does the space count as word to be single 
- Student groups develop a program illustrating the operation of the implemented class,  
visualizing and evaluating the results of the approxNearestNeighbors() function 
	-  do I need  illustrated the diagram using graph and chart ? or do I need to just implement the program 
 
[[Video  FSD]]

[[code for 20% project]]