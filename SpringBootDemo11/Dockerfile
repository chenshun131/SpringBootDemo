FROM openjdk:8-jre
MAINTAINER chenshun "1539831174@qq.com"

# Create service directory
ARG APP_NAME
RUN mkdir -p /opt/service/${APP_NAME}/lib

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
ADD target/lib /opt/service/${APP_NAME}/lib

# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /opt/service/${APP_NAME}/${APP_NAME}.jar

EXPOSE 8080

# Run the service
ENTRYPOINT ["/usr/bin/java", "-jar", "/opt/service/${APP_NAME}/${APP_NAME}.jar"]