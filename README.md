# qcloud-lvb-spring-boot-starter
基于 `SpringBoot` 框架，快速集成【腾讯云】【标准直播】服务

## 快速集成
1. 在 `pom.xml` 文件中，引入依赖
    ```xml
    <dependency>
        <groupId>com.github.zhangquanli</groupId>
        <artifactId>qcloud-lvb-spring-boot-starter</artifactId>
        <version>1.0.0</version>
    </dependency>
    ```
2. 在 `application.properties` 或 `application.yml` 文件中，进行配置
    ```properties
    qcloud.lvb.push-domain=pushDomain
    qcloud.lvb.push-key=pushKey
    qcloud.lvb.push-expire=86400
    qcloud.lvb.play-domain=playDomain
    qcloud.lvb.play-key=playKey
    qcloud.lvb.play-expire=86400
    ```
    ```yaml
    qcloud:
      lvb:
        push-domain: pushDomain
        push-key: pushKey
        push-expire: 86400
        play-domain: playDomain
        play-key: playKey
        play-expire: 86400
    ```

## 快速开发
1. 在 `Spring Boot` 项目中，可以直接注入 `QcloudLvb` 接口
    ```java
    @Resource
    private QcloudLvb qcloudLvb;
    ```
2. 使用 `QcloudLvb` 接口中封装好的方法

## 更新日志
### 1.0.0
1. 获取 `rtmpq` 协议的推流地址
2. 获取 `rtmp`, `flv`, `hls` 等协议的播放地址