


# Introduction To course 
### Roles in Data Management

- **System Administrator (Store):** Primarily responsible for the installation and maintenance of software.
- **Database Administrator (Managed):** Overseeing the management of databases, ensuring their efficiency and security.
### Data Science as a Major

Data science is not a standalone course but a comprehensive major integrating various disciplines. It encompasses:

- **[[Data Mining]]:** Uncovering actionable insights from data.
- **Big Data:** Handling and analyzing massive datasets.
- **Machine Learning:** Utilizing algorithms to enable systems to learn and make predictions.

## what we will be learning 

To effectively analyze and manipulate such data, learners will delve into various tools and concepts:
1. **Linear Algebra:** Understanding and manipulating matrices and vectors, which are fundamental to handling high-dimensional data.
2. **Optimization:** Techniques for optimizing models and algorithms to improve their efficiency and performance in handling large datasets.
3. **Dynamic Programming:** A method for solving complex problems by breaking them down into simpler, overlapping subproblems, often used in optimization.
4. **Hashing (LSH and Bloom Filter):** Utilizing hashing techniques, such as Locality-Sensitive Hashing (LSH) and Bloom filters, for efficient data storage and retrieval.
In addition, the course will cover the concepts of streams and concurrency, as well as gradient vectors in machine learning and related fields. The overall goal is to equip learners with the skills necessary to work with diverse and complex data types and structures.

# Overview  

## Big data architecture 
[[single node architecture]]
[[ cluster architecture ]]

## Type of data 
data is high dimensional 
	- dữ liệu đa chiều là dữ liệu  vd : ma trận vector 
 data is a graph 
	 - mỗi trang web là một đỉnh mỗi link là canh đến trang web đó 
data is infinite never ending 
	- dữ liệu giao dịch rất liên tục nên ngân hàng cần dc lưu trữ 
data is labeled
### Descriptive method 
Find human interpretable patterns that describe the data  
- interpretable patterns  (là quy luật mà con người có thể hiểu để giải thích về data) 
### Predictuve method 
Use some varibables to predict unknown or future values of otheer varibales (sử dụng các biến dữ liệu cần có để dự đoán dữ liệu còn thiếu ) 
- giá vàng tuần vừa qua dự đoán cho giá vàng năm sau
-  Recommender System : hệ thống thiếu nghị dự đoán thông tin trong tương lai 

## Large-scale Computing 
### Machine failure 
a  server may stay up for 3 year (1000 days) 
1000 servers , expect to lose 1/day 
with 1m machines 1000 machines fail every day 
Issue : 
Copying data over a network takes time 
idea : 
- bring computation to data 
	- thay vì cho một data lớn vào bộ xử lý , cắt nhỏ thành từng chunk xong xử lý trong từng máy tinh xong gửi lại kết quả 
store files multiple time for reliability (lưu file nhiều lần) : 
- để ngăn chặn tình trạng máy tính mất data thì mình phải đánh đổi bộ nhớ với dộ tin cậy , thường xuyên tạo snap shot để có bảo hiểm  lấy lại  data 
##  redundant storage infrastructure  
Storage infrastructure  (file system  là nơi lưu trữ thao túng xử lý tập tin và thư mục)  
## different type of file system 

[[distributed file system ]]


