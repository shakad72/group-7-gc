FROM openjdk:latest
COPY ./target/app-jar-with-dependencies.jar /tmp
WORKDIR /tmp
# Comment out the line below if running the application in interractive mode (where you can navigate the menus to select a report)
#ENTRYPOINT ["java", "-jar", "app-jar-with-dependencies.jar","reports/report1.xml"]
ENTRYPOINT ["java", "-jar", "app-jar-with-dependencies.jar","-host","db","-port","3306","-reportDefinition","reports/report1.xml"]