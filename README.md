# spring-crud-mongo-dockerize
For this docker-compose.yml and Dockerfile should be on the project directory. Here the application will run on port 8888. It ids deteremined on docker-compose.yml
Please look the docker-compose.yml file of my project.

 **Dockerfile**
  
  FROM adoptopenjdk:11-jre-hotspot
  
  WORKDIR /app
  
  COPY build/libs/spring-crud-mongo-dockerize-0.0.1-SNAPSHOT.jar /app/app.jar
  
  EXPOSE 8080
  
  ENTRYPOINT ["java", "-jar", "app.jar"]
