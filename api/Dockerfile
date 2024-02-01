FROM openjdk:17

USER root

WORKDIR /app

# Copy pom.xml and additional project files
COPY . .

# Execute mvnw to build the JAR
RUN ./mvnw clean package

# Copy generated JAR
COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
