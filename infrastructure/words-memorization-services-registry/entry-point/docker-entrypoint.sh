#!/bin/bash
#
# # Docker entrypoint script (develop).
#

until [ $(curl $CONFIG_SERVER_URL/actuator/health | jq '.status') != "UP" ]
do
    sleep 5
done

java -jar /app/words-memorization-services-registry.jar --spring.cloud.config.uri=$CONFIG_SERVER_URL
