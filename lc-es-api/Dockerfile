# 指定基础镜像，在其上进行定制
FROM java:8

# 维护者信息
MAINTAINER LC ahlc@sina.cn

# 这里的 /tmp 目录就会在运行时自动挂载为匿名卷，任何向 /tmp 中写入的信息都不会记录进容器存储层
VOLUME /tmp

# 复制上下文目录下的target/lc-es-api-0.0.1-SNAPSHOT.jar 到容器里 起别名为 app.jar
# ADD target/lc-es-api-0.0.1-SNAPSHOT.jar /app.jar
# 由于pom.xml配置了【<finalName>app</finalName>】 所以会自动打包成 app.jar
# 故要改成下面的写法 复制上下文目录下的target/app.jar 到容器里 起别名也叫为 app.jar
ADD target/app.jar /app.jar

# 指定容器启动程序及参数   <ENTRYPOINT> "<CMD>"
ENTRYPOINT ["java","-jar","/app.jar"]