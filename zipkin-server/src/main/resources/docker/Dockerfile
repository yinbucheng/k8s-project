FROM java:8
VOLUME /tmp
COPY zipkin-server.jar app.jar
RUN bash -c "touch /app.jar"
EXPOSE 6090
ENTRYPOINT ["java","-jar","app.jar"]
