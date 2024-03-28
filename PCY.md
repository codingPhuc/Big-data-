


During the first pass of the PCY (Park-Chen-Yu) algorithm:

1. Most of the memory is idle. This idle memory is used to keep counts of buckets. Each bucket corresponds to a pair of items that are hashed together. Note that the buckets don’t store the pairs themselves, but rather the count of the number of pairs.
    
2. For each #Basket  in the dataset, the algorithm performs the following steps:
    
    - Enumerates all pairs of items in the basket.
    - Hashes each pair.
    - Increments the count of the bucket that corresponds to the hashed pair by 1.

A bucket is considered frequent if its count is at least equal to the support threshold. If a bucket is not frequent, then no pair that hashes to it is considered frequent.

During the second pass of the PCY algorithm, only pairs that [[hashes]] to frequent buckets are counted.

I hope this makes the process clearer Let me know if you have any more questions.

![[PCY.PNG]]
- in the first #Passes  :
	- item count is a collection of singleton items like [[A priori]]
	- generate pair bases on the input item counts   then map them to a bucket 
 
- the second #Passes :
	- will contain  the frequent item that meet the required support threshold  like [[A priori]]
	- the bitmap which is the bucket that have a positive number of hash item  , when a bucket have item it will increment by 1 if it is bellow a threshold then it will be map to the bitmap as a 0 bit if it is above then it will be a 1 bit 
	- the rest are candidates pair that are generated  by the frequent item 
## Pass 1 Memory Organization : 
Space to count each item  . 
- One (typically) 4-byte integer per item  
Use the rest of the space for as many integers , representing bucket , as we can 
```
For(each basket)
{
	For(each item in the basket)
		add 1 to items count ; 
	For (each pair of items)
		hash the pair to a bucket ; 
		add 1 to the count for that bucket 
}
```

### Observation About bucket 
1. A bucket that a frequent pair hash to is surely frequent  
- we cannot use the hash table to eliminate any member of this bucket 
2. Even without any frequent pair , a bucket can be frequent (this is bash on the chances that those pair are subset of 2 frequent items)
- Again nothing in the bucket can be eliminated 
3.  But in the best case the count for a  bucket is less than the support s 
- now all pair that hash to this bucket can be eliminated as candidates , even if the pairs consist of two frequent items 
### between Passes 
Replace the bucket by a bit vector (the "bitmap") 
- 1 mean the bucket is frequent  ; 0 means it is not 
4-bytes integers are replace by bits  , so that bit-requires 1/32 of memory  
also , decide which items are frequent and list them for the second pass 



## Pass 2  : 
Count all pairs {i , j } that meet the conditions  for being a candidate pairs: 
1. both i and j are frequent items 
2. the  pair(i, j) hashes to a bucket number whose bit in the bit vector is 1 


# Coding Implementation 
Use PySpark library to implement the PCY class to perform the corresponding algorithm.  
• Constructor: receives a path to a file consisting of baskets from task 2; constant s is  
the support threshold (i.e., s = 0.3); constant c is the confidence threshold (i.e., c =  
0.5).  
• run(): run the algorithm. After that,  
o Save the resulted DataFrame consisting of frequent pairs to  
pcy_frequent_pairs.csv  
o Save the resulted DataFrame consisting of association rules to  
pcy_association_rules.csv.  
o Schemas of DataFrames are based on the one of FPGrowth.  
• Note:  
o Source code must follow big data principles, avoid installing functions that  
contain pure data in the main memory.  
o Students may implement additionaly attributes and methods to support your  
work. However, ensure that source code are compact and optimal.  
o Do not use any libraries directly providing PCY implementation.

1.  understand the PySpark  libary 
2.  PCY programming algorithm look for example online for how to build the algorithm 
3. write pesudo code to understand the structure of how to implement the code 
4. find implementation of the algorithm 
5. check on how to implement the Constructor bases on the detail the constructure should take in 3 parameter 1 is the file from task 2 , 2 is the constant s the support threshold  and 3 c the confidence threshold 
6. implement the run() function 
7. check out what FPGrowth is about 

