FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ADD ./target/educonnect-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]

