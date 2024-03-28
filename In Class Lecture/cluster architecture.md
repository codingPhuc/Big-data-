![Custor Architecture](CustorArchitecture.PNG)

In the depicted cluster architecture:
- Each rack contains 16-64 Linux nodes, interconnected by a switch.
- When a single rack is insufficient, multiple racks are connected through additional switches 
![[multiplerack.PNG]]
## Challenges of Cluster Computing

### Scale
- In 2011, Google had 1 million machines configured in this manner.

### Node Failures
- While a single server can stay operational for 3 years (1000 days),
- In a cluster of 1000 servers, you can expect approximately 1 failure per day.
- With 1 million servers in a cluster, this translates to around 1000 failures per day.

### Challenges to Address
1. **Persistent Data Storage despite Node Failures:**
   - Ensuring data persistence and availability even in the face of node failures.

2. **Handling Node Failures during Long-Running Computations:**
   - Creating infrastructure to mask node failures and complete computations seamlessly.

3. **Network Bottleneck:**
   - Network bandwidth limited to 1 Gbps, resulting in significant time (approximately 1 day) to move 10 TB of data.

4. **Difficulty in Distributed Programming:**
   - Challenges in writing correct programs to avoid race conditions.
   - A need for a simplified programming model to abstract away much of the complexity.

## MapReduce Solution

To tackle these challenges, [[MapReduce]] offers a solution:
- **Redundant Data Storage:** Data is stored redundantly on multiple nodes for both persistence and availability.
- **Minimizing Data Movement:** Computation is moved close to the data, reducing the need for extensive data movement.
- **Simple Programming Model:** MapReduce provides a straightforward programming model that abstracts away the complexities of cluster computing.


#Exam 
[test](https://knowt.com/flashcards/e4ff9d90-96ec-48c4-ada3-d5fc9a7e3e9e) 