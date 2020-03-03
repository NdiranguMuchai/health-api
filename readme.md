# Health Records API

This project was generated from [Spring Initializer](https://start.spring.io/).


### Prerequisites
The following items should be installed in your system:
* Java 8 or newer.
* git command line tool (https://help.github.com/articles/set-up-git)
* PostgreSQL 9.0 or newer
* Your preferred IDE 
  * Eclipse with the m2e plugin. Note: when m2e is available, there is an m2 icon in `Help -> About` dialog. If m2e is
  not there, just follow the install process here: https://www.eclipse.org/m2e/
  * [Spring Tools Suite](https://spring.io/tools) (STS)
  * IntelliJ IDEA
  * [VS Code](https://code.visualstudio.com)
  
 
## Database configuration
* Create a user with the name 'user' and password 'password'
* Create a database 'health' with a schema named 'main_data'
* Spring will handle the rest 

## Running it locally
Health records is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). You can build a jar file and run it from the command line:


```
git clone https://github.com/NdiranguMuchai/health-api.git
cd health-api
./mvnw package
java -jar target/*.jar
```
You can then access health here: http://localhost:8080/

Or you can run it from Maven directly using the Spring Boot Maven plugin. If you do this it will pick up changes that you make in the project immediately (changes to Java source files require a compile as well - most people use an IDE for this):

```
./mvnw spring-boot:run
```

##API Documentation
Once you run the application you can get documentation for the endpoints here: http://localhost:8080/swagger-ui.html#/