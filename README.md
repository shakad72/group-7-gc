# Software Engineering Methods Coursework Assessment

Group project for the development of Java software, for a fictitious organisation, that reports on population information. 
The Scrum team is comprised of the following persons:
- Ahnaf Faiz
- Kingsley Forbes
- Maria Fernandez
- Norberto Coye
- Shaka Dow
- Wellington Ramsey

## Development Tips

- To run the MySQL docker image on your local PC during development, do the following:

        1). Enter the "db" subdirectory.
        2). To build the docker image type "docker build -t db ."
        3). To create and run a container based on the image type "docker run  -d --rm -p 3306:3306 db".
        4). At this point, you can use MySQL Workbench or DBeaver to connect to MySQL at localhost port 3306 using login "root" and password "group-7-gc".
        5). If you plan on testing the application with the container you spawned in step 3 then temporarily set the DB_HOST variable in the App.java class to "localhost".