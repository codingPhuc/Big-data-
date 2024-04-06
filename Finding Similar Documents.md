

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



# Video  


![Lecture 12 — Finding Similar Sets](https://www.youtube.com/watch?v=ZsXIuJtjsWk&list=PLLssT5z_DsK9JDLcT8T62VtzwyW9LNepV&index=12)
• Section 1 (Timestamp: 0:00 - 2:02):  
o Bullet point 1: Introduction to the concept of finding similar sets in a large collection of sets.  
o Bullet point 2: Discussion on the notion of Jard similarity and the need for a way to focus on pairs of sets that are likely to be highly similar.  
o Bullet point 3: Comparison to the idea of hashing and the use of locality sensitive hashing to find similar sets without having to compare all pairs.  
o Bullet point 4: Overview of the applications of finding similar sets in data mining, such as identifying web pages on the same topic or determining duplicate records of data.  
o Bullet point 5: Focus on the specific application of finding lexically similar documents in a large collection.  
o Bullet point 6: Discussion on the three key techniques that will be covered in the video: shingling, minhing, and locality sensitive hashing.  
o Bullet point 7: Mention of potential false positives and false negatives in the algorithms used, but the ability to control them through parameter selection.

• Section 2 (Timestamp: 2:02 - 4:26):  
o Bullet point 1: Explanation of shingling as the process of converting a document into a set of strings of a chosen length.  
o Bullet point 2: Purpose of shingling to convert documents into sets that have a lot in common, making it easier to find similar sets.  
o Bullet point 3: Mention of the potential for false positives and false negatives in this process.  
o Bullet point 4: Overview of the steps involved in finding similar sets without comparing all pairs: shingling, minhing, and locality sensitive hashing.

• Section 3 (Timestamp: 4:26 - 6:29):  
o Bullet point 1: Discussion on the second key technique, minhing, which involves constructing signatures for the sets of shingles.  
o Bullet point 2: Explanation of the resulting short vector of integers as the "signature" for a set and its similarity to another set.  
o Bullet point 3: Key property of minhing: the number of components in which two vectors agree is the expected value of the similarity of the underlying sets.  
o Bullet point 4: Discussion on the importance of choosing the right parameters to minimize false positives and negatives.

• Section 4 (Timestamp: 6:29 - 8:16):  
o Bullet point 1: Introduction to the third key technique, locality sensitive hashing (LSH).  
o Bullet point 2: Purpose of LSH to avoid having to compare all pairs of signatures by focusing on pairs that are likely to be similar.  
o Bullet point 3: Explanation of the process of LSH, which involves dividing the signature vectors into bands and rows and comparing only the signatures in the same band and row.  
o Bullet point 4: Mention of the ability to control the number of bands and rows to control the probability of false positives and negatives.

• Section 5 (Timestamp: 8:16 - 9:49):  
o Bullet point 1: Summary of the overall process for finding similar sets: shingling, minhing, and LSH.  
o Bullet point 2: Mention of the potential for false positives and negatives in the final results.  
o Bullet point 3: Emphasis on the ability to control these errors through parameter selection.  
o Bullet point 4: Conclusion that the techniques learned in this video can be applied to various applications in data mining and information retrieval.


• Section 6 (Timestamp: 9:49 - end):  
o Bullet point 1: Recap of the main points covered in the video, including the applications of finding similar sets and the three key techniques of shingling, minhing, and LSH.  
o Bullet point 2: Reminder of the importance of parameter selection to minimize false positives and negatives.  
o Bullet point 3: Conclusion that the techniques learned in this video can be applied to various applications in data mining and information retrieval. 
o Bullet point 4: Suggestion to watch the next video in the series to learn more about the details of implementing these techniques. 


![Lecture 13 — Finding Similar Sets](https://www.youtube.com/watch?v=ZjdQD79Psi0&list=PLLssT5z_DsK9JDLcT8T62VtzwyW9LNepV&index=13)


Section 1 (Timestamp: 0:00 - 1:45):

- Introduction to the topic of sets and similarity
- Definition of Jaccard similarity and its use in comparing sets
- Importance of constructing signatures using Min hashing technique to determine similarity

Section 2 (Timestamp: 1:45 - 3:30):

- Description of representing large collections of sets as a single Boolean Matrix and its usefulness
- Explanation of the universal set and its role in representing sets
- Example of a sparse Matrix representing books bought by Amazon customers

Section 3 (Timestamp: 3:30 - 5:00):

- Explanation of four different types of rows in a Matrix based on the presence of bits in each column
- Use of these types to calculate Jaccard similarity between two columns
- Importance of sparsity in the Matrix for typical applications

Section 4 (Timestamp: 5:00 - 6:45):

- Introduction to Min hashing and its association with permutations of rows in the Matrix
- Definition of Min hash function and its use in creating signatures for columns in the Matrix
- Importance of selecting multiple Min hash functions for each column

Section 5 (Timestamp: 6:45 - 8:20):

- Example of applying Min hash functions to a Matrix with four columns and seven rows
- Explanation of how the first component of the signature for each column is determined using a random permutation
- Importance of discovering Min hash values for each column in the first few rows of the permuted order

Section 6 (Timestamp: 8:20 - 11:00):

- Explanation of how to determine the next component of the signature for each column using a different random permutation
- Importance of stopping the process once all Min hash values have been discovered for each column
- Example of applying Min hashing to a larger Matrix with eight columns and 20 rows

Section 7 (Timestamp: 11:00 - 13:50):

- Explanation of how to use signatures to compare the similarity of two columns in the Matrix
- Importance of comparing the signatures rather than the original columns for efficiency
- Example of calculating the Jaccard similarity between two columns using their signatures

Section 8 (Timestamp: 13:50 - 17:10):

- Explanation of how to generalize Min hashing for larger collections of sets and Matrices
- Importance of using the same set of Min hash functions for the entire collection
- Example of calculating the similarity of two collections of sets using Min hashing and Jaccard similarity

Section 9 (Timestamp: 17:10 - 18:45):

- Explanation of how to use Min hashing and signatures for document similarity
- Importance of choosing an appropriate value for k in k-shingling
- Example of comparing the similarity of two documents using Min hashing and Jaccard similarity

Section 10 (Timestamp: 18:45 - 21:25):

- Explanation of how to extend Min hashing to handle weighted sets and document similarity
- Importance of adjusting the definition of Min hash function for weighted sets
- Example of comparing the similarity of two documents with weighted terms using Min hashing and Jaccard similarity

Section 11 (Timestamp: 21:25 - 23:00):

- Conclusion and summary of the key points covered in the video transcript
- Importance of Min hashing for efficient calculation of set and document similarity
- Potential applications of Min hashing and Jaccard similarity in various fields such as data mining and information retrieval.




![# Lecture 14 — Locality Sensitive Hashing](https://www.youtube.com/watch?v=e8dA0tscrCM&list=PLLssT5z_DsK9JDLcT8T62VtzwyW9LNepV&index=14)
•Section 1 (Timestamp: 0:00-0:39):
- Introduces the concept of locality sensitive hashing (LSH) for Minhash signatures.
- Documents are converted into sets of shingles and then into short signatures consisting of integer vectors.
- Signatures can be compared to estimate their Jaccard similarity.
- LSH is used to create a shortlist of candidate pairs of similar signatures without comparing all pairs.
- The goal is to reduce the time needed to find similar pairs by hashing signatures into buckets.

Section 2 (Timestamp: 0:41-1:19):
- LSH is applied to signature matrices.
- A large number of hash functions are created, not necessarily Minhash functions.
- Columns of the matrix are hashed into buckets using the hash functions.
- All pairs within the same bucket are considered as candidate pairs.
- The number of hash functions and buckets needs to be tuned to balance performance and accuracy.

Section 3 (Timestamp: 1:22-2:08):
- The definition of similarity is determined by a threshold value (T) for Jaccard similarity.
- The similarity of signatures is measured by the fraction of agreeing components (rows) in the signature matrix.
- A pair of signatures is a candidate pair if they have the same components in at least one band.
- The goal is to ensure that most similar pairs are 100% similar in at least one band while minimizing false positives.

Section 4 (Timestamp: 2:11-2:43):
- The process of creating hash functions for LSH is illustrated.
- The signature matrix is divided into multiple bands, each consisting of several rows.
- A hash function is created for each band, hashing the values of a column within that band.
- The number of buckets determines the granularity of similarity detection.

Section 5 (Timestamp: 2:45-3:04):
- The trade-off between the number of bands (B) and the number of rows per band (R) is discussed.
- Increasing B and decreasing R increases the chances of similar pairs hashing to the same bucket.
- A larger number of bands is suitable for low similarity thresholds, while a smaller number is better for high thresholds.

Section 6 (Timestamp: 3:07-3:38):
- The intuition behind selecting the number of bands and rows is explained.
- If most components of two signatures agree, there is a higher probability of finding 100% agreement in at least one band.
- If the number of common components is low, the likelihood of 100% agreement in any band decreases.

Section 7 (Timestamp: 3:40-4:00):
- The constraint that the product of B and R must equal the length of the signatures is emphasized.
- The length of the signatures corresponds to the number of Minhash functions used initially.
- The number of buckets needs to be chosen based on computational limitations and desired accuracy.

Section 8 (Timestamp: 4:02-4:45):
- The condition for a candidate pair is that they hash to the same bucket for any band.
- The importance of finding at least one band with 100% agreement for similar pairs is highlighted.
- The number of bands and rows must be carefully tuned to achieve the desired similarity detection.

Section 9 (Timestamp: 4:55-5:02):
- The video shows an example of one hash function for LSH on signature matrices.
- Columns 6 and 7 hash to different buckets, indicating they are not motivated for similarity comparison.
- The possibility of other hash functions placing them in the same bucket is acknowledged.

Section 1 (5:25-5:59):
- Introduction to the concept of agreement and similarity between pairs.
- If two pairs have many components in common, there is a good chance of 100% agreement in some band.
- Few common components between pairs result in unlikely 100% agreement in any band.
- The need to tune BNR (bands and rows) to achieve the desired similarity threshold.

Section 2 (6:01-6:25):
- The constraint that B * R must equal the length of the signatures.
- Increasing B and decreasing R leads to more bands and more opportunities for pairs to be in the same bucket.
- If the similarity threshold is low, a larger number of bands is beneficial.
- If the similarity threshold is high, a smaller number of bands is preferable.

Section 3 (6:28-7:43):
- Visual representation of a hash function for LSH on signature matrices.
- Explanation of bands and buckets.
- Example of columns hashing to different buckets and not being considered a candidate pair.
- Example of columns hashing to the same bucket and being considered a candidate pair.

Section 4 (7:53-8:07):
- Probability of false positives and negatives in LSH.
- Neglecting the small probability of non-identical segments hashing to the same bucket.
- Probability calculation based on the agreement of columns in a band.

Section 5 (8:15-9:04):
- Example scenario for understanding probabilities in practice.
- 100,000 columns representing 100,000 documents.
- Signatures of length 100, resulting in a 100x100,000 signature matrix.
- Space requirement for signatures is 40 megabytes.
- Similarity threshold set at 80%.

Section 6 (9:04-10:12):
- Division of the signature matrix into 20 bands with 5 rows each.
- Consideration of columns with 80% Jaccard similarity.
- Probability calculation for columns hashing to the same bucket in a band.
- Probability of a false negative (pair with 80% similarity not being a candidate pair).

Section 7 (10:12-13:04):
- Consideration of columns with 40% Jaccard similarity.
- Probability calculation for columns hashing to the same bucket in at least one band.
- Higher false positive rate (20%) for lower similarity of underlying sets.
- False positive rate decreases as the similarity of underlying sets decreases.
- The exact number of false positives depends on the distribution of Jaccard similarities among the sets.

Section 1 (Timestamp: 13:09-13:46):
- Discusses the false positive rate falling as the similarity of underlying sets decreases.
- The number of false positives depends on the distribution of Jaccard similarities among the underlying sets.
- If most pairs of sets are highly similar, there will be many false positives.
- If typical pairs of sets have a low Jaccard similarity, there will be very few false positives.

Section 2 (Timestamp: 13:49-14:26):
- Introduces the problem of designing an LSH (Locality Sensitive Hashing) scheme from a Minhash Matrix.
- Aims to have the probability of two columns sharing a bucket as a step function with a threshold.
- If the similarity of underlying sets is below the threshold, there should be zero chance of their signatures sharing a bucket.
- If the similarity exceeds the threshold, the signatures should surely become a candidate pair.

Section 3 (Timestamp: 14:29-15:00):
- A single row of a signature Matrix gives a straight line.
- The probability of two hash values equaling the Jaccard similarity of the underlying sets follows a theorem.
- There are still false positives and negatives when using a single row and a given threshold.

Section 4 (Timestamp: 15:00-17:00):
- Combining many Minhash functions into B bands of R rows each reduces false positives and negatives.
- The function that relates the probability of two sets becoming a candidate pair to the similarity of the sets is derived.
- As B and R get large, the function resembles a step function with a threshold.
- Sample values of the S curve are provided.

Section 5 (Timestamp: 17:00-18:01):
- Summary of the steps to find sets with a given threshold of Jaccard similarity.
- The choice of values for B and R affects the shape of the S curve and the number of false positives and negatives.
- Longer signatures result in a closer approximation to a step function but require more space and computation.
- Running the LSH provides candidate pairs, and their signatures are examined to measure the similarity against the threshold.

Section 6 (Timestamp: 18:01-19:03):
- The similarity of signatures may overestimate the similarities of the underlying sets.
- Computing the Jaccard similarity of the underlying sets can eliminate false positives.
- False negatives cannot be eliminated this way.
- Some pairs of sets with a Jaccard similarity above the threshold may never become a candidate pair.