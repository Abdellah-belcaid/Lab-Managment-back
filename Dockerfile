# Stage 1: Build the application using Maven
FROM maven:3.8.5-openjdk-17 AS build
# Copy the entire project directory into the container at /app
COPY . .
# Build the application using Maven, excluding tests
RUN mvn clean package -DskipTests


# Stage 2: Create a lightweight runtime  image
FROM openjdk:17.0.1-jdk-slim
# Copy the built JAR file from the build stage into the container at /app
COPY --from=build /target/Lab-Management-System-0.0.1-SNAPSHOT.jar Lab-Management-System.jar
# Expose port 8080 to allow external access to the application
EXPOSE 8080
# Command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "Lab-Management-System.jar"]
