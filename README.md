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
**This is a light weight version of the original tool, machine learning not included**.
We also include ```strict-running-snapshot``` for STRICT.
- ```change-requests/``` contains the change requests from [**ECF Issue Repository**](https://bugs.eclipse.org/bugs/describecomponents.cgi?product=ECF)
- ```corpus/``` contains the raw and normalized source code files from [**ECF**](https://github.com/eclipse/ecf). The ```method``` folder contains the method definitions, and ```norm-method``` contains
the normalized version of the methods. Normalization steps are discussed in the paper (Section IV-B).
- ```goldset/``` contains the ground truth source code files (i.e., changed files) for the change requests.  
- ```lucene``` contains the Lucene index constructed from the corpus.
- ```models``` contains the trained models by Stanford NLP group for the POS tagging.
- ```pp-data``` contains the stop words or programming keywords used by STRICT for natural language pre-processing. 
- ```samurai-data``` contains auxiliary data for token splitting.
- ```input-data``` contains auxiliary input data.			

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
- ```execute``` :  Executes a user provided query for a bug ID, and returns the Query Effectiveness (QE). ```QE``` = the rank of the first ground truth file in the ranked result list.
- ```suggest+execute``` :  Suggests queries, executes the queries, and then returns/saves their results.


Required parameters for the operations
-----------------------------------------------
-  **-requestDir** : expects the directory containing the change requests (e.g., ```./change-requests``` )
-  **-outputFile** : expects a file name to write the output for the queries.
-  **-repoName** : expects the repository name (optional). The default repository is ```ecf```.
-  **-bugID** : expects a bugID from the ```./change-requests``` folder.
-  **-task** : expects a task to be performed.
-  **-baseline** : expects the type of baseline query from a change request. It takes two values ```T``` and ```W```. 
Here, ```T``` stands for the title, and ```W``` stands for the whole texts from the change request.
-  **-saveOutput** : expects ```true``` or ```false``` whether the query output should be saved or not.
-  **-userQuery** : expects a query chosen by the user for a specific bug ID.


Getting Started
==================================================

Q.1: How to install the STRICT tool?
--------------------------------------------------
- Execute ```git clone https://github.com/masud-technope/STRICT-Replication-Package.git```
- Once downloaded, you can decompress all the .7z files such as ```ecf.7z``` in the root and ```corpus``` folder. (Optional)
- Run the tool from within the root directory.


Q.2: How to execute your own query for a specific Bug ID?
-----------------------------------------------------------------------------------
Execute a single query
```
java -jar strict-runner.jar -task execute -repoName ecf -bugID 194981 -userQuery Do not automatically scroll when message received
```
When executing a single query, ```-userQuery``` should always be the last parameter. Otherwise, the tool will fail to parse the arguments.
The command provides the following output. The query returns the first correct ground truth file at the 79th position.
```
194981	Do not automatically scroll when message received
79	framework/bundles/org.eclipse.ecf.presence.ui/src/org/eclipse/ecf/presence/ui/chatroom/ChatRoomManagerView.java
```

Q.3: How to execute the baseline queries for a specific change request?
-----------------------------------------------------------------------------------
Execute the ```title``` of a change request as the search query.

```
java -jar strict-runner.jar -task execute -repoName ecf -bugID 194981 -baseline T
```
It provides the following output:
```
194981	Bug Don automatically scroll message received
QE=84	framework/bundles/org.eclipse.ecf.presence.ui/src/org/eclipse/ecf/presence/ui/chatroom/ChatRoomManagerView.java
```

Execute the ```whole texts``` of a change request as the search query.
```
java -jar strict-runner.jar -task execute -repoName ecf -bugID 194981 -baseline W
```
It provides the following output:
```
194981	Bug Don automatically scroll message received scrollback pops bottom message received nice turn hard view scrollback busy channel
QE=22	framework/bundles/org.eclipse.ecf.presence.ui/src/org/eclipse/ecf/presence/ui/chatroom/ChatRoomManagerView.java
```

Q.4: How to get suggested queries from STRICT for a single change request?
--------------------------------------------------------------------------
```
java -jar strict-runner.jar -task suggest+execute -repoName ecf -bugID 194981
```
This command will produce three queries and their QEs as follows:
```
===========194981===========
TR: QE=3	Q:scrollback message Don view Bug Don automatically scroll message received
POSR: QE=62	Q:message Bug Don automatically scroll message received
STRICT: QE=3	Q:message scrollback Don view Bug Don automatically scroll message received
```

Q.5: How to get suggested queries from STRICT for all the change requests?
--------------------------------------------------------------------------
```
java -jar strict-runner.jar -task suggest+execute -repoName ecf -outputFile ./sample-output-Oct10.txt
```
This command collects the queries from STRICT and their results, and then save them in the given output file.

------------------------------------------------------------------------------------------------

TSE : Replication Package
============================================================

Subject Systems
------------------------------------------------------------
- **ecf** (345)
- **eclipse.jdt.core** (404)
- **eclipse.jdt.debug** (229)
- **eclipse.jdt.ui** (695)
- **eclipse.pde.ui** (525)
- **log4j** (60)
- **sling** (76)
- **tomcat70** (551)

Replication Tool
------------------------------------------------------------
- ```strict-replicator.jar``` : Prototype for replicating the results submitted to TSE 


Required parameters for the operations
------------------------------------------------------------
-  **-task** : expects a task to be performed. Two values -- ```evaluate``` and ```evaluateQE```. 
-  **-algorithm** : expects an algorithm name from ```TR```, ```PR```, ```TPR```, ```TRC```, ```PRC```, ```TPRC```, ```Best-RF``` and ```Best-NS```. 
```
TR=TextRank, PR=POSRank TPR=TR+PR, TRC=TextRank + Weighted K-Core, PRC=POSRank + Weighted K-Core, TPRC=TR + POSR + Weighted K-Core, 
Best-RF=Best Query using Random Forest Learning, Best-NS=Best Query without re-sampling
```
-  **-K** : expects the value for the Top results.
-  **-baselineKey** : expects the type of baseline query from a change request. It takes four values ```T```, ```D```, ```C``` and ```W```. 
Here, ```T``` stands for the title, ```D``` stands for Description, ```C``` stands for code-only, and ```W``` stands for the whole texts from the change request.
-  **-difficultOnly** : if it is ```true```, the high quality baseline queries are avoided in the evaluation. 

Experimental Data
--------------------------------------------------------------
- ```TSE-Experiment-2018/Baseline/query``` : Baseline queries extracted from the 2,885 change requests. They make use of title, description, code tokens and whole texts. ```query-code``` is our chosen baseline.
- ```TSE-Experiment-2018/Baseline/rank``` : Query Effectiveness (QE) of the baseline queries.  
- ```TSE-Experiment-2018/Changereqs``` : 2,885 change requests from the eight subject systems. 
- ```TSE-Experiment-2018/Corpus/method.7z``` : Corpus containing the method bodies from source code documents of all systems. **Please decompress before use**.
- ```TSE-Experiment-2018/Corpus/norm-method.7z``` : Corpus containing the normalized method bodies from all the systems. **Please decompress before use**.
- ```TSE-Experiment-2018/Corpus/*.ckeys``` : Corpus document-index key mapping.
- ```TSE-Experiment-2018/Goldset``` : Ground truth for 2,885 change requests.
- ```TSE-Experiment-2018/Lucene``` : Lucene index for concept location.
- ```TSE-Experiment-2018/Proposed-STRICT/query``` : Queries suggested by the proposed technique for various algorithms.
- ```TSE-Experiment-2018/Proposed-STRICT/rank``` : Query Effectiveness (QE) of the suggested queries.
- ```TSE-Experiment-2018/Proposed-STRICT/resampling ``` : Re-sampled versions of Query Difficulty measures.
- ```TSE-Experiment-2018/Proposed-STRICT/qdiff-model``` : Query Difficulty model for the proposed approach.
- ```TSE-Experiment-2018/Proposed-STRICT/nosampling``` : Query Quality prediction results without resampling.
- ```TSE-Experiment-2018/SelectedBug``` : IDs of the change requests under study.
- ```TSE-Experiment-2018/tokens*``` : Tokens generated from project source and change requests for Splitting algorithm -- ```Samurai```.
- ```TSE-Experiment-2018/Traditional/query``` : Queries suggested by three traditional techniques-- ```TF```, ```IDF```, ```TF-IDF```.
- ```TSE-Experiment-2018/Traditional/rank``` : Query Effectiveness (QE) of the traditional queries.
- ```TSE-Experiment-2018/Weight-training``` : Auxiliary data for weight training for the proposed algorithm using Genetic Algorithm. 

Getting Started with Replication
------------------------------------------------------------

Q.6: How to reproduce/replicate the queries and results submitted to TSE?
--------------------------------------------------------------------------
```
java -jar strict-replicator.jar -task replicateTSE
```
This task might take 1-2 hours due to significant amount of calculations for 2,885 queries.
The produced materials will be saved at ```TSE-Experiment-2018/Proposed``` folder. Results could be slighly different due to the random sampling.



Q.7: How to replicate the Hit@K, MAP and MRR?
--------------------------------------------------------------------------
```
java -jar strict-replicator.jar -task evaluate -K 10 -algorithm Best-RF
```
The above command reports the STRICT's performance for Top-10 results.

```
Hit@10:0.4643411793250092
MAP@10:0.28994384855071037
MRR@10:0.288947863416532
Time needed:32 s
```


Q.8: How to replicate the Query Improvement, Worsening and Preserving ratios?
--------------------------------------------------------------------------
```
java -jar strict-replicator.jar -task evaluateQE -algorithm Best-RF -baselineKey C -difficultOnly false
```
The above command reports the STRICT's query rank improvement against the ```code-only``` baseline (default) queries from 2885 
change requests.

```
Dataset size:2885
Improved:0.5470895985568347, Worsened:0.28263805466658826, Preserved:0.170272346776577
Improved MRD:-401.7369774919614	 Worsened MRD:198.55050505050505
Time needed:0 s
```

---------------------------------------------------------------------------


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





