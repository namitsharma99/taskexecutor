Problem Statement:
-------------------

Implement a task executor service according to the following specification.

The entry point for the service is Task Executor interface. The interface is defined bellow including its dependencies.

The service is required to implement the following behaviors:
1. Tasks can be submitted concurrently. Task submission should not block the submitter.
2. Tasks are executed asynchronously and concurrently. Maximum allowed concurrency may be restricted.
3. Once task is finished, its results can be retrieved from the Future received during task submission.
4. The order of tasks must be preserved.
   o The first task submitted must be the first task started.
   o The task result should be available as soon as possible after the task completes.
5. Tasks sharing the same TaskGroup must not run concurrently.
   
Additional implementation requirements:
1. The implementation must run on OpenJDK 17.
2. No third-party libraries can be used.
3. The provided interfaces and classes must not be modified.
   
Please, write down any assumptions you made.
(Framework methods and class - Main.java)

Assumptions:
------------
1. Considering 5 working threads in the executor service
2. Total 15 tasks, distributed among 3 task groups


Sample output:
-------------
Thread count selected: 5
Response from Future: 1
Response from Future: 2
Response from Future: 3
Response from Future: 4
Response from Future: 5
Response from Future: 6
Response from Future: 7
Response from Future: 8
Response from Future: 9
Response from Future: 10
Response from Future: 11
Response from Future: 12
Response from Future: 13
Response from Future: 14
Response from Future: 15

