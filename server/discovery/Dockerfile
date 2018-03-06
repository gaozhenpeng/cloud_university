FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD discovery-0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 8761
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
