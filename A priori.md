# A priori  
A two pass approach  called a-priori  limit the need for main memory 

key idea monotonicity if a set of items appears at least s items , so does every subset of s 

Contrapositive for pairs :  
if item i does not appear in s basket , then no pair including i can appear in s basket 


Pass 1 : read bakset and ount in main memory the occurences of each items 

item that appear at least s time are the frequence items 

Pass 2 : Read basket again and count in main memory only those pair both of which were found in pass 1 to be frequent 

requires memory proportional to square of frequent items only (for counts ) ,  plus a list of frequent items (so you know what must be  counted) 

![[count of piar.PNG]]
- in Pass 1 the item are counted bases on the frequency requirement or support threshold 
- if the item meat the threshold then it will be tranfer in to pass 2 
- in pass 2 the count of pairs of frequent items mean that the items which meet the support threshold required by pass 1 , it generate key pair number of pair is $2^{d}$ with d being the items that got pass 



for each k , we construct two set of  k-sets(set of size k) : 
$C_{k}$ = candidate k-set  = those  that might be frequent sets support >=s (s la mot con so thuc) based on the information from the pass for k -1 
$L_{k}$ = the set of truly frequent k-sets 

![[Pasted image 20240302093956.png]]
- the beginning is the singleton item $C_{1}$
- item are then filter bases on there support threshold 
- after filter it will generate the support item $L_{1}$  
-  $L_{1}$   will then be constructed to generate candidate k-set $C_{2}$  
- the process will then continue for each $C_{k+1}$ = (k+1) 

$C_{1}$  = all items  (the beginning singleton item set)
in general  , $L_{k}$ = members of $C_{k}$ with support >= s  ()
$C_{k+1}$ = (k+1) -sets , each k of which is in $L_{k}$  



