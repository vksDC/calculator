# Calculator

POC for calculator application

This application supports two operations: add and diff.
Both operations require two operators at least.

## Getting started
### Compile
In order to compile and build this app it's neccesary to run the following maven command:
``` 
mvn clean package
```
Other alternative is to create a new "Run Configuration" in Eclipse (or your IDE of choice), select "Maven" and add "clean package" as goals.

### Run
To run this application 
```
mvn spring-boot:run
```
Alternatively, you can create a new Maven configuration and add "spring-boot:run" as goals.