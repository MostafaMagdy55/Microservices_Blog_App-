# Spring Microservices blog :coffee:



## Technologies :computer:

- Java
- Spring boot
- Spring Cloud
   - Config Server
   - Congig Client
   - Eureka Server
   - Eureka Client
   -  Api GateWay 
- Spring Data JPA 
- MySql
- Postman


## Description :fire: 

##### this is a Microservices project consist of three Microservices 
- **USERS**
- **POSTS**
- **COMMENTS**
 ##### I used  Spring Config Server to share configration , i used Spring Api Gateway to Fiter and Routing  Requests and  i used Spring Eureka server to register the services and load balancing between them.
 
##### - the first service is USRES you can do CRUD Operation then you can call Posts Service
##### - the second service is POSTS you can do CRUD Operation then you can call Comments Service
##### - the third service is COMMENTS you can do CRUD Operation 



## How to use :wave: (IF YOU WANT TO USE IT LOCALLY) 

To clone and run this application by yourself, make sure you have at least Java 8 and all JDK stuff (including JRE), Maven to build the dependencies,
IntelliJ IDEA or Ecplise , and Postman (it's not necessary, though it's really useful to handle a rest API. After that, do the following instructions

- Clone this repository
```bash
$ https://github.com/MostafaMagdy55/Microservices_Blog_App-.git
```
- Open this project using  IntelliJ IDEA or Ecplise
 
1.  Run Config Server The endpoints are located in 'http://localhost:8888/'
2.  Run Eureka Server The endpoints are located in 'http://localhost:8761/'
3.  Create Databases With names
    -  usres
    -   posts
    -   comments
5.  Run Users Service ,Run Post Service , Run Comment Service then Run  Api Gateway The endpoints are located in 'http://localhost:8765/'



 
