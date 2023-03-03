FROM gradle:4.7.0-jdk8 AS build
COPY . .
RUN gradle build --no-daemon


FROM openjdk:8-jdk-slim
COPY --from=build /target/libs/demo-0.0.1-SNAPSHOT.jar demo.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]