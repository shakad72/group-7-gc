# Use the latest MySQL image
FROM mysql:latest
# Set the authors label
LABEL authors="group-7-gc"
# Set the working directory in the container
WORKDIR /tmp
# Copy SQL file to directory in container where it will be parsed upon startup
COPY world.sql /docker-entrypoint-initdb.d
# Set the root password
ENV MYSQL_ROOT_PASSWORD group-7-gc
