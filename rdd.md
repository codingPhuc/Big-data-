
## Resilient Distributed Datasets (RDDs)

- RDDs are a prime data abstraction in Spark, distributed across cluster nodes.
- New RDDs can be created from existing ones.
- RDDs are lazily computed, meaning computation only occurs when an action is invoked.
- Functions like `map()` can be used to create RDDs.
- Actions return results to the driver program, for example, `reduce()` returns the result to the driver program.

## Directed Acyclic Graph (DAG)

- Spark uses DAGs, which are graphical data structures with edges and vertices.
- Spark creates a DAG when creating an RDD.
- The DAG points to a new RDD.
- The transformations are returned to the Spark driver.
- The driver program completes the DAG only after Spark completes the action.



 **Directed Acyclic Graph (DAG)** is like a blueprint laid out by a manager for his employees.

Just as a manager plans the tasks for his employees, the DAG in Spark represents a sequence of computations performed on data. Each node in the graph represents an RDD (Resilient Distributed Dataset), and the edges represent the transformations applied on the RDDs.

The DAG scheduler in Spark converts the Spark transformations into stages of tasks. A stage in Spark is a sequence of transformations that can be performed in a single pass, i.e., without shuffling data around. This makes the computation more efficient.
## RDD Functions

- `map()`: Maps each element.
- `filter()`: Filters elements.
- `distinct()`: Finds distinct elements.
- `flatMap()`: ?

## Actions

- `reduce()`
- `take()`: Returns an array.
- `collect()`: Returns all elements as an array.
- `takeOrdered()`: Returns elements ordered in ascending order.


## Resilient Distributed Datasets (RDDs)

- RDDs are a prime data abstraction in Spark, distributed across cluster nodes.
- New RDDs can be created from existing ones.
- RDDs are lazily computed, meaning computation only occurs when an action is invoked.
- Functions like `map()` can be used to create RDDs.
- Actions return results to the driver program, for example, `reduce()` returns the result to the driver program.


