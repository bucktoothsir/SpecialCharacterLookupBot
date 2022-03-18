# syntax=docker/dockerfile:1

FROM gradle:7.4.1-jdk17 AS build
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY . $APP_HOME

RUN ./gradlew --no-daemon build

NTRYPOINT ["./gradlew","run"]

