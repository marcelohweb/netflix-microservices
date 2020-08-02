# Netflix API Microservice Architecture

This project contains a microservice architecture for a netflix application simulator.

## Understanding this project

This project was developed as a proof of concept for achieve two main goals. The first one is to demonstrate that it is possible to build a microservice architecture using
both decentralized and shared databases.

The second goal is to implement a DevOps approach to build a set of <a href="https://spring.io/guides/gs/spring-boot">Spring Boot</a> microservices inside a docker container and use them by another container.

<a href="#">See the article here</a>

## Getting started

This is a Spring Boot application built using <a href="https://spring.io/guides/gs/maven/">Maven</a>.

You don't need java or maven in your machine because this project is compiled inside a docker container.

### Prerequisites

* <a href="https://www.gnu.org/software/make/">Make</a>
* <a href="https://git-scm.com/">Git</a>
* <a href="https://www.docker.com/">Docker</a>
* <a href="https://docs.docker.com/compose/gettingstarted/">Docker-compose</a>

### Run

All you need to do is run the following commands:

	git clone https://github.com/marcelohweb/netflix-microservices
	cd netflix-microservices
	make build
	make run

Before you start using, check the container logs to see if all microservices are running. It takes some time.

You can use <a href="https://www.portainer.io/">Portainer</a> to check.

<img src="http://66.7.213.120/~mswebcom/portainer.png" width="485px">

You can then access eureka service discovery here: <a href="#">http://localhost:8010/</a>

Username: user  
Password: user

You will see all registered microservices as the following image:

<img src="http://66.7.213.120/~mswebcom/eureka.png">

## Modules

* netflix-config
* netflix-service-discovery
* netflix-api-gateway
* netflix-data
* netflix-category-microservice
* netflix-movie-microservice
* netflix-user-microservice

## Databases

* mysql
* mongo

The database configuration data is located in the docker-compose.yml file.

For the microservices, the connection data for each microservice is in the netflix-config module inside config directory.

## Usage

You can use this API by importing the <a href="https://www.postman.com/">Postman</a> collection located in the postman directory.

First of all, you need to create a user using user-create request.

<img src="http://66.7.213.120/~mswebcom/create-user.png">

After that, use user-login request to authenticate and get the token. The token is in the header response.

<img src="http://66.7.213.120/~mswebcom/login.png">

Once you have the token, feel free to create categories and movies.

## Working in your IDE

Some modules reference the others by using their container name. If you want to run locally, you need to edit your /etc/hosts file to add the following entries so that the microservices can communicate with each other.

127.0.0.1       netflix-config  
127.0.0.1       netflix-service-discovery  
127.0.0.1       netflix-api-gateway  
127.0.0.1       netflix-user-microservice  
127.0.0.1       netflix-category-microservice  
127.0.0.1       netflix-movie-microservice  
127.0.0.1       mysql-db  
127.0.0.1       mongo


### Prerequisites
The following items should be installed in your system:
* Java 8.
* Your preferred IDE
  * I recommend <a href="https://spring.io/tools">Spring Tools Suite</a>
  * Clone the project
  * Import as Existing Maven Projects
  * If you are using Spring Tools Suite: Right click -> Run as -> Spring Boot App (the first 3 in that sequence: microservice-config, netflix-service-discovery, netflix-api-gateway)

Remember you need mysql and mongo database running. You can use the database containers created before. Just run the mysql and mongo containers and stop the others.

Enter the absolute path of the config directory in /netflix-config/src/main/resources/application.properties

    spring.cloud.config.server.native.search-locations=file:/path/to/netflix-config/config
    
Enter the endpoint of the config server in the bootstrap.properties of each microservice

    spring.cloud.config.uri=http://netflix-config:8012

Enjoy it!
