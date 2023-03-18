# Example project of using mongodb in spring

## Docker and MongoDB setup

## Setup Docker
https://docs.docker.com/desktop/install/windows-install/

## Edit Project
### Add Dependency to Maven
```ruby
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
```
### Add parameters to application.properties
```ruby
# Mongo configuration settings
spring.data.mongodb.database=javapractice-note
spring.data.mongodb.host=javapracticemongodb
spring.data.mongodb.port=27017
```
### Creating a Dockerfile at the root of our project
```ruby
FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
```

## Preparation
### Install mongo into docker
```ruby
docker pull mongo:latest
```

### Build docker image
```
### Start a mongo server instance
```ruby  
docker run -d -p 27017:27017 --name javapracticemongodb mongo:latest
```

### Running spring application container
```ruby
mvn clean install (from intelij editor first run clean then install )
docker image build -t employee .
docker images
docker run -p 8080:8080 --name employee --link employeemongodb:mongo -d employee
docker ps
docker logs employee
docker rm -f employeemongodb (if it doesnt work use container id to delete)
docker-compose up => under this path (paroject_name\src\main\resources)

now you can test if its working from 
GET - http://localhost:8080/employee-docker-app/employees

for mongodb console 

docker exec -it employeemongodb bash
mongo
show dbs
use employee-service-blog
```

### Your application will be available on http://localhost:8080/users 
