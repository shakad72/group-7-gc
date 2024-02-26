# Software Engineering Methods Coursework Assessment

Group project for the development of Java software, for a fictitious organisation, that reports on population information. 
The Scrum team is comprised of the following persons:
- Ahnaf Faiz
- Kingsley Forbes
- Maria Fernandez
- Norberto Coye
- Shaka Dow
- Wellington Ramsey

### Requirements Implemented

2 requirements of 32 have been implemented, which is 6.25%

## How to Use

1. Type "mvn package" to compile and build the project. The JAR file will be in the target subdirectory.
2. Type "docker-compose up -d". This will build and execute the containers, in detached mode, using docker-compose.
3. Type "docker-compose exec app java -jar app-0.1.0.1-jar-with-dependencies.jar". This will execute the Java application (in the app container) and permit the user to provide input and see the output.
4. Type "docker-compose down" when you are ready to stop and remove the containers.

## Development Tips

- To run the MySQL docker image on your local PC during development, do the following:

        1). Enter the "db" subdirectory.
        2). To build the docker image type "docker build -t db ."
        3). To create and run a container based on the image type "docker run  -d --rm -p 3306:3306 db".
        4). At this point, you can use MySQL Workbench or DBeaver to connect to MySQL at localhost port 3306 using login "root" and password "group-7-gc".
        5). If you plan on testing the application with the container you spawned in step 3 then temporarily set the DB_HOST variable in the App.java class to "localhost".

# Application Requirements

Software requirements:
----------------------

- Upon successful DB connection, user should be presented with a top-level menu (report groups)
- After making a top-level menu selection (or entering E to exit), the user should be presented with a list of reports for the group selected
- Once a report is selected, the user should be prompted for the required criteria (eg. country) or P to return to the top-level menu
- Validation of the required input should be performed before the report is executed
- The report can be presented as a table with columns sized by scanning through the field names and all results returned
- If no results are returned, rather than a table, the output "No results found!" can be displayed to the user
- The user should be returned to the top-level menu after the report is executed (regardless of whether of not results were found)

### Interraction with the software can be as follows:

    Software Engineering Methods Report Application
    -----------------------------------------------
    
    Reports are grouped into four categories.
    Please proceed by selecting a category followed by a report.

    1 - Country Report
    2 - City Report
    3 - Capital City Report
    4 - Population Report
    E - [Exit]

    Please make a selection (1-4): 1

    1 - Report 1
    2 - Report 2
    .
    .
    .
    7 - Report 7
    P - [Previous menu]

    Please make a selection (1-7 or B): 1
    Please enter the continent or type M to return to the menu: South America
    
    ----------------------------------
    Report on whatever
    ----------------------------------
    | Country    | Population        |
    ----------------------------------
    | Country 1  | XXXXXX            |
    | Country 2  | YYYYYY            |
    ----------------------------------
    
    ----> User is returned to the top menu
