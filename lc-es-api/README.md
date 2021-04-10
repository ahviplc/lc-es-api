### ElasticSearch7.6以上的API操作项目
###### SpringBoot与ElasticSearch的集成
###### 使用Java High Level REST Client操作ElasticSearch的API示例

> https://github.com/ahviplc/lc-es-api.git

**ahviplc/lc-es-api**
> https://github.com/ahviplc/lc-es-api

### ES搜索实战
新增了ES实战,从JD通过关键字搜索出来的商品进行爬虫,写入ES,再从ES中搜索的整个流程,前后端分离,
前端使用了vue!

### MyBatisPlus实战
新增了MyBatisPlus实战,同时完美集成Mysql和Oracle数据库操作了,同时附带测试!代码生成器集成了,也可使用!还有其他的一些相关资料文档!

### Shiro实战
新增了Shiro实战,权限管理!

### SpringBoot|定时任务 定时器
新增了SpringBoot内置自带的定时任务,定时器实战!

### EasyExcel实战
alibaba/easyexcel: 快速、简单避免OOM的java处理Excel工具  
> https://github.com/alibaba/easyexcel

### 其他
> 引入自己私有maven仓库的JustToolc,可能会出现下面的问题 - 已解决 fastgit 有时候会这样 已有其他解决方案.
>具体请看

GitHub - ahviplc/maven-repository: LC的私人maven仓库.
> https://github.com/ahviplc/maven-repository

解决下面问题,请去上面github,有详细说明.
```markdown
Could not transfer artifact com.lc:JustToolc:pom:0.2.0 from/to ahviplc-maven-repo 
(https://raw.fastgit.org/ahviplc/maven-repository/master/repository): Transfer failed for 
https://raw.fastgit.org/ahviplc/maven-repository/master/repository/com/lc/JustToolc/0.2.0/JustToolc-0.2.0.pom
```

### 一些链接
```markdown
Docker Hub
https://registry.hub.docker.com/repositories

Docker学习的一些基本命令和用法_向日的知识小站-CSDN博客
https://blog.csdn.net/weixin_41465541/article/details/82495332

Docker容器进入的4种方式 - 純黑色 - 博客园
https://www.cnblogs.com/xhyan/p/6593075.html

docker logs－查看docker容器日志 - 简书
https://www.jianshu.com/p/1eb1d1d3f25e

Docker私服搭建及上传自己镜像到私服仓库_两年经验的小码农的博客-CSDN博客_docker 私服
https://blog.csdn.net/qq_39623859/article/details/79752803

denied: requested access to the resource is denied出现原因和解决方案_钢琴线与小刀的博客-CSDN博客
https://blog.csdn.net/qq_38115310/article/details/107388099

docker 删除某个 tag_极客on之路-CSDN博客_docker 删除tag
https://blog.csdn.net/u014756827/article/details/100699727

GitHub - rancher/rancher: Complete container management platform
https://github.com/rancher/rancher

Enterprise Kubernetes Management | Rancher
https://rancher.com/

Rancher文档 | K8S文档 | Rancher | Rancher文档
http://docs.rancher.cn/

【一点教程】Docker+SpringCloud微服务部署_哔哩哔哩 (゜-゜)つロ 干杯~-bilibili
https://www.bilibili.com/video/BV1s5411j7zq?p=25

GitHub - spotify/docker-maven-plugin: INACTIVE: A maven plugin for Docker
https://github.com/spotify/docker-maven-plugin

docker-maven-plugin详细使用方法_0xac001d09-CSDN博客_docker-maven-plugin
https://blog.csdn.net/weixin_44424668/article/details/104062822

Maven 插件之 docker-maven-plugin 的使用 - 星朝 - 博客园
https://www.cnblogs.com/jpfss/p/10945324.html

清空 打包 docker构建镜像 maven命令
> mvn clean package docker:build

-X 显示的更加详细log输出
> mvn clean package docker:build -X

创建 lc-es-api-idea 镜像 成功
``
[INFO] Building image lc-es-api-idea
Step 1/3 : FROM java:8

 ---> d23bdf5b1b1b
Step 2/3 : ADD /app.jar //

 ---> f05e3e827759
Step 3/3 : ENTRYPOINT ["java", "‐jar", "/app.jar"]

 ---> Running in 2d55719451e8
Removing intermediate container 2d55719451e8
 ---> 439b3a456c75
ProgressMessage{id=null, status=null, stream=null, error=null, progress=null, progressDetail=null}
Successfully built 439b3a456c75
Successfully tagged lc-es-api-idea:latest

查看docker images
REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
lc-es-api-idea      latest              439b3a456c75        50 seconds ago      733MB

以此镜像 【lc-es-api-idea】 运行成一个容器 试试
根据镜像image执行run 生成对应容器 -d 后台运行 并允许 -p 映射端口-本地8088到容器8088
> docker run -di -p 8088:8088 --name lc-es-api-idea-run lc-es-api-idea

> docker run --name lc-es-api-idea-run -d -i -p 8088:8088 lc-es-api-idea:latest 

访问我:
localhost:8088
``

将其 docker-maven-plugin 成功使用 参考的文章 如下:
666666 -有观点-这个实践下来-确实需要的-加这个jar进maven的pom.xml- maven-docker整合时候，使用mvn docker:build发生javax.activation.DataSource没找到的异常_blueboz的博客-CSDN博客
https://blog.csdn.net/blueboz/article/details/105270641

666666 -说的很对-我这边就是因为-设置成了其他jdk8镜像【<baseImage>java:8</baseImage>】 - 而我的docker里就是只有java:8设置成java:8这个镜像【<baseImage>java:8</baseImage>】就可以了 - pull access denied for jdk1.8, repository does not exist or may require 'docker login'解决_tlimited的博客-CSDN博客
https://blog.csdn.net/u014204541/article/details/102628433

windows docker desktop 设置2375端口远程访问_ZouChengli的博客-CSDN博客
https://blog.csdn.net/ZouChengli/article/details/106616879

Maven的六类属性，${project.basedir}，${project.build.directory}：项目构件输出目录，默认为 target/ 
https://my.oschina.net/u/4292771/blog/3305782
```

