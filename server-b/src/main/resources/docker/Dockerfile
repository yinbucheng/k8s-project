FROM java:8
VOLUME /tmp
COPY server-b.jar app.jar
RUN bash -c "touch /app.jar"
EXPOSE 9292
ENTRYPOINT ["java","-jar","app.jar"]
