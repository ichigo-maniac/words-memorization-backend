FROM openjdk:8-jdk-alpine

RUN apk add --no-cache --update bash jq curl
ENV CONFIG_SERVER_URL http://words-memorization-cloud-config:8888/

COPY ["target/words-memorization-services-registry-1.0-SNAPSHOT.jar", "/app/words-memorization-services-registry.jar"]
COPY ["entry-point/docker-entrypoint.sh", "/app/"]

RUN chmod +x /app/docker-entrypoint.sh
ENTRYPOINT ["/app/docker-entrypoint.sh"]