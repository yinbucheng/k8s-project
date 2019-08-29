#基础镜像
FROM  java:8

  #维护人
MAINTAINER   yinchong
  #RUN ["/bin/sh","-c","mkdir -p /opt/logs"]
RUN mkdir -p /opt/logs
  #RUN
#COPY ./lib/ /opt/ifaas-trace-server/lib/
  #add file
COPY server-b.jar /opt/server-b/
COPY start.sh /opt/server-b/
  #port
EXPOSE 9292

WORKDIR /opt/server-b
  #CMD
ENTRYPOINT ["./start.sh"]
