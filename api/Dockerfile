# Stage 1: Build stage
FROM maven:3.8-openjdk-17 AS build
WORKDIR /app

# Copy only the necessary files for dependency resolution
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the entire application source
COPY . .

# Build the JAR
RUN mvn clean package

# Stage 2: Runtime stage
FROM openjdk:17
WORKDIR /app

# Copy the generated JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
