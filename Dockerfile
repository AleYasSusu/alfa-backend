#FROM openjdk:11
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#EXPOSE 8085git
#ENTRYPOINT ["java","-jar","/app.jar"]


#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml install -Dmaven.test.skip=true

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/alfa-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]