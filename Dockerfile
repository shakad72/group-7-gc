FROM openjdk:latest
COPY ./target/app-0.1.0.3-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "app-0.1.0.3-jar-with-dependencies.jar"]