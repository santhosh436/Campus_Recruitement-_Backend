# Start with a base image with JDK 21
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file into the Docker image
COPY target/CustomerStatus-0.0.1-SNAPSHOT.jar app.jar

# Expose the port Spring Boot will run on
EXPOSE 8089

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
