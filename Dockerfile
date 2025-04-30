# Use a Java 17 base image
FROM openjdk:17-jdk-slim AS build
ENV TZ=UTC


# Set the working directory inside the container
WORKDIR /app

# Copy the jar file from your local machine (target folder)
COPY target/reviews-service-0.0.1-SNAPSHOT.jar reviews-service.jar

# Expose port 8080 for the service
# EXPOSE 8080

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "reviews-service.jar"]

