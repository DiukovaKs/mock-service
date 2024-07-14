FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY /target/mock-service-0.0.1-SNAPSHOT.jar /app/mock-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "mock-service.jar"]