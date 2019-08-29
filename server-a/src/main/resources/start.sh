#!/bin/sh
java -XX:+UseConcMarkSweepGC -Xmx1024m -Xms1024m  -XX:+PrintGCDateStamps -XX:+PrintGCDetails -Xloggc:./logs/java_gc.log -Dfile.encoding=UTF-8 -Dsun.jnu.encoding=UTF-8 -Denv=dev   -Duser.timezone=Asia/Shanghai  -jar server-a.jar --spring.profiles.active=default


