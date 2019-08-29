FROM java:8
VOLUME /tmp
COPY server-a.jar app.jar
RUN bash -c "touch /app.jar"
EXPOSE 9191
ENTRYPOINT ["java","-jar","app.jar"]