### Dockerfile

> 备份

```dockerfile
# 指定基础镜像，在其上进行定制
FROM java:8

# 维护者信息
MAINTAINER LC

# 这里的 /tmp 目录就会在运行时自动挂载为匿名卷，任何向 /tmp 中写入的信息都不会记录进容器存储层
VOLUME /tmp

# 复制上下文目录下的target/lc-es-api-0.0.1-SNAPSHOT.jar 到容器里
COPY target/lc-es-api-0.0.1-SNAPSHOT.jar lc-es-api-0.0.1-SNAPSHOT.jar

# bash方式执行，使lc-es-api-0.0.1-SNAPSHOT.jar可访问
# RUN新建立一层，在其上执行这些命令，执行结束后， commit 这一层的修改，构成新的镜像。
RUN bash -c "touch /lc-es-api-0.0.1-SNAPSHOT.jar"

# 声明运行时容器提供服务端口，这只是一个声明，在运行时并不会因为这个声明应用就会开启这个端口的服务
# EXPOSE 8088 3306

# 指定容器启动程序及参数   <ENTRYPOINT> "<CMD>"
ENTRYPOINT ["java","-jar","lc-es-api-0.0.1-SNAPSHOT.jar"]
```

可用版Dockerfile
下面就是根据如下Dockerfile制做的镜像 并推送到 远程官方 docker hub 仓库的.
Docker Hub
> https://registry.hub.docker.com/repository/docker/ahviplc/lc-es-api

ahviplc/lc-es-api Tags
https://registry.hub.docker.com/r/ahviplc/lc-es-api/tags?page=1&ordering=last_updated

请拉取尝鲜吧
> docker pull ahviplc/lc-es-api:latest

```dockerfile
# 指定基础镜像，在其上进行定制
FROM java:8

# 维护者信息
MAINTAINER LC

# 这里的 /tmp 目录就会在运行时自动挂载为匿名卷，任何向 /tmp 中写入的信息都不会记录进容器存储层
VOLUME /tmp

# 复制上下文目录下的target/lc-es-api-0.0.1-SNAPSHOT.jar 到容器里 起别名为 app.jar
ADD target/lc-es-api-0.0.1-SNAPSHOT.jar /app.jar

# 指定容器启动程序及参数   <ENTRYPOINT> "<CMD>"
ENTRYPOINT ["java","-jar","/app.jar"]
```

