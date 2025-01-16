Due to some issues with the testing I ran in a lot of errors. Different Approaches were used for Testing the Application and the Endpoints.


- Using Mockita and MockMVC - ran into error with finding the MockMVC-Bean

https://medium.com/@Lakshitha_Fernando/spring-boot-unit-testing-for-repositories-controllers-and-services-using-junit-5-and-mockito-def3ff5891be

- Direct Access to the Database - did not get the database
https://stackoverflow.com/questions/53803780/tests-in-spring-boot-with-database-h2

- WebtestClient to test the endpoints - ran into error with finding the MockMVC-Bean 
- https://rieckpil.de/spring-webtestclient-for-efficient-testing-of-your-rest-api/

Provided Solution: 
I tried to mock the Request as good as possible and tested all Endpoint manually using Postgres since I was not able to get a solution to test all Endpoints in time. 