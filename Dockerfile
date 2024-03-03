FROM openjdk:latest
COPY ./target/app-0.1.0.1-jar-with-dependencies.jar /tmp
WORKDIR /tmp
# Comment out the line below if running the application in interractive mode (where you can navigate the menus to select a report)
ENTRYPOINT ["java", "-jar", "app-0.1.0.1-jar-with-dependencies.jar","country_reports/report_countryReport1.xml"]