## step by step process 
### used data in task 2 
the data in task 2 output should be in two format 
```
data = [("date1", "customer1", "washing machine,coffee"),

        ("date1", "customer2", "airdried,soda,drying machine"),

        ("date2", "customer1", "washing machine,airdried"),

        ("date3", "customer2", "drying machine"),

        ("date3", "customer1", "washing machine")]
```
- the data here with the first column being the date the second being the customer the third being the list of item that customer bought in that day 
the reason  : 
- this will make visualization of the print data more eye catching  
- convenient for sorting or manipulation 
- the value that are separate by comma  help reduce data redundancy 
implementation of task 3  
### algorithm implementation 
The purpose of the PCY algorithm is to find the frequency of an items  
first pass :   
```
For(each basket)
{
	For(each item in the basket)
		add 1 to items count ; 
	For (each pair of items)
		hash the pair to a bucket ; 
		add 1 to the count for that bucket 
}
```
second pass :  
```
bitmap = []
for (each bucket in buckets )
	if(bucket.count() < support)
		bitmap({bucket :{0})
	else 
		bitmap({bucket :{1})
for ( each item in items )
	if(item.count() <  support)
		remove(item) from items  
generate all posible pair of items 
for( each  item_par  in item_pars  ): 
	if(bitmap{item_par} == 0 )
		item_pars.remove(item_par)

 ```



```
# First pass
for basket in all_baskets:
    for item in basket:
        increment_count(item)
    for pair in all_pairs_in(basket):
        bucket = hash(pair)
        increment_count(bucket)

# Second pass
bitmap = []
for bucket in all_buckets:
    if count(bucket) < support:
        bitmap[bucket] = 0
    else:
        bitmap[bucket] = 1

for item in all_items:
    if count(item) < support:
        remove(item)

all_pairs = generate_all_possible_pairs_of_items()
for pair in all_pairs:
    if bitmap[hash(pair)] == 0:
        remove(pair)

```
## output bases on Frequent Pattern Growth 
### pcy_frequent_pairs.csv file output
the require frequence items set output should be something  with 1 column being the items(can be one singuler items or a pair of items ) and the other being the frequence 
[example link](https://www.philippe-fournier-viger.com/spmf/FPGrowth.php)
### pcy_association_rules.csv file output 
the output should be a pair and check should check the confident level of each pair as well 
example : 
let say we have frequent pair  : {a,b} 
then we need to check a->b and b->c  
check using the equation a|b /b the confident of a is base on a given b divided by b 

- The antecedent items of the rule are listed first. Each item is represented by an integer and followed by a space.
- The string “==>” is used to separate the antecedent and consequent items.
- The consequent items of the rule are listed next. Each item is represented by an integer and followed by a space.
- The string " #SUP: " is used to indicate the support of the rule, which is represented by an integer.
- The string " #CONF: " is used to indicate the confidence of the rule, which is represented by a double value between 0 and 1 (inclusive).
[example link](https://www.philippe-fournier-viger.com/spmf/AssociationRules.php)

## question to ask instructor 
what format does the file in task 2 belong in ? 
Save the resulted DataFrame consisting of frequent pairs to   pcy_frequent_pairs.csv 
 - what is the result that is being save, should it be save in any format  ? 
 Save the resulted DataFrame consisting of association rules to   pcy_association_rules.csv 
 - what does it mean by association rules ?   
 - does it mean save the pair 
 - A basket is a set of products  bought by a member in a date  , does this mean there will be multiple basket bases on the member buying in that date ? 
 - when the algorithm run will it out put the association relationship of only the the date , or the entire of the dataset 
 - s = 0.3); constant c is the confidence threshold (i.e., c =  0.5) is the 0. thing the percentage of item the item appear in the basket ?. 
- how many set of item should be run 
- the baskets that is save is  ]
- what is the recomended hash function for PCY  should i used the multihash hash  or just the normal hash 
- what is the number of pass the algorithm suppose to run and should the frequence item be in group of 3 

first pass  : 
check for frequency item 
