package com.github.zhangquanli.qcloudlvb;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * QcloudLvbImpl
 *
 * @author zhangquanli
 */
public class QcloudLvbImpl implements QcloudLvb {

    private String pushDomain;
    private String pushKey;
    private Long pushExpire;
    private String playDomain;
    private String playKey;
    private Long playExpire;

    public QcloudLvbImpl(QcloudLvbProperties qcloudLvbProperties) {
        this.pushDomain = qcloudLvbProperties.getPushDomain();
        this.pushKey = qcloudLvbProperties.getPushKey();
        this.pushExpire = qcloudLvbProperties.getPushExpire();
        this.playDomain = qcloudLvbProperties.getPlayDomain();
        this.playKey = qcloudLvbProperties.getPlayKey();
        this.playExpire = qcloudLvbProperties.getPlayExpire();
    }

    @Override
    public String getPushUrl() {
        return "rtmp://" + pushDomain + "/live/";
    }

    @Override
    public String getPushStream(String streamName) {
        // txTime
        String txTime = generateTxTime(pushExpire);
        // txSecret
        String txSecret = generateTxSecret(pushKey, streamName, txTime);
        return streamName
                + "?txSecret=" + txSecret
                + "&txTime=" + txTime;
    }

    @Override
    public String getRTMPPlayUrl(String streamName) {
        // txTime
        String txTime = generateTxTime(playExpire);
        // txSecret
        String txSecret = generateTxSecret(playKey, streamName, txTime);
        return "rtmp://" + playDomain + "/live/"
                + streamName
                + "?txSecret=" + txSecret
                + "&txTime=" + txTime;
    }

    @Override
    public String getFLVPlayUrl(String streamName) {
        // txTime
        String txTime = generateTxTime(playExpire);
        // txSecret
        String txSecret = generateTxSecret(playKey, streamName, txTime);
        return "http://" + playDomain + "/live/"
                + streamName + ".flv"
                + "?txSecret=" + txSecret
                + "&txTime=" + txTime;
    }

    @Override
    public String getHLSPlayUrl(String streamName) {
        // txTime
        String txTime = generateTxTime(playExpire);
        // txSecret
        String txSecret = generateTxSecret(playKey, streamName, txTime);
        return "http://" + playDomain + "/live/"
                + streamName + ".m3u8"
                + "?txSecret=" + txSecret
                + "&txTime=" + txTime;
    }

    private String generateTxTime(long expire) {
        long time = System.currentTimeMillis() / 1000 + expire;
        return Long.toHexString(time).toUpperCase();
    }

    private String generateTxSecret(String key, String streamName, String txTime) {
        try {
            String inputStr = key + streamName + txTime;
            byte[] inputBytes = inputStr.getBytes(StandardCharsets.UTF_8);
            byte[] outputBytes = MessageDigest.getInstance("MD5").digest(inputBytes);
            return byteArrayToHexString(outputBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    private String byteArrayToHexString(byte[] data) {
        char[] digitsLower = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] out = new char[data.length << 1];
        for (int i = 0, j = 0; i < data.length; i++) {
            out[j++] = digitsLower[(0xF0 & data[i]) >>> 4];
            out[j++] = digitsLower[0x0F & data[i]];
        }
        return new String(out);
    }
}
