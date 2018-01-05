FROM openjdk:latest
ADD target/cider-api.jar cider-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "cider-api.jar"]