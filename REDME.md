#Test Task:

1) Cover "Search Breweries" method of
    https://www.openbrewerydb.org/documentation with autotests using Java + REST Assured (pick up to 5 scenarios covering main method features and implement corresponding autotest in code, the rest scenarios you think should be included in complete test suite can be listed in readme file).

2) Examine "List Breweries" method and share your thoughts (in readme file) on how you would apply test automation to it (what approach, test design techniques you'd choose etc). Also please provide estimated effort for completing this task.

#Thoughts about the task:
From my perspective, https://api.openbrewerydb.org/ has a lot of issues.
Without a documentation, it is hard to understand functionality behavior. The behavior of this API is ambiguous.

First of all, were implemented happy-pass cases. Verification for query parameters implemented partially as an example.
In the future can be used PairWise testing for identifying optimal coverage if have no time for exhaustive testing.<br />
PICT app for it can do this job pretty well.
Base on the result of the data pair can be implemented additional request specifications to cover it.
Also, a framework can be extended with negative cases.
 
 #Framework implementations:
 RestAssured+TestNG+Jackson.<br />
 In the future can be added Lombok to improve the readability of the POJO class.<br />
 Lack of time not allowed finish ConfigManager for reading config.properties.<br />
 Also, the naming of tests can be more friendly and added more comments.
 For switch case can be improved condition to use same enum if will necessary. But who cares now)))
 
 #Works estimation
 For me it has been taken two days:<br />
 ####The first day, 
 familiarization with RestAssured thanks to Youtube, and our "Indian brothers" :))))<br />
 ####On the second day,
 investigate API and create a framework from scratch.