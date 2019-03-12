#!/bin/bash
#
# # Docker entrypoint script (develop).
#

until [ $(curl $EUREKA_SERVER_URL/actuator/health | jq '.status') != "UP" ] && [ $(curl $CONFIG_SERVER_URL/actuator/health | jq '.status') != "UP" ]
do
    sleep 5
done

java -jar /app/users-service.jar --spring.cloud.config.uri=$CONFIG_SERVER_URL --eureka.client.service-url.defaultZone=$EUREKA_SERVER_URL/eureka
