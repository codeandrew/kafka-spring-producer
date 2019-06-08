FROM openjdk:8-alpine3.8
MAINTAINER Jean Andrew Fuentes <jeanandrewfuentes@gmail.com>

WORKDIR /usr/src
ADD build/libs/producer-0.0.1-SNAPSHOT.jar /usr/src/docker-producer.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "docker-producer.jar"]
