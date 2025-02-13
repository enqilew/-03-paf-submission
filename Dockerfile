### DOCKERISATION - STAGE 1
#---------------------------
# Install JDK
FROM eclipse-temurin:21-jdk AS builder

LABEL maintainer="enqilew"

# Set working dir
WORKDIR /src

# Copy files & folders over
COPY mvnw .
COPY pom.xml .
COPY .mvn .mvn
COPY src src    

# Build jar app
RUN ./mvnw package -Dmaven.test.skip=true


### DOCKERISATION - STAGE 2
#---------------------------
FROM eclipse-temurin:21-jdk

# Set working dir
WORKDIR /app

# Copy over jar from first container (builder), rename to preferred app name
COPY --from=builder /src/target/assessment-0.0.1-SNAPSHOT.jar app.jar

# Check if curl command is available
RUN apt update && apt install -y curl

# Set environment variables
ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL="mysql://root:EtMJuvxOYGoaPNPZAoncZxCEXnwJigxK@junction.proxy.rlwy.net:13362/railway"
ENV MYSQL_USER=""
ENV MYSQL_PASSWORD=""
ENV SPRING_DATA_MONGODB_URI="mongodb://mongo:VhfvBuwxXFfceOmtTzARoJwRGavWdBtN@junction.proxy.rlwy.net:50971"

# Expose app's port 
EXPOSE ${PORT}

SHELL [ "/bin/sh", "-c" ]

#HEALTHCHECK --interval=60s --timeout=10s --start-period=120s --retries=3 \
#        CMD curl -s -f http://localhost:${SERVER_PORT}/status || exit 1

# Run app
ENTRYPOINT SERVER_PORT=${PORT} java -jar app.jar