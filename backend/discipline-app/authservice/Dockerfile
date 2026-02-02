FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml .
COPY userservice/pom.xml userservice/
COPY authservice/pom.xml authservice/

RUN mvn -pl userservice -am dependency:go-offline

COPY authservice/src authservice/src

RUN mvn -pl authservice clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

COPY --from=build /app/authservice/target/authservice-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-Xmx512m", "-jar", "app.jar"]