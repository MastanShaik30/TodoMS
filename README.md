# TodoMS

To run the app using Docker use the following commands:  docker build -t todoapp . && docker run -it 8082:8080 todoapp
To run the app using maven use the following command: mvn spring-boot:run


The App has JWT Authentication, you can register for adding user and then login to the Application.

**Register**

Http Method: POST 
Url : http://localhost:8082/register
Request : {"username":"test","password":"test"}

**Authenticate**

Http Method: POST 
Url : http://localhost:8082/authenticate
Request : {"username":"test","password":"test"}


**Todo App API**

They can be found in Swagger. Swagger is configured for JWT authentication
The Swagger Url is : http://localhost:8082/swagger-ui/
