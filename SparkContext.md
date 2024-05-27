Main entry point for Spark functionality. A SparkContext represents the connection to a Spark cluster, and can be used to create RDDs, accumulators and broadcast variables on that cluster.

Only one `SparkContext` should be active per JVM. You must `stop()` the active `SparkContext` before creating a new one. 
