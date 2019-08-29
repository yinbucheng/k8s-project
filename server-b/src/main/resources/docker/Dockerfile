#基础镜像
FROM  intellif.io/ci/alpine-oraclejdk8:0.2

  #维护人
MAINTAINER   yinchong
  #RUN ["/bin/sh","-c","mkdir -p /opt/logs"]
RUN mkdir -p /opt/logs
  #RUN
COPY ./lib/ /opt/ifaas-trace-server/lib/
  #add file
COPY api.jar /opt/ifaas-trace-server/
COPY start.sh /opt/ifaas-trace-server/
  #port
EXPOSE 9411

WORKDIR /opt/ifaas-trace-server
  #CMD
ENTRYPOINT ["./start.sh"]
