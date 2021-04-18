# Search Keyword Identification for Concept Location using Graph-Based Term Weighting

**Abstract:** During maintenance, software developers deal with numerous  change requests that are written in an unstructured fashion using natural language texts.
These texts illustrate the change requirements using various domain-related concepts. Software developers need to find appropriate keywords from these texts
so that they could identify the relevant locations in the source code using a search technique. Once such locations are identified, they can implement the requested changes there. Studies suggest that developers often perform poorly in choosing the right keywords from a change request. In this article, we propose a novel technique --STRICT-- that (1) identifies suitable keywords from a change request using three graph-based term weighting algorithms -- TextRank, POSRank and WK-Core, and (2) then delivers an appropriate query using query quality analysis and machine learning. Our approach determines a term's importance based on not only its co-occurrences with other important terms but also its syntactic relationships and cohesion with them. Experiments using 955 change requests from 22 Java-based subject systems show that STRICT can offer better search queries than 
the baseline queries (i.e., preprocessed version of a request text) from 44%--63% of all requests. Our queries also achieve 20% higher accuracy, 10% higher precision and 7% higher reciprocal rank than that of the baseline queries. Comparisons with six existing approaches from the literature demonstrate that our approach can outperform them in improving the baseline queries. Our approach also achieves 14% higher accuracy, 15% higher precision and 13% higher reciprocal rank than that of the six other existing approaches.

Subject Systems
------------------------------------------------------------
- **adempiere-3.1.0** (12)
- **apache-nutch-1.8** (9)
- **apache-nutch-2.1** (17)
- **atunes-1.10.0** (16)
- **bookkeeper-4.1.0** (21)
- **commons-math-3-3.0** (16)
- **derby-10.9.1.0** (24)
- **ecf** (68)
- **eclipse-2.0** (17)
- **eclipse.jdt.core** (30)
- **eclipse.jdt.debug** (84)
- **eclipse.jdt.ui** (242)
- **eclipse.pde.ui** (182)
- **jedit-4.2** (10)
- **lang** (42)
- **mahout-0.4** (16)
- **mahout-0.8** (15)
- **math** (60)
- **openjpa-2.0.1** (16)
- **tika-1.3** (18)
- **time** (7)
- **tomcat70** (33)

**Total: 955**



Experimental Data
--------------------------------------------------------------
- ```Baseline/query``` : Baseline queries extracted from the 955 change requests. They make use of title, description, structured tokens and whole texts. ```query-whole``` is our chosen baseline.
- ```Baseline/rank``` : Query Effectiveness (QE) of the baseline queries (Method-level granularity).
- ```Baseline/rank-class``` : Query Effectiveness (QE) of the baseline queries (Document-level granularity).

- ```ChangeReqs``` : 955 change requests from the 22 subject systems. 

- ```Corpus/method.7z``` : Corpus containing the method bodies from source code documents of all systems. **Please decompress before use**.
- ```Corpus/norm-method.7z``` : Corpus containing the normalized method bodies from all the systems. **Please decompress before use**.
- ```Corpus/*.ckeys``` : Corpus document-index key mapping. This is an encoding of original methods into numbers.

- ```Goldset``` : Ground truth for 955 change requests.
- ```Lucene/index-method``` : Lucene index for concept location.
- ```SelectedBug``` : IDs of the 955 change requests under study.
- ```SelectedBug-HQB``` : IDs of the 225 change requests leading to good baseline queries.
- ```SelectedBug-LQB``` : IDs of the 730 change requests leading to poor baseline queries.
- ```tokens*``` : Tokens generated from project source and change requests for Splitting algorithm -- ```Samurai```.
- ```samurai-data``` : Meta data required by the Splitting algorithm -- ```Samurai```.
- ```models``` : Contains the models for POS tagging by Stanford CoreNLP library.
- ```pp-data``` : Stop words used for pre-processing.
- ```strict.lib``` : Contains the dependencies used by the proposed technique - STRICT.

