#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package

#
# Package stage
#
FROM openjdk:11-jdk-slim
COPY --from=build /target/api-gestion-entidad-0.0.1-SNAPSHOT.jar app.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
# #
# # Build stage
# #
# FROM openjdk:11

# EXPOSE 8080

# ADD ./target/api-gestion-entidad-0.0.1-SNAPSHOT.jar app.jar
# # ENV PORT=8080

# ENTRYPOINT ["java","-jar","/app.jar"]