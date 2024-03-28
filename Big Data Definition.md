# Market-basket model
## purpose 
Goal: Identify items that are bought together by  sufficiently many customers  
Approach: Process the sales data collected with  barcode scanners to find dependencies among  
items  
A classic rule:  
▪ If someone buys diaper and milk, then he/she is  
likely to buy beer  
▪ Don’t be surprised if you find six-packs next to diapers! 
## Market 
#Market is a set of large set of items  that is present in the dataset 
an real life example is like supper market that have item like Bread , Coke,  Milk , Beer , Diaper  
## Basket 
#Basket is a subset of item in a market 
![[bear and breadd.PNG]] 
- here there is 5 basket each is a subset of items in a super market   
another example : 
-  a #Market   of   a,b,c item a subset of {a,b} {a,b,c} is a basket  


## Support 
Support in big data mean that number of basket containing items I  
![[supportforitems.PNG]]
- here we can see that subset of Bear and bread appear at least 2 time in 5 individual basket , so we say that beer and bread have a support of 2 
### support Threshold  
support Threshold is the the allow subset which have the required amount of support 
![[support thress hold.PNG]]
- here we can see that  item that do not meet the require support threshold will be eliminated from the equation 


## association rule 
there are two side the left hand and right hand , 
{milk} ->  {coke}
customer buy item in the left hand side buy item in the right hand side 
`Frequent Itemset` find set of items that appear together 

{i1, i2,…,ik} → j 
means: “if a basket contains  all of i1,…,ik then it is likely to contain j”
- example : {i1,i2} -> j  or {i1,i2,i3}-> j ; the `,..,` just mean the amount of item is not limited an can increase 

## confident 
mean that the probability of j given   $(i_{1},...i_{k})→ j$ 
$conf(I ->j)  = \frac{(I \cup j)}{support(I)}$ 


1. The probability of a customer taking all the items on the left given they have all the items on the right is represented as:
    
    $P(j | I) = \frac{P(I \cup j)}{P(I)}P(j∣I)=P(I)P(I∩j)​$
    

2. The confidence of an association rule, for example, the probability of a customer buying bread given that they already bought milk, is represented as:
    
    $\text{conf}(I \rightarrow j) =0.8$
    
    This means there is an 80% chance that a customer will buy bread if they have already bought milk.
    

3. The interest of an association rule, which is the absolute difference between its confidence and the fraction of baskets that contain `j`, is represented as:
    
    $\text{interest}(I \rightarrow j) =  | \text{conf}(I \rightarrow j) - P(j) ∣$
    
    Rules with high interest values (values above 0.5) are considered interesting.
### Association Rule Minning 
Step 1: Find all frequent itemset I
▪ find all item set which are the minimum of the support threshold 
Step 2: Rule generation
▪ For every subset A of I, generate a rule A → I \ A
▪ Since I is frequent, A is also frequent
▪ Variant 1: Single pass to compute the rule confidence
▪ confidence(A,B→C,D) = support(A,B,C,D) / support(A,B)
▪ Variant 2:
▪ Observation:If A,B,C→D is below confidence, then so is A,B→C,D
- this mean that if a C, D is a subset of D then the rule of the parent will be apply to child , meaning A,B,C -> D is bellow confident so will A,B->C,D 
▪ Can generate “bigger” rules from smaller ones!
▪ Output the rules above the confidence threshold


# Computational model 

## Passes 
A #Passes is the number of time an algorithm run the over the entire dataset, the number of passes an algorithm makes over the entire dataset determines its complexity
## Triangle Matrix  
![[triangle.PNG]]
This triangle represents a matrix. The matrix is square, and it appears as a triangle because when the square matrix is split, the triangles on each side have the same values. There are two types of matrices, one of which is sparse, meaning the values in the matrix are mostly zero.


