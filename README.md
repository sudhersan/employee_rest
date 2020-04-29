# Command Line instructions

## Pre-requisites
* Docker container for MySql has to be running
* Application logs are by default written in C:\Users\Public\Documents.Please change to expected folder in Application.properties file.

-------------------------------------------------------

## Run application

java -jar EmployeeREST-0.0.1-SNAPSHOT.jar

-------------------------------------------------------

## Commands to test

curl -H "Authorization: e79b1c21-8013-407b-8e34-98d47af49eb2" http://localhost:8080/employees

curl -H "Authorization: 6318f8ae-ff59-46a7-8e78-7599f91971f5" http://localhost:8080/employees/100005

![Alt text](C:\Users\subha\Pictures\Postman.PNG,"Via Post Man")





