# Etapa 1: construir el jar
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: correr la app
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

# Configuración de zona horaria
ENV TZ=UTC

ENTRYPOINT ["java", "-jar", "app.jar"]