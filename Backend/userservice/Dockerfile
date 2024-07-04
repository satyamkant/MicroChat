
# Use Maven to build the application
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package

# Use OpenJDK 17 as the base image
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven executable JAR file from the build stage
COPY --from=build /app/target/UserMicroservice.jar UserMicroservice.jar

# Copy the application.yaml from the build stage to the container
COPY --from=build /app/src/main/resources/application.yaml src/main/resources/application.yaml

# Expose the port that your Spring Boot application uses (if necessary)
EXPOSE 8080

# Command to run on container startup
CMD ["java", "-jar", "UserMicroservice.jar"]

#FROM openjdk:17
#ADD target/UserMicroservice.jar UserMicroservice.jar
#EXPOSE 8081
#ENTRYPOINT ["java","-jar","/UserMicroservice.jar"]