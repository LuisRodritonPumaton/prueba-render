#
# Build stage
#
FROM maven:3.8.1-openjdk-17-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:17.0.1-jdk-slim

ADD ./target/*.jar ./app.jar
EXPOSE 8080
CMD java -Djava.security.egd=file:/dev/./urandon -jar app.jar
# COPY --from=build_maven /home/app/target/nbsadapter-1.0.1.jar /tmp/nbsadapter1.jar
# # ENV PORT=8080
# EXPOSE 8080
# ENTRYPOINT ["java", "-cp", "/tmp/nbsadapter1.jar", \
#         "-Dspring.profiles.active=local", \
#         "org.springframework.boot.loader.JarLauncher"]