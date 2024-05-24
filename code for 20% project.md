- run()
  - shingling()
    - _build_shing_dict()
    - _build_hash_dict()
      - hash_family_gen()
  - minhashing()
    - _build_bool_vec()
    - hash_a_doc()
  - locality_sensity_hashing()
    - buckenize()

- process_query()
  - tokenize()
  - get_k_shingles()
  - bool_vectorizer()
  - hash_a_doc()
  - buckenize()

- is_memory_safe()
- py_is_memory_safe()
https://colab.research.google.com/drive/1HuXHtpDnsxozvRLnYC7Ft1c2e6bv9PUh#scrollTo=ZFRhRVCgT-8n







Sure, let's go through each function in the `BigDataMinHashLSH` class and identify which functions are used or relied on within them:

1. **[[shingling]](documents: sql.DataFrame) -> sql.DataFrame**:
   - Relies on:
     - `_build_shing_dict(shing_df: sql.DataFrame) -> tuple[dict[tuple[str, ...], int], int, list[sql.Row]]`: Builds the shingle dictionary.
     - `_build_hash_dict(shing_dict: dict[tuple[str, ...], int], collect_item_counts: list[sql.Row])`: Pre-computes hash dictionaries for minhashing.
     - `_build_bool_vec(shing_df: sql.DataFrame) -> sql.DataFrame`: Builds boolean vectors for each document.

2. [[minhashing]](bool_vec: sql.DataFrame) -> sql.DataFrame**:
   - Relies on:
     - `_build_hash_dict(shing_dict: dict[tuple[str, ...], int], collect_item_counts: list[sql.Row])`: Pre-computes hash dictionaries for minhashing.

3. **[[locality_sensity_hashing]](minhash_df: sql.DataFrame) -> sql.DataFram**:
   - Relies on: None (It performs LSH directly on the MinHash signatures DataFrame).

4. ** [[approxNearestNeighbors]](key: str, n: int) -> sql.DataFrame**:
   - Relies on:
     - `process_query(query: str) -> tuple[list[str], list[int]]`: Prepares the query for LSH search.
     - `minhashing(bool_vec: sql.DataFrame) -> sql.DataFrame`: MinHashes the query for LSH search.

5. **[[_build_bool_vec]](shing_df: sql.DataFrame) -> sql.DataFrame**:
   - Relies on: None (It creates boolean vectors directly from shingled documents DataFrame).

6. **[[_build_shing_dict]](shing_df: sql.DataFrame) -> tuple[dict[tuple[str, ...], int], int, list[sql.Row]]**:
   - Relies on: None (It builds the shingle dictionary directly from the shingled documents DataFrame).

7. **[[_build_hash_dict]](shing_dict: dict[tuple[str, ...], int], collect_item_counts: list[sql.Row])**:
   - Relies on: None (It pre-computes hash dictionaries directly from the shingle dictionary and their counts).

8. **[[process_query]](query: str) -> tuple[list[str], list[int]]**:
   - Relies on:
     - `bool_vectorizer(shingles, shing_dict)`: Vectorizes the shingles of the query.
     - `hash_a_doc(bool_vec, NUM_HASH, hash_dict)`: Hashes the boolean vector of the query.

Overall, the class methods rely on each other in a hierarchical manner, where certain methods are called within others to perform specific tasks, ultimately leading to the execution of the MinHash LSH algorithm.



how to parapash the source code 
- change the single the single in the code is comporse of split string bases on spaces change it to split bases on i:k 
- change the variable and function name  of the code 
- change the commane 
- change the udf to rdd 


content : cl_col_content
id   :  cl_col_id 
signature : cl_col_signature  
boolean_vec
COMMON_THRES : cl_frequency
