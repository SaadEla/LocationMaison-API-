# Location de Maison API
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2FSpring-Boot-Framework%2FSpring-Boot-Application-Template.svg?type=shield)](https://app.fossa.io/projects/git%2Bgithub.com%2FSpring-Boot-Framework%2FSpring-Boot-Application-Template?ref=badge_shield)

The only thing better than a Maven archetype is a repo you can fork with everything already setup. Skip the documentation and just fork-and-code. 

## Resume

* The application have two user type's (hote/touriste).
* Provide an authentication and inscription for the users.
* The "hote" can manage his leasing's and send message to "touriste"
* the "touriste" can check the leasing catalogue, make his choice and proceed whith paypal payment.

## Built With

* 	[Maven](https://maven.apache.org/) - Dependency Management
* 	[JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit 
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* 	[MySQL](https://www.mysql.com/) - Open-Source Relational Database Management System
* 	[git](https://git-scm.com/) - Free and Open-Source distributed version control system 

## External Tools Used

* [Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)



## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.arc.sbtest.SBtemplateApplication` class from your IDE.

- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing pom.xml
- Open Eclipse 
   - File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
   - Select the project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run as Java Application

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```





### URLs

|  URL |  Method | Remarks |
|----------|--------------|--------------|
|`http://localhost:8080/api/location/deletelocation/101`         | DELETE | Delete a location by id|
|`http://localhost:8080/api/location/choosen/1`                  | GET | Select a location by id|
|`http://localhost:8080/api/User/Insc`                           | POST | User Inscription|
|`http://localhost:8080/api/Message/MsgHote`                     | GET | Get a hot Message|
|`http://localhost:8080/api/location/best`                       | GET | Get location with high rating|


## Documentation

* [Postman Collection](https://documenter.getpostman.com/view/2449187/RWTiwzb2) - online, with code auto-generated snippets in cURL, jQuery, Ruby,Python Requests, Node, PHP and Go programming languages
* [Postman Collection](https://github.com/AnanthaRajuC/Spring-Boot-Application-Template/blob/master/Spring%20Boot%20Template.postman_collection.json) - offline


## Files and Directories

The project (a.k.a. project directory) has a particular directory structure. A representative project is shown below:

```
.
├── Spring Elements
├── src
│   └── main
│       └── java
│           ├── com.api
│           ├── com.api.controller
│           ├── com.api.model
│           ├── com.api.repository

├── src
│   └── main
│       └── resources
│           ├── application.properties
├── src
│   └── test
│       └── java
├── JRE System Library
├── Maven Dependencies
├── src
├── target
├── pom.xml
```


  
## Resources

* [My API Lifecycle Checklist and Scorecard](https://dzone.com/articles/my-api-lifecycle-checklist-and-scorecard)
* [HTTP Status Codes](https://www.restapitutorial.com/httpstatuscodes.html)

