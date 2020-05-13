FROM openjdk:8-jre-alpine
VOLUME /tmp
ARG ARTIFACT_NAME
ARG EXPOSED_PORT
ENV SPRING_PROFILES_ACTIVE docker

ADD dockerize/alpine-linux-amd64-v0.6.1/dockerize dockerize
RUN chmod +x dockerize
ADD ${ARTIFACT_NAME}.jar /app.jar
RUN touch /app.jar
EXPOSE ${EXPOSED_PORT}
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
