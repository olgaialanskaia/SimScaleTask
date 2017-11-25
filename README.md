#API tests with Rest-assured

**Task**

Rest API integration 

You need to ensure, that our application works properly on API level. 
Please, implement a simple test scenarios: 

_Scenario 1:_ 
* Login into application with existing user credentials (register one for yourself and use existing userName and password) (/api/v1/auth/) 
* Get user info (/api/v1/users/{userName}) (Please investigate where you can get username for your user and just hard code this value)  
* Assert user email is correct in response json (emailAddress) 


_Scenario 2:_  
* Login into application with existing user credentials (register one for yourself and use  existing userName and password) (/api/v1/auth/) 
*  Create project (/api/v1/projects/" + userName) (find body json example with browser  debug tool)
* Get all projects (/api/v1/projects/)
* Assert list of projects contains new created project 

**Test Run**

To run tests use `mvn test` in your terminal.