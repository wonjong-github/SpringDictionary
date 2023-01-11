FROM openjdk:8u131-jdk-alpine

MAINTAINER HYUNSOO RYU "blesssdutch@naver.com"

EXPOSE 8080

WORKDIR /usr/local/bin/

COPY target/demo-property-manager-0.0.1-SNAPSHOT.jar application.jar

# CMD ["java","-Dspring.profiles.active=docker","-jar","application.jar"]

CMD ["java","-jar","application.jar"]
