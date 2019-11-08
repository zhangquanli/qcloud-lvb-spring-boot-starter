package com.github.zhangquanli.qcloudlvb;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * QcloudLvbAutoConfiguration
 *
 * @author zhangquanli
 */
@Configuration
@EnableConfigurationProperties(QcloudLvbProperties.class)
@ConditionalOnProperty(prefix = "qcloud.lvb", name = {"push-domain", "push-key", "play-domain", "play-key"})
public class QcloudLvbAutoConfiguration {

    private QcloudLvbProperties qcloudLvbProperties;

    public QcloudLvbAutoConfiguration(QcloudLvbProperties qcloudlvbProperties) {
        this.qcloudLvbProperties = qcloudlvbProperties;
    }

    @Bean
    public QcloudLvb qcloudLvb() {
        return new QcloudLvbImpl(qcloudLvbProperties);
    }
}
