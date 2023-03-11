# Example project of using mongodb in spring

## Docker and MongoDB setup

### Setup Docker
https://docs.docker.com/desktop/install/windows-install/
### Add Dependency to Maven
```ruby
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
```
### Add parameters to application.properties
```ruby
spring.data.mongodb.host=host.docker.internal
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
### Build docker image
```ruby
docker build -t myfirst_docker_image .
```
### Install mongo into docker
```ruby
docker pull mongo
```
### Run mongodb in docker
```ruby  
docker run -d --name mongo-on-docker -p 27017:27017
```
### Running spring application container
```ruby
docker run -d --name springapplication-on-docker -p 8080:8080 myfirst_docker_image
```
### Your application will be available on http://localhost:8080/users 
