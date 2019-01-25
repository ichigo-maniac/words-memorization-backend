#!/bin/bash
# Deploys all SiWatch services in local machine with using docker.

# Stop all running docker containers and delete them.
docker stop $(docker ps -a -q) && docker rm $(docker ps -a -q) && docker rmi $(docker images -q)

# Down and up docker services.
docker-compose down
docker-compose build
docker-compose up