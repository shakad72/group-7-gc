# Software Engineering Methods Coursework Assessment

Current release:

![GitHub Release](https://img.shields.io/github/v/release/shakad72/group-7-gc)

License:

![GitHub License](https://img.shields.io/github/license/shakad72/group-7-gc)

Build status for master branch:

![GitHub Actions Workflow Status](https://img.shields.io/github/actions/workflow/status/shakad72/group-7-gc/main.yml?branch=master)

Build status for develop branch:

![GitHub Actions Workflow Status](https://img.shields.io/github/actions/workflow/status/shakad72/group-7-gc/main.yml?branch=develop)

Code coverage for master branch:

TODO: Include codecov code coverage badge for master branch


Group project for the development of Java software, for a fictitious organisation, that reports on population information. 
The scrum team consists of the following persons:

- Ahnaf Faiz
- Kingsley Forbes
- Maria Fernandez
- Norberto Coye
- Shaka Dow
- Wellington Ramsey

### Requirements Implemented

32 requirements of 32 have been implemented, which is 100%

## Running the Application in Non-Interactive Mode (default)

1. Type "docker-compose up" to build and launch the "app" and "db" containers. You will see the output for report documented in use-case-1.md
2. Hit Ctrl-C to return to the command prompt
3. Type "docker-compose down" to stop and remove the containers (ie. to clean up)

## Running the Application in Interactive Mode

1. Uncomment the line in the application Dockerfile with the word "ENTRYPOINT"
2. To avoid having to edit code to communicate with localhost, type "echo 127.0.0.1 db >> %WINDIR%\System32\Drivers\Etc\Hosts" so that db resolves to localhost
3. Type "docker-compose up -d" to build and execute the containers in detached mode
4. Type "docker-compose exec app java -jar app-0.1.0.5-jar-with-dependencies.jar" to execute the Java application within the app container
5. Navigate to the report you would like to view using the menus
6. Once you have exited the application, type "docker-compose down" to stop and remove the containers

## Development Tips

To run the MySQL docker image on your local PC during development, do the following:

1. Enter the "db" subdirectory
2. To build the docker image type "docker build -t db ."
3. To create and run a container based on the image type "docker run  -d --rm -p 3306:3306 db"
4. At this point, you can use MySQL Workbench or DBeaver to connect to MySQL at localhost port 3306 using login "root" and password "group-7-gc"
5. If you plan on testing the application with the container you spawned in step 3 then temporarily set the DB_HOST variable in the App.java class to "localhost"

# Application Requirements

Software Requirements:
----------------------

- Software should permit non-interactive execution where user input is not required. This will be useful for automated testing
- Software should permit interactive execution where users can navigate through a hierarchy of menus to select the report they want to view
- Upon successful DB connection, user should be presented with a top-level menu (report groups)
- After making a top-level menu selection (or entering E to exit), the user should be presented with a list of reports for the group selected
- Once a report is selected, the user should be prompted for the required criteria (eg. country) or P to return to the top-level menu
- Validation of the required input should be performed before the report is executed
- The report can be presented as a table with columns sized by scanning through the field names and all results returned
- If no results are returned, rather than a table, the output "No results found!" can be displayed to the user
- The user should be returned to the top-level menu after the report is executed (regardless of whether of not results were found)

### Screen Capture of Application Running in Interactive Mode:

    C:\IdeaProjects\group-7-gc\target> java -jar .\app-0.1.0.4-jar-with-dependencies.jar
    Attempting to connect to database (attempt 1 of 10)
    Successfully connected
    
    Main Menu
    1 - Country Reports
    2 - City Reports
    3 - Capital City Reports
    4 - Population Reports
    E - Exit
    Please make a selection (1...4 or E): 1
    Country Reports
    1 - All the countries in the world organised by largest population to smallest
    2 - All the countries in a continent organised by largest population to smallest
    P - Previous Menu
    Please make a selection (1 or P): 1
    All the countries in the world organised by largest population to smallest
    +----+--------------------------------------------+-------------+-------------------------+----------+---------------------------------+
    |Code|Name                                        |Continent    |Region                   |Population|Capital                          |
    +----+--------------------------------------------+-------------+-------------------------+----------+---------------------------------+
    |CHN |China                                       |Asia         |Eastern Asia             |1277558000|Peking                           |
    |IND |India                                       |Asia         |Southern and Central Asia|1013662000|New Delhi                        |
    |USA |United States                               |North America|North America            |278357000 |Washington                       |
    |IDN |Indonesia                                   |Asia         |Southeast Asia           |212107000 |Jakarta                          |
    |BRA |Brazil                                      |South America|South America            |170115000 |Brasília                         |
    |PAK |Pakistan                                    |Asia         |Southern and Central Asia|156483000 |Islamabad                        |
    |RUS |Russian Federation                          |Europe       |Eastern Europe           |146934000 |Moscow                           |
    .
    .
    .
    |TKL |Tokelau                                     |Oceania      |Polynesia                |2000      |Fakaofo                          |
    |VAT |Holy See (Vatican City State)               |Europe       |Southern Europe          |1000      |Città del Vaticano               |
    |CCK |Cocos (Keeling) Islands                     |Oceania      |Australia and New Zealand|600       |West Island                      |
    |PCN |Pitcairn                                    |Oceania      |Polynesia                |50        |Adamstown                        |
    |ATA |Antarctica                                  |Antarctica   |Antarctica               |0         |                                 |
    |ATF |French Southern territories                 |Antarctica   |Antarctica               |0         |                                 |
    |BVT |Bouvet Island                               |Antarctica   |Antarctica               |0         |                                 |
    |HMD |Heard Island and McDonald Islands           |Antarctica   |Antarctica               |0         |                                 |
    |IOT |British Indian Ocean Territory              |Africa       |Eastern Africa           |0         |                                 |
    |SGS |South Georgia and the South Sandwich Islands|Antarctica   |Antarctica               |0         |                                 |
    |UMI |United States Minor Outlying Islands        |Oceania      |Micronesia/Caribbean     |0         |                                 |
    +----+--------------------------------------------+-------------+-------------------------+----------+---------------------------------+
    
    Country Reports
    1 - All the countries in the world organised by largest population to smallest
    2 - All the countries in a continent organised by largest population to smallest
    P - Previous Menu
    Please make a selection (1 or P): p
    Main Menu
    1 - Country Reports
    2 - City Reports
    3 - Capital City Reports
    4 - Population Reports
    E - Exit
    Please make a selection (1...4 or E): e
    Bye!
    C:\IdeaProjects\group-7-gc\target>