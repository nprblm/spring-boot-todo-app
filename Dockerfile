#
# Build stage
#
FROM maven:3.8.2-openjdk-17 AS build
WORKDIR /app
COPY . /app/
RUN mvn clean package

#
# Package stage
#
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]