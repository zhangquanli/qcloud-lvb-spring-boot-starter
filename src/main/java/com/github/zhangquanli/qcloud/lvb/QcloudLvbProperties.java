package com.github.zhangquanli.qcloud.lvb;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * QcloudLvbProperties
 *
 * @author zhangquanli
 */
@ConfigurationProperties(prefix = "qcloud.lvb")
public class QcloudLvbProperties {

    /**
     * 推流域名
     */
    private String pushDomain;
    /**
     * 推流密钥
     */
    private String pushKey;
    /**
     * 过期时间，默认24小时推流地址失效
     */
    private Long pushExpire = 86400L;
    /**
     * 播放域名
     */
    private String playDomain;
    /**
     * 播放密钥
     */
    private String playKey;
    /**
     * 过期时间，默认24小时播放地址失效
     */
    private Long playExpire = 86400L;

    public String getPushDomain() {
        return pushDomain;
    }

    public void setPushDomain(String pushDomain) {
        this.pushDomain = pushDomain;
    }

    public String getPushKey() {
        return pushKey;
    }

    public void setPushKey(String pushKey) {
        this.pushKey = pushKey;
    }

    public Long getPushExpire() {
        return pushExpire;
    }

    public void setPushExpire(Long pushExpire) {
        this.pushExpire = pushExpire;
    }

    public String getPlayDomain() {
        return playDomain;
    }

    public void setPlayDomain(String playDomain) {
        this.playDomain = playDomain;
    }

    public String getPlayKey() {
        return playKey;
    }

    public void setPlayKey(String playKey) {
        this.playKey = playKey;
    }

    public Long getPlayExpire() {
        return playExpire;
    }

    public void setPlayExpire(Long playExpire) {
        this.playExpire = playExpire;
    }
}
