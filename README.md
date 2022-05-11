# common
公共包





## nacos操作流程

### 1、nacos下载 和安装流程

```
git clone https://github.com/alibaba/nacos.git
cd nacos/
mvn -Prelease-nacos -Dmaven.test.skip=true clean install -U  
ls -al distribution/target/

// change the $version to your actual path
cd distribution/target/nacos-server-$version/nacos/bin
```

### 2、windows服务启动nacos

```
./startup.cmd -m standalone
```



### 3、启动成功访问

```
localhost:8848/nacos
初始账号密码 nacos nacos
```

