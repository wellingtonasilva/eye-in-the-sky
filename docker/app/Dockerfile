FROM openjdk:8-jdk-alpine
MAINTAINER wellingtonasilva
VOLUME /tmp
EXPOSE 8080
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
COPY ./target/eyeinthesky-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=container", "-jar", "/app/app.jar"]

