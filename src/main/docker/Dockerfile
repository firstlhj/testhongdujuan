# 指定基础镜像
FROM openjdk:8-jdk-alpine
#指定挂载点
VOLUME /tmp
#将本地文件或目录复制到由dockerfile构建的镜像中
ADD personalbio01-0.0.1-SNAPSHOT.jar app.jar
#设置环境变量
#ENV JAVA_OPTS=""
#提供容器运行的默认命令
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]