#基础镜像
FROM  java:8

  #维护人
MAINTAINER   yinchong
  #RUN ["/bin/sh","-c","mkdir -p /opt/logs"]
RUN mkdir -p /opt/logs
  #RUN
#COPY ./lib/ /opt/ifaas-trace-server/lib/
  #add file
COPY server-a.jar /opt/server-a/
COPY start.sh /opt/server-a/
  #port
EXPOSE 9191

WORKDIR /opt/server-a
  #CMD
ENTRYPOINT ["./start.sh"]
