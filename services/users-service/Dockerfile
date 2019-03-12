FROM openjdk:8-jdk-alpine

RUN apk add --no-cache --update bash jq curl
ENV EUREKA_SERVER_URL http://words-memorization-services-registry:8761/
ENV CONFIG_SERVER_URL http://words-memorization-cloud-config:8888/

COPY ["target/users-service-1.0-SNAPSHOT.jar", "/app/users-service.jar"]
COPY ["entry-point/docker-entrypoint.sh", "/app/"]

RUN chmod +x /app/docker-entrypoint.sh
ENTRYPOINT ["/app/docker-entrypoint.sh"]