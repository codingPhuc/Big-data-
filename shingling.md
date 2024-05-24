
ouput : 
schema  with index row and a  boolean vector matrix where the number correspond to where the row is 1 

[[boolean.csv]]

```
 def shingling(self, documents: sql.DataFrame) -> sql.DataFrame:

        """Perform shingling step

  

        Input: documents DF `<text>-<id>`

        Returns: bool_vec DF `<id>-<true_indices>`

        """

  

        # Step 1: Shingling each document

        ## <text>-<id>-<shingles>

        shing_df = documents.withColumn(

            self.COL_SHINGLES, self.fn_k_shingler(col(self.COL_TEXT))

        )

  

        ## <id>-<shingles>

        shing_df = shing_df.select(self.COL_ID, self.COL_SHINGLES)

  

        # Step 2: Build shing_dict

        self.shing_dict, self.shing_len, collect_item_counts = self._build_shing_dict(

            shing_df

        )

  

        # Step 3: Pre-compute hash_dict (for minhashing step)

        self.hash_dict = self._build_hash_dict(self.shing_dict, collect_item_counts)

  

        # Step 4: Get the boolean vectors

        #   Because of pyspark DF length limitations

        #   When shing_len very large -> dim(bool_vec) very large -> error

        #   We store list of true indices instead

        #       Sparse vector also only store true indices

        #       But still error with length too long

        ## <id>-<true_indices>

        bool_vec = self._build_bool_vec(shing_df)

        return bool_vec
```

Sure, here's a tree view of the `build_shingling` method and the functions it relies on:

```
- build_shingling
  - _build_shing_dict
    - tokenize
    - get_k_shingles
  - _build_hash_dict
    - hash_family_gen
  - _build_bool_vec
    - bool_vectorizer
```

Explanation:
- **Shingling Method**
    - **get_k_shingles**: This method is used to get a list of distinct shingles from a token list. It slices the token list into shingles and returns the distinct shingles. The shingles are tuples because sets need immutable objects[^search_uploaded_document(doc_name=“final_version20_.py”, query=“get_k_shingles”)^].
        - **token_lst**: A list of tokens from which shingles are generated.
        - **k**: The length of the shingles.
    - **bool_vectorizer**: This method gets a sparse representation of the boolean vector of a shingled document[^search_uploaded_document(doc_name=“final_version20_.py”, query=“bool_vectorizer”)^].
        - **shing_lst**: The output of `get_k_shingles`.
        - **shing_dict**: A dictionary of `<shingle>-<idx>` pairs.
    - **shingling**: This method performs the shingling step on a DataFrame of documents. It shingles each document, builds a shingle dictionary, and pre-computes the hash for common shingles[^search_uploaded_document(doc_name=“final_version20_.py”, query=“shingling method”)^].
        - **documents**: A DataFrame of `<text>-<id>`.

Please note that these methods are interconnected. The `shingling` method uses the `get_k_shingles` and `bool_vectorizer` methods to perform its operations. The `get_k_shingles` method is used to generate shingles from the text, and the `bool_vectorizer` method is used to create a boolean vector representation of the shingled document. The `shingling` method then uses these outputs to perform the shingling step on the DataFrame of documents.

Let me know if you need more information about these methods or any other part of your code. I’m here to help! 😊




shing_df    
- self.fn_k_shingler(col(self.COL_TEXT))  (will return a tuplet value with single being the k number of word in each tuplet)
	- fn_k_shingler ()
		- get_k_shingles
		- tokeniz


 shing_df = shing_df.select(self.COL_ID, self.COL_SHINGLES) 

_build_single 
The `_build_shing_dict` function in your code is used to build a dictionary that maps each unique shingle to a unique index. This is often used in the process of shingling, where you convert documents into sets of shingles (substrings of a certain length). Here’s a step-by-step breakdown of what this function does:

1. **Explode the Shingles**: The function takes as input a DataFrame `shing_df` with each row containing an ID and its corresponding set of shingles. The `explode` function is used to create a new row for each shingle in the list of shingles.
    
2. **Count the Shingles**: It then groups by shingle and counts the number of occurrences of each shingle.
    
3. **Sort the Shingles**: If `DO_SORT_SHING_DICT` is set to True, it sorts the shingles.
    
4. **Check Memory Safety**: It checks if the size of the item_counts is safe to be stored in memory. If not, it raises an assertion error.
    
5. **Collect Item Counts**: It collects the item counts into a list of Row objects.
    
6. **Build the Shingle Dictionary**: It then builds the shingle dictionary (`shing_dict`) by enumerating over the collected item counts. Each shingle is mapped to a unique index.
    
7. **Calculate the Length of the Boolean Vector**: It calculates the length of the boolean vector, which is just the length of the shingle dictionary.
    
8. **Return Values**: Finally, it returns the shingle dictionary, the length of the boolean vector, and the collected item counts.
    


