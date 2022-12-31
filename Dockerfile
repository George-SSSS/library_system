# Docker image for springboot file run
# VERSION 0.0.1
# Author:
# 基础镜像使用java
FROM openjdk:11-jre
# 作者
MAINTAINER George-SSSS
# VOLUME 指定了临时文件目录为/tmp。
# 其效果是在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp
VOLUME /tmp
# 运行 jar 包
ADD target/library-system.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8089