Source Code 
------------
Please fork our  [**source code repository**](https://github.com/masud-technope/STRICT-QR-Module) for details.


Proposed & Existing Techniques
----------------

- ```Proposed-STRICT/query``` : Queries suggested by the proposed technique.
- ```Proposed-STRICT/rank``` : Query Effectiveness (QE) of the suggested queries (Method-level granularity).
- ```Proposed-STRICT/rank-class``` : Query Effectiveness (QE) of the suggested queries (Document-level granularity).
- ```Proposed-STRICT/Query-Difficulty-Model``` : Query Difficulty model, predictions, class labels, and other materials.
- ```Proposed-STRICT/Parameter-Tuning``` : Data related to parameter tuning of STRICT.

- ```TF/query``` : Queries suggested by TF.
- ```TF/rank``` : Query Effectiveness (QE) of the TF-based queries (Method-level granularity).
- ```TF/rank-class``` : Query Effectiveness (QE) of the TF-based queries (Document-level granularity).

- ```IDF/query``` : Queries suggested by IDF.
- ```IDF/rank``` : Query Effectiveness (QE) of the IDF-based queries (Method-level granularity).
- ```IDF/rank-class``` : Query Effectiveness (QE) of the IDF-based queries (Document-level granularity).

- ```TF-IDF/query``` : Queries suggested by TF-IDF.
- ```TF-IDF/rank``` : Query Effectiveness (QE) of the TF-IDF-based queries (Method-level granularity).
- ```TF-IDF/rank-class``` : Query Effectiveness (QE) of the TF-IDF-based queries (Document-level granularity).

- ```Kevic/query``` : Queries suggested by Kevic & Fritz.
- ```Kevic/rank``` : Query Effectiveness (QE) of the Kevic & Fritz queries (Method-level granularity).
- ```Kevic/rank-class``` : Query Effectiveness (QE) of the Kevic & Fritz queries (Document-level granularity).

- ```Rocchio/query``` : Queries suggested by Rocchio.
- ```Rocchio/rank``` : Query Effectiveness (QE) of the Rocchio queries (Method-level granularity).
- ```Rocchio/rank-class``` : Query Effectiveness (QE) of the Rocchio queries (Document-level granularity).

- ```Scannielo/rank``` : Query Effectiveness (QE) of the Scannielo et al. queries (Method-level granularity).
- ```Scannielo/rank-class``` : Query Effectiveness (QE) of the Scannielo et al. queries (Document-level granularity).

- ```Rahman & Roy/query``` : Queries suggested by our earlier work - Rahman & Roy, SANER 2017.
- ```Rahman & Roy/rank``` : Query Effectiveness (QE) of the queries (Method-level granularity).
- ```Rahman & Roy/rank-class``` : Query Effectiveness (QE) of the queries (Document-level granularity).


License & Others
-------
- ```README```
- ```LICENSE```


Accepted Papers
-------------------------------
```
STRICT: Information Retrieval Based Search Term Identification for Concept Location

Mohammad Masudur Rahman, Chanchal K. Roy
```
**Download this paper:**  [<img src="https://web.cs.dal.ca/~masud/img/pdf.png"
     alt="PDF" heigh="16px" width="16px" />](https://web.cs.dal.ca/~masud/papers/masud-SANER2017-pp.pdf)

```
TextRank based search term identification for software change tasks

Mohammad Masudur Rahman, Chanchal K. Roy
```
**Download this paper:**  [<img src="https://web.cs.dal.ca/~masud/img/pdf.png"
     alt="PDF" heigh="16px" width="16px" />](https://web.cs.dal.ca/~masud/papers/masud-SANER2015.pdf)


Please cite our works as
------------------------------------------------------------
```
@INPROCEEDINGS{saner2017masud,
author={Mohammad Masudur Rahman and C. K. Roy},
booktitle={Proc. SANER},
title={STRICT: Information Retrieval Based Search Term Identification for Concept Location},
year={2017},
pages={79--90} }
```
**Download this paper:**  [<img src="https://web.cs.dal.ca/~masud/img/pdf.png"
     alt="PDF" heigh="16px" width="16px" />](https://web.cs.dal.ca/~masud/papers/masud-SANER2017-pp.pdf)

```
@INPROCEEDINGS{saner2015masud,
author={Mohammad Masudur Rahman and C. K. Roy},
booktitle={Proc. SANER},
title={TextRank based search term identification for software change tasks},
year={2015},
pages={540-544} }
```
**Download this paper:**  [<img src="https://web.cs.dal.ca/~masud/img/pdf.png"
     alt="PDF" heigh="16px" width="16px" />](https://web.cs.dal.ca/~masud/papers/masud-SANER2015.pdf)
     

# Related Projects: [ACER](https://github.com/masud-technope/ACER-Replication-Package-ASE2017), [BLIZZARD](https://github.com/masud-technope/BLIZZARD-Replication-Package-ESEC-FSE2018), and [QUICKAR](https://github.com/masud-technope/QUICKAR-Replication-Package-ASE2016)

Something not working as expected?
--------------------------------------------
Please contact **Masud Rahman** (masud.rahman@usask.ca) 

or 

[**Create a new issue**](https://github.com/masud-technope/STRICT-Replication-Package/issues/new) for further information.





