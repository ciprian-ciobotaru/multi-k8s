## DEV
FROM openjdk:8-jdk-alpine
LABEL maintainer="ciprian.ciobotaru@sodexo.com"
VOLUME /tmp
VOLUME /logs
ARG JAR_FILE=target/demoAPI.jar
COPY ${JAR_FILE} demoAPI.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/demoAPI.jar"]
