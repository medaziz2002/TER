# ---- Stage 1: Build ----
FROM maven:3.8.4-openjdk-11 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# ---- Stage 2: Run ----
FROM openjdk:11-jre-slim
VOLUME /tmp
WORKDIR /app
COPY --from=build /app/target/GATEWAY-SERVICE-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
