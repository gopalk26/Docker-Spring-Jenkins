FROM openjdk:21-jdk-slim

WORKDIR /app

# Copy the JAR
COPY target/dockerSpring-0.0.1-SNAPSHOT.jar /app/app.jar

# Copy the wait-for-it script to root
COPY wait-for-it.sh /wait-for-it.sh

# Make it executable
RUN chmod +x /wait-for-it.sh

EXPOSE 9091

# Wait for MySQL, then start Spring Boot
ENTRYPOINT ["/wait-for-it.sh", "mysql-db:3306", "--", "java", "-jar", "/app/app.jar"]