### docker执行过程与一些docker知识点
```markdown
1. 打包 
maven clean package

2. 编写 Dockerfile

3. 根据 Dockerfile 生成镜像 镜像名称为: lc-es-api
docker build -t lc-es-api .

删除镜像 - 先删除其对应启动的容器 再删除此镜像
docker rmi 50d42d1b15ff

4. 根据镜像image执行run 生成对应容器 -d 后台运行 并允许 -p 映射端口-本地8088到容器8088
docker run -d -p 8088:8088 --name lc-es-api-run lc-es-api

创建一个守护式容器：如果对于一个需要长期运行的容器来说，我们可以创建一个守护式容器
docker run -di -p 8088:8088 --name lc-es-api-run lc-es-api

登录守护式容器
docker exec -it lc-es-api-run /bin/bash

删除容器 - 需要先将其停止
docker rm 04e3451233de

5. 进入 lc-es-api-run 容器内部 控制台 就是一个linux结构的小型系统 可使用linux命令进行系列操作
备注：不使用容器id 使用Names 名称 也是可以的
使用docker exec进入Docker容器
docker exec -it 04e3451233de /bin/bash 

登录守护式容器
docker exec -it lc-es-api-run /bin/bash

使用 exit 即可退出

6. 查看容器执行的日志
``
docker logs [OPTIONS] CONTAINER
    Options:
          --details        显示更多的信息
      -f, --follow         跟踪实时日志
          --since string   显示自某个timestamp之后的日志，或相对时间，如42m（即42分钟）
          --tail string    从日志末尾显示多少行日志， 默认是all
      -t, --timestamps     显示时间戳
          --until string   显示自某个timestamp之前的日志，或相对时间，如42m（即42分钟）
``
例子：
查看日志,跟踪实时日志，只显示最后30行 备注：不使用容器id 使用Names 名称 也是可以的：
$ docker logs -f --tail=30 CONTAINER_ID/NAMES
实际使用
$ docker logs -f --tail=30  lc-es-api-run

查看指定时间后的日志，只显示最后100行：
$ docker logs -f -t --since="2018-02-08" --tail=100 CONTAINER_ID

查看最近30分钟的日志:
$ docker logs --since 30m CONTAINER_ID

查看某时间之后的日志：
$ docker logs -t --since="2018-02-08T13:23:37" CONTAINER_ID

查看某时间段日志：
$ docker logs -t --since="2018-02-08T13:23:37" --until "2018-02-09T12:23:37" CONTAINER_ID

7. 其他docker指令
查看容器
正在执行的容器 docker ps
``
CONTAINER ID        IMAGE               COMMAND                  CREATED              STATUS              PORTS                               NAMES
04e3451233de        lc-es-api           "java -jar /app.jar"     About a minute ago   Up About a minute   0.0.0.0:8088->8088/tcp              lc-es-api-run
773f1c5a9827        mysql:latest        "docker-entrypoint.s…"   10 months ago       Up 44 minutes       0.0.0.0:3306->3306/tcp, 33060/tcp   mysql-docker
``

所有的容器 docker ps -a

查看镜像 docker images
``
docker images
  REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
  lc-es-api           latest              bcf88f025394        About an hour ago   733MB
  mysql               latest              30f937e841c8        10 months ago       541MB
  nginx               latest              6678c7c2e56c        13 months ago       127MB
  hello-world         latest              bf756fb1ae65        15 months ago       13.3kB
  java                8                   d23bdf5b1b1b        4 years ago         643MB
``

使用docker inspect来查看该容器的详细信息 docker inspect 04e3451233de 

文件的拷贝
从宿主机目录拷贝到容器内部
docker cp 宿主机目录 容器名称：容器目录

实战：
将temp-todo.txt拷贝到lc-es-api-run容器的根目录下的/usr/lc-temp-folder目录
docker cp .\temp-todo.txt lc-es-api-run:/usr/lc-temp-folder/
备注: 这里lc-temp-folder文件夹 在win docker下 不会自动创建

这样下面操作的话 temp-todo.txt 文本文件内容 会在lc-temp-folder文件里 lc-temp-folder现在就是个文件 不是目录
docker cp .\temp-todo.txt lc-es-api-run:/usr/lc-temp-folder

将temp-todo.txt拷贝到lc-es-api-run容器的根目录下的/usr/local目录
docker cp .\temp-todo.txt lc-es-api-run:/usr/local


从容器内部拷贝到宿主机目录
docker cp 容器名称：容器目录 宿主机目录

目录挂载(必须在容器创建的时候进行挂载)
docker run -di --name=容器名称 -v 宿主机目录：容器目录 镜像IMAGE(lc-es-api)/镜像名称REPOSITORY(lc-es-api)/镜像id对应IMAGE ID(bcf88f025394)

实战 - 创建守护容器 目录挂载 -v 端口映射 -p 容器名称 --name
在Win docker下:
docker run -di -v D:\DevelopSoftKu\DockerDirMount\lc-es-api-dir:/usr/local/lc-es-api-dir -p 8088:8088 --name lc-es-api-run-dir lc-es-api
备注:【D:\DevelopSoftKu\DockerDirMount\lc-es-api-dir】=>【/host_mnt/d/DevelopSoftKu/DockerDirMount/lc-es-api-dir】

在Linux docker下:
docker run -di -v /home/lc-es-api-dir:/usr/local/lc-es-api-dir -p 8088:8088 --name lc-es-api-run-dir lc-es-api

进入容器查看
docker exec -it 44a9e27570bf /bin/bash
进行ls列出和cd切换到对应目录查看,成功.
``
root@44a9e27570bf:/usr/local/lc-es-api-dir# pwd
/usr/local/lc-es-api-dir
root@44a9e27570bf:/usr/local/lc-es-api-dir# cat cat.txt
看我...
``

8. 小知识
其实启动之后的容器之间 是有网关和ip的
可使用  
docker inspect 04e3451233de
docker inspect 44a9e27570bf
docker inspect 773f1c5a9827
分别查看lc-es-api-run和lc-es-api-run-dir的java的springboot项目和mysql-docker容器的详细信息
里面就有其对应的网关和ip.
lc-es-api-run-dir的44a9e27570bf如下:
``
"Gateway": "172.17.0.1",
"GlobalIPv6Address": "",
"GlobalIPv6PrefixLen": 0,
"IPAddress": "172.17.0.3",
``
MySQL的773f1c5a9827如下:
``
"Gateway": "172.17.0.1",
"IPAddress": "172.17.0.2",
``

所以可以ping通:
所以在lc-es-api-run-dir容器里 ping 172.17.0.2 MySQL和 ping 172.17.0.1 这个网关 均可成功
lc-es-api-run-dir容器 也就可以连接MySQL.
备注:如下 也就可以连接MySQL啦(宿主机器的3306端口已经映射到的MySQL容器中的3306端口,故在宿主机器上192.168.1.3:3306即可连接此docker的Mysql容器提供的服务).
【spring.datasource.url=jdbc:mysql://192.168.1.3:3306/lc-es-api?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8】

9. 上传镜像到官方Docker Hub 上
网站登录
Docker Hub
https://registry.hub.docker.com/

Docker Hub
https://registry.hub.docker.com/repositories

在Repositories下 创建如下仓库
ahviplc / lc-es-api

得到
Docker Hub
https://registry.hub.docker.com/repository/docker/ahviplc/lc-es-api

ahviplc/lc-es-api Tags
https://registry.hub.docker.com/r/ahviplc/lc-es-api/tags?page=1&ordering=last_updated

再命令行登录
docker login

按照提示输入用户名和密码，登录成功.
会在 win docker下的win机器 如下目录
C:\Users\theDiyPCOfLC\.docker
下生成 config.json 文件
``
{
	"auths": {
		"https://index.docker.io/v1/": {}
	},
	"HttpHeaders": {
		"User-Agent": "Docker-Client/19.03.8 (windows)"
	},
	"credsStore": "desktop",
	"stackOrchestrator": "swarm"
}
``

先打个tag:
将镜像打了一个标签，相当于重命名一样，让名称尽可能规范
docker tag lc-es-api ahviplc/lc-es-api:latest

查看所有镜像
``
docker images
REPOSITORY                 TAG                 IMAGE ID            CREATED             SIZE
ahviplc/lc-es-api          latest              bcf88f025394        2 hours ago         733MB
lc-es-api                  latest              bcf88f025394        2 hours ago         733MB
mysql                      latest              30f937e841c8        10 months ago       541MB
nginx                      latest              6678c7c2e56c        13 months ago       127MB
hello-world                latest              bf756fb1ae65        15 months ago       13.3kB
java                       8                   d23bdf5b1b1b        4 years ago         643MB
``

将镜像push上传到官方Docker Hub 上
docker push ahviplc/lc-es-api
或
docker push ahviplc/lc-es-api:latest

进度条走完即可.

请拉取尝鲜吧
docker pull ahviplc/lc-es-api:latest

Done.

ps. 待续
```

### 访问我
```markdown
http://localhost:8088
# 下面链接 需要安装启动 MySQL
http://localhost:8088/userlist
# 下面链接 需要安装启动 ElasticSearch
http://localhost:8088/goodslist
```

**By LC** 2020-5-27 10:15:21

