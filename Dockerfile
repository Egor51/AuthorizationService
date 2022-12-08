FROM maven:3.6.3 AS builder

COPY ./ ./

FROM openjdk:17-jdk

COPY target/AuthorizationService-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]
