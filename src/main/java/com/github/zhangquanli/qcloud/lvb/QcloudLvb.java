package com.github.zhangquanli.qcloud.lvb;

/**
 * QcloudLvb
 *
 * @author zhangquanli
 */
public interface QcloudLvb {

    /**
     * 获取推流地址
     *
     * @return 推流地址
     */
    String getPushUrl();

    /**
     * 获取推流串流码
     *
     * @param streamId 频道编号
     * @return 推流串流码
     */
    String getPushStream(String streamId);

    /**
     * 获取 rtmp 协议播放地址
     *
     * @param streamId 频道编号
     * @return 播放地址
     */
    String getRTMPPlayUrl(String streamId);

    /**
     * 获取 flv 协议播放地址
     *
     * @param streamId 频道编号
     * @return 播放地址
     */
    String getFLVPlayUrl(String streamId);

    /**
     * 获取 hls 协议播放地址
     *
     * @param streamId 频道编号
     * @return 播放地址
     */
    String getHLSPlayUrl(String streamId);
}
