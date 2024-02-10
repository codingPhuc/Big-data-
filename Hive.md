#Question 
articulate the resound why HIve is used List Hive features 
differentiate between HIve vs traditional  RDBMS 
Identify componet of the Hive architecture 


# What is Hive  
Hive is a data warehouse software within Hadoop that is designed for reading, writing, and managing tabular-type datasets for data analysis purposes.

- It is scalable, fast, and easy to use.
- Hive Query Language (HiveQL) is inspired by SQL, making it easier for users to grasp concepts.
- It supports data cleaning and filtering depending on users' requirements.

**RDBMS:**

RDBMS is designed for a relational database.

- A relational database stores data in a structured format in rows and columns.
- Traditional RDBMS is used to maintain databases.



| Tradition la RDBMS | Hive |
| ---- | ---- |
| Used to maintain a Database  and uses SQL | Used to maintain a data warehouse using Hive query language |
| Suited for real-tome/dynamic data analysis like data from sensors | Suited for static data analysis like text file containing names |
| Designed to read and write as many times as it needs | Designed on the methodology of write once , read many |
| Maximum data size it can handle it terabytes | Maximum data size it can handle is petabytes |
| enforces that the schema must  verify loading data before it can be proceed | Doesn't enforce the scheam to verify loading data |
| May not alway have built in for support data partitioning | support partitioning |

![[arhichtecture HBase.PNG]]
The architecture of Hive comprises three main parts:

1. **Communication Drivers:**
   - Hive provides different drivers for communication, depending on the type of application. For Java-based applications, JDBC (Java Database Connectivity) is used, while other applications may use ODBC (Open Database Connectivity).
   - These drivers facilitate communication with the Hive server.
2. **Hive Services:**
   - Any query operation in Hive utilizes Hive services. The Command Line Interface (CLI) serves as an interface driver, taking in queries, monitoring sessions, and storing metadata.
   - The Metastore, part of the Hive services, is responsible for:
     - Storing metadata information about tables.
     - Managing query results.
   - Data loaded into tables is stored in the Hadoop cluster or Hadoop Distributed File System (HDFS).
3. **Query Execution Flow:**
   - When a query is initiated, the process involves several components:
     - **Driver:** Receives the query statement.
     - **Optimizer:** Efficiently splits tasks for execution.
     - **Executor:** Executes the tasks after optimization.
     - **Metastore:** Stores metadata information about the tables in a centralized location
4. **Communication Protocols:**
   - **JDBC:** JDBC clients enable Java applications to connect to Hive, allowing seamless integration with Java-based systems.
   - **ODBC:** ODBC clients, following the ODBC architecture, facilitate connections to Hive. This allows clients using ODBC-compatible systems to interact with Hive services.
5. **Hive Server:**
   - The Hive Server is responsible for enabling queries. It acts as a gateway for clients to submit queries to the Hive services.