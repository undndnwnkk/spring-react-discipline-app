FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml .
COPY userservice/pom.xml userservice/

RUN mvn -pl userservice -am dependency:go-offline

COPY userservice/src userservice/src

RUN mvn -pl userservice clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

COPY --from=build /app/userservice/target/userservice-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081
EXPOSE 9091

ENTRYPOINT ["java", "-Xmx512m", "-jar", "app.jar"]