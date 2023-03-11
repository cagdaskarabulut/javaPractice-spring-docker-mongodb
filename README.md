# Example project of using mongodb in spring

### Docker and MongoDB setup
* Setup Docker
https://docs.docker.com/desktop/install/windows-install/
* Add Dependency to Maven
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
* add parameters to application.properties
spring.data.mongodb.host=host.docker.internal
spring.data.mongodb.port=27017
* Creating a Dockerfile at the root of our project
FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
* Build docker image
docker build -t myfirst_docker_image .
* install mongo into docker
docker pull mongo
* run mongodb in docker  
docker run -d --name mongo-on-docker -p 27017:27017
* running spring application container
docker run -d --name springapplication-on-docker -p 8080:8080 myfirst_docker_image
* Your application will be available on http://localhost:8080/users 
