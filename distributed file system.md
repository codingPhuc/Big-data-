## Distributed File System

Distributed File Systems, exemplified by Google's GFS and Hadoop's HDFS, offer a global file namespace with a focus on redundancy and availability.

### Typical Usage Pattern

- **File Size:** Typically used for large files ranging from hundreds of gigabytes to terabytes.
- **Data Update Frequency:** Data is rarely updated; updates occur through appends rather than in-place modifications. For instance, when Google encounters a new webpage, it adds the webpage to a repository without updating existing webpages.

### File Organization

- Files are organized into chunks, and these chunks are distributed across multiple machines.

![Chunks in File System](chunk%20in%20file%20system.PNG)

- Data is stored in chunks, divided among various machines.
- In the illustration, Chunk Server 1 holds 4 chunks, Chunk Server 2 holds 1 chunk, and Chunk Server 3 holds 1 chunk.

![Chunk Server Distribution](chunkserver2.PNG)
 - after copying the data chunks , Chunk Server 1 holds 4 chunks, Chunk Server 2 holds 3 chunks, and Chunk Server 3 holds 2 chunks.
- Chunk servers are duplicated across different nodes for redundancy.
- Chunk servers also serve as compute servers. Computation is moved to the chunk server, reducing the need to transfer data for computation.

Distributed File Systems are designed to efficiently handle vast amounts of data, provide fault tolerance, and optimize data processing through distributed storage and computation.


## Chunk Server (or Data Node)

- In the event of a switch failure on a rack, the entire chunk becomes unreplicable.
- Chunk servers, or data nodes, store data chunks. Chunks are small, typically ranging from 16-64 MB, and are often duplicated (x2 or x3) to ensure redundancy.
- Duplication of chunks across different servers prevents data loss in case of a failure.

## Master Node

- **Name Node in Hadoop HDFS:**
    
    - Manages metadata, including the structure and locations of data chunks.
- **Key Functions:**
    
    - Stores crucial metadata about data chunks.
    - Costly to replace if destroyed, compared to a data node.
    - Manages information about file locations in the distributed file system.
    - Typically more robust against hardware failures, running critical cluster services.
    - Also referred to as the Secondary Name Node, serving backup functions.
- Stores information about where files are stored; for example, if File 1 is stored across 6 chunks.
    
- The master node is crucial for the overall system.
    

## Client Library

- The client library communicates with the master node to find the chunk storing the data.
- Once the chunk location is identified, the client library accesses the data directly, bypassing the need to go through the master node.