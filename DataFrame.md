
## DataFrames and Datasets

- A Dataset is a distributed collection of data, strongly typed JVM objects.
- Datasets combine both RDDs and SQL.
- Datasets are immutable and cannot be deleted.
- Datasets work for Scala and Java, other languages do not have Datasets.
- Benefits of Datasets:
    - Compile-time type safety.
    - Faster computation than [[rdd]].
    - Offers the benefits of Spark SQL and DataFrame.
    - Optimizes queries using Catalyst and Tungsten.

## Spark SQL Optimization

- Spark SQL has a built-in rule-based query optimizer.
- It reduces query time and memory consumption.
- It supports constructs in Scala, data source rules, and more.
- It uses cost-based optimization considering time and memory query consumption.
- It supports multiple paths for queries using a tree data structure and set of rules.

## Spark SQL Data Source

- Supports Parquet files, which preserve data schema.
- Spark SQL can also run queries without loading the file.
- JSON datasets: Spark infers the schema.

## Tungsten

- Optimizes CPU performance instead of I/O.
- Manages memory and does not rely on the JVM object model.
- Enables cache-friendly computation of algorithms.
- Supports on-demand JVM bytecode generation.

# different type of operation 
## narrow  
![[Pasted image 20240524130520.png]] 

exmaple  : 
map  
filter 
union
## wide 
 
![[Pasted image 20240524130527.png]]

**GroupBy** 
JOin  
sort  

## Techniques for Optimizing Data in Spark

1. **Adaptive query execution:** Dynamically adjusts the query plan during execution based on runtime statistics to optimize performance.
2. **Cost-based join reordering:** Optimizes join order based on estimated costs of different join paths.
3. **Broadcast hash join:** Optimizes small-table joins by broadcasting one table to all nodes, reducing data shuffling.
4. **Shuffle partitioning and memory management:** Efficiently manages data shuffling during operations like groupBy and aggregation and optimizes memory usage.

I hope this helps! If you have any more questions or need further clarification, feel free to ask.