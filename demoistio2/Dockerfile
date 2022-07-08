FROM openjdk:8-jdk-alpine
COPY target/serviceB.jar serviceB.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/serviceB.jar"]