FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD zipkin-0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 9411
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
