# Folosim Maven + JDK pentru build
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Folosim JRE doar pentru rulare (mai mic decat JDK)
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/adminpanel-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
