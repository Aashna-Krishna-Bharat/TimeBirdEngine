# Build stage
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Copy only pom.xml first to cache dependencies
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Download dependencies (cached in Docker layer)
RUN ./mvnw dependency:go-offline

# Copy the rest of the source code
COPY src src

# Build the JAR
RUN ./mvnw -B -DskipTests clean package

# Runtime stage
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/timebird-engine-1.0.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]