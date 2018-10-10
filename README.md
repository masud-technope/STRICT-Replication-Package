STRICT-Replication-Package
==============================================
Replication Package of STRICT: Search Term Identification for Concept Location using Graph-Based Term Weighting


Abstract
--------------------------------
During maintenance, software developers deal with numerous  change requests that are written in an unstructured fashion using natural language.
Such natural language texts illustrate the change requirement involving various domain related concepts. 
Software developers need to find appropriate search terms from these concepts so that they could identify the possible locations in the source code using a search technique. 
Once such locations are identified, they can implement the requested changes there.
Studies suggest that developers often perform poorly in identifying suitable search terms from a change request. 
In this article, we propose a novel technique --STRICT-- that (1) automatically identifies suitable search terms from a change request using three graph-based term weighting algorithms -- TextRank, POSRank and WK-Core, and (2) then suggests appropriate search query using query quality analysis and machine learning. Our approach thus 
determines a term's importance based on not only its co-occurrences with other important terms but also its syntactic relationships and cohesion with them. Experiments using 2,885 change requests from eight subject systems report that STRICT can offer higher quality queries 
than baseline queries from 43%--72% of the requests, and they achieve 26% higher accuracy, 25% higher precision and 26% higher reciprocal rank than the baseline. 
Comparison with three state-of-the-art approaches demonstrate that our approach improves 16% more baseline queries and achieves 25% higher accuracy, 
37% higher precision and 38% higher reciprocal rank than that of the state-of-the-art.


Accepted Papers
-------------------------------
```
STRICT: Information Retrieval Based Search Term Identification for Concept Location

Mohammad Masudur Rahman, Chanchal K. Roy
```
```
TextRank based search term identification for software change tasks

Mohammad Masudur Rahman, Chanchal K. Roy
```

Materials Included
----------------------------------------
**Tool Installation & Run**

- ```strict-runner``` is the functional prototype of STRICT, our proposed query reformulation technique. 
We also include ```strict-running-snapshot``` for STRICT.
- ```change-requests/``` contains the change requests from [**JEdit Issue Repository**](https://sourceforge.net/p/jedit/bugs)
- ```corpus/``` contains the raw and normalized source code files from [**JEdit**](https://github.com/vanzin/jEdit)
- ```goldset/``` contains the ground truth source code files for the change requests.  
- ```lucene``` contains the Lucene index for JEdit corpus
- ```models``` contains the Stanford models for POS tagging.
- ```pp-data``` contains the stop words used by STRICT for pre-processing. 

**License & Others**

- ```README```
- ```LICENSE```

System Requirements
---------------------------
- JDK: STRICT was built with **JDK 1.8.0_74**. Please use at least JDK 1.8.* for the successful execution/run.
- Operating System: Only tested on *Windows 10*, but the tool is supposed to be *cross-platform*.
- If any file path contains *space* or *special characters*, the path should be **"double quoted"**.

Available Operations
----------------------------
- ```execute``` :  Executes a user provided query for a bug ID, and returns the Query Effectiveness (QE). QE = the rank of the first ground truth in the ranked result list.
- ```suggest+execute``` :  Suggests queries, executes the queries, and returns/saves their results.


Required parameters for the operations
-----------------------------------------------
-  **-requestDir** : expects the directory containing the change requests (e.g., ```./change-requests``` )
-  **-outputFile** : expects a file name to write the output of the queries.
-  **-repoName** : expects the repository name (Optional). The default is ```jedit```.
-  **-bugID** : expects a bugID from the ```./change-requests``` folder.
-  **-task** : expects a task to be performed.
-  **-baseline** : expects the type of baseline query from the change request. It takes two values ```T``` and ```W```. Here, ```T``` stands for title, and ```W``` stands for the whole texts of the request.
-  **-saveOutput** : expects ```true``` or ```false``` whether the query output should be saved or not.
-  **-userQuery** : expects a query from the user for a given bug ID.


Getting Started
==================================================

Q.1: How to install the STRICT tool?
--------------------------------------------------
- Execute ```git clone https://github.com/masud-technope/STRICT-Replication-Package.git```
- Run the tool from within the ```STRICT``` directory.


Q.2: How to execute your own query for a specific change request?
-----------------------------------------------------------------------------------
Execute a single query
```
java -jar strict-runner.jar -task execute -repoName jedit -bugID 4027 -userQuery Sorting files in the file system browser not working
```
When executing a single query, ```-userQuery``` should always be the last parameter. Otherwise, the tool will fail to parse the arguments.


Q.3: How to execute the baseline queries for a specific change request?
-----------------------------------------------------------------------------------
Execute the ```title``` of a change request as the search query.

```
java -jar strict-runner.jar -task execute -repoName jedit -bugID 4037 -baseline T
```

Execute the ```whole texts``` of a change request as the search query.
```
java -jar strict-runner.jar -task execute -repoName jedit -bugID 4037 -baseline W
```

Q.4: How to get suggested queries from STRICT for a single change request?
-------------------------------------------------------
```
java -jar strict-runner.jar -task suggest+execute -repoName jedit -bugID 4037
```
This command will produce three queries and their QEs as follows:
```
===========4037===========
TR: 1	select buffer Print working selection Print preview selection working
POSR: 2	Selection General Print preview selection working
STRICT: 1	buffer Selection General preview selection Print preview selection working
```

Q.5: How to get suggested queries from STRICT for all the change requests?
--------------------------------------------------------------------------
```
java -jar strict-runner.jar -task suggest+execute -repoName jedit -outputFile ./sample-output-Oct10.txt
```
This command collects the queries from STRICT and their results, and then save in the output file.


Please cite our work as
------------------------------------------------------------
```
@INPROCEEDINGS{saner2017masud,
author={Mohammad Masudur Rahman and C. K. Roy},
booktitle={Proc. SANER},
title={STRICT: Information Retrieval Based Search Term Identification for Concept Location},
year={2017},
pages={79--90} }
```
```
@INPROCEEDINGS{saner2015masud,
author={Mohammad Masudur Rahman and C. K. Roy},
booktitle={Proc. SANER},
title={TextRank based search term identification for software change tasks},
year={2015},
pages={540-544} }
```
--------------------------------------------
Please contact **Masud Rahman** (masud.rahman@usask.ca) 

or 

[**Create a new issue**](https://github.com/masud-technope/STRICT-Replication-Package/issues/new) for further information.





