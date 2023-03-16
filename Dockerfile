#
# Build stage
#
FROM openjdk:11

EXPOSE 8080

ADD /target/api-gestion-entidad-0.0.1-SNAPSHOT.jar app.jar
# ENV PORT=8080

ENTRYPOINT ["java","-jar","/app.jar"]