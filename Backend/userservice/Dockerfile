# Use Maven to build the application
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app

# Copy only the pom.xml first to cache dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the application
COPY . .

# Set environment variables for PostgreSQL connection and Consul host
ENV DB_URL="jdbc:postgresql://DB:5432/microchat"
ENV DB_USERNAME="casaos"
ENV DB_PASSWORD="casaos"
ENV CONSUL_HOST="consul"

# Replace placeholders in application.yaml with environment variables
RUN sed -i "s|url: jdbc:postgresql://localhost:5432/microchat|url: $DB_URL|g" src/main/resources/application.yaml && \
    sed -i "s|host: localhost|host: $CONSUL_HOST|g" src/main/resources/application.yaml

# Build the application
RUN mvn clean package

# Use OpenJDK 17 as the base image
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven executable JAR file from the build stage
COPY --from=build /app/target/UserMicroservice.jar UserMicroservice.jar

# Copy the modified application.yaml from the build stage to the container
COPY --from=build /app/src/main/resources/application.yaml src/main/resources/application.yaml

# Expose the port that your Spring Boot application uses (if necessary)
EXPOSE 8080

# Command to run on container startup
CMD ["java", "-jar", "UserMicroservice.jar"]