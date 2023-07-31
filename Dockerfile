#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .
#
# Package stage
#
FROM openjdk:11-jdk-slim
COPY --from=build /out/artifacts/spring_boot_todo_app_jar/spring-boot-todo-app.jar build.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]