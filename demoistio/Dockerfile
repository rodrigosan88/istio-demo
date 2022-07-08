FROM openjdk:8-jdk-alpine
COPY target/serviceA.jar serviceA.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/serviceA.jar"]