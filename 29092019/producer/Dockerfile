FROM java:8-jdk-alpine
COPY target/producer-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "producer-0.0.1-SNAPSHOT.jar"]