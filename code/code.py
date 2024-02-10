
# doc = ""


# words  = doc.split('') 


# print(words) 

# counters =  dict()  
# for w in words : 
#     if w not in counters : 
#         counters[w] =1 
#     counters[w] +=1   


# for k , v in counters.items() : 
#     print(k,v)
 
  
# def m( key ,value) : 
#     return [(w,1) for w in value.split(' ')] 


# # trong python muon gom key dum dictionary 
# # ham group by 
# def g(ps) : 
#     tmp = dict() 
#     for k , v in ps : 
#         if k not  in tmp.keys() :
#             tmp[k] = [] 
#         tmp[k].append(v) 
#     result = [(k,v) for k, v in tmp.items]
 
 
# # ham reduce 
# def r(key , value): 
#     return (key , sum(value)) 




doc = ""


words  = doc.split('') 


print(words) 

counters =  dict()  
for w in words : 
    if w not in counters : 
        counters[w] =1 
    counters[w] +=1   


for k , v in counters.items() : 
    print(k,v)
 
  
def m( key ,value) : 
    return [(w,1) for w in value.split(' ')] 


# trong python muon gom key dum dictionary 
# ham group by 
def g(ps) : 
    tmp = dict() 
    for k , v in ps : 
        if k not  in tmp.keys() :
            tmp[k] = [] 
        tmp[k].append(v) 
    result = [(k,v) for k, v in tmp.items]
 
 
# ham reduce 
def r(key , value): 
    return (key , sum(value)) 






