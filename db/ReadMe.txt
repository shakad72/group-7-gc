To run the docker image on your local PC during development, do the following:

1). change your directory to the directory with the Dockerfile
2). To build an image named db type "docker build -t db ."
3). To create and run a container based on the db image type "docker run  -d --rm -p 3306:3306 db"

At this point, you can use MySQL Workbench or DBeaver to connect to MySQL at localhost port 3306 using login "root" and password "group-7-gc".