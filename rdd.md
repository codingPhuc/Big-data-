
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
