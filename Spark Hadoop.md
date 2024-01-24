 Storage infrastructure - file system  là nơi lưu trữ thao túng xử lý tập tin và thư mục 
	- Google : GFS 
	- file trong course này cắt nhỏ thành các chunk xong xử lý nó nhiều nơi 
- Programming model 
	- MapReduce 
	- Spark 
Problem : 
- if nodes fail how to store data persistently ? 
Typical usage pattern : 
- data is rarly change 
trong môt distributed system có những loại máy tính sau 
- chunk server hay data node dùng để lưu trữ các chunk 
	- chunk là mỗi loại data nhỏ thường từ 16-64 mb các chunk thường dc nhân bản lên (x2 và x3 )
	- giữ nhân bản của chunk 
Master node 
- Name Node in hadoop HDFS
	- lưu trữ metadata (cấu trúc và vị trí lưu trữ các chunk)
 - master node is improtance if it is detroye it is more costly to repalc than data node 
- Stores metadata about where files are stored 
- Master nodes are tyically more robust to hardware failure and run critical cluster services 
- secondary name node is the alternative name of master node 