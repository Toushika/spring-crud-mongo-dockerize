FROM adoptopenjdk:11-jre-hotspot
WORKDIR /app
COPY build/libs/spring-crud-mongo-dockerize-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
