
#
# Build stage
#
FROM openjdk:8-jdk-alpine as build
COPY . .
RUN ./gradlew clean build -x test

#
# Package stage
#
FROM openjdk:8-jre-alpine
COPY --from=build /build/libs/demo-0.0.1-SNAPSHOT.jar demo.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]