package com.ecare.web.util;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import cn.jpush.api.push.model.notification.WinphoneNotification;
import com.ecare.web.vo.Constant.Constant;


import java.util.HashMap;
import java.util.Map;

import static cn.jpush.api.push.model.notification.PlatformNotification.ALERT;

/**
 * Created by L on 2016/8/1.
 */
public class JpushUtil {
    //    protected static final Logger log = LoggerFactory.getLogger(Jdpush.class);
    public static JPushClient jpushClient = null;

    private JpushUtil() {

    }

    /**
     * 推送通知接口
     *
     * @param alias   别名
     * @param tags    tag数组
     * @param title   推送标题
     * @param btype   推送类型
     * @param content 推送内容
     */

    public static synchronized void sendPushNotice(String alias, String[] tags, String title, String btype, String content) {
        jpushClient = new JPushClient(Constant.JPUSH_MASTER_SECRET, Constant.JPUSH_APP_KEY);
        PushPayload payload = null;
        // 生成推送的内容，这里我们先测试全部推送
        // 通知提示信息
        if (content != null) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("btype", btype);
            // 根据别名推送
            if (alias != null && tags == null) {
                payload = buildPushObject_all_all_alias(alias, title, content, map);
            } else if (alias == null && tags != null) { // 根据tag[]推送
                payload = buildPushObject_all_all_tag(tags, title, content, map);
            } else if (alias != null && tags != null) { // 别名和tags[] 推送通知
                payload = buildPushObject_all_all_aliasAndTag(alias, tags, title, content, map);
            } else if (alias == null && tags == null) {
                payload = buildPushObject_all_all(title, content, map);
            }
        } else {
//            log.info("No notification - " + content);
        }
        try {
            System.out.println(payload.toString());
            PushResult result = jpushClient.sendPush(payload);
            System.out.println(result.msg_id + "................................");
//            log.info("Got result - " + result);
        } catch (APIConnectionException e) {
//            log.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
//            log.error("Error response from JPush server. Should review and fix it. ", e);
//            log.info("HTTP Status: " + e.getStatus());
//            log.info("Error Code: " + e.getErrorCode());
//            log.info("Error Message: " + e.getErrorMessage());
//            log.info("Msg ID: " + e.getMsgId());
        }

    }
    /**
     * 推送消息接口
     *
     * @param alias   别名
     * @param content 推送内容
     */
    public static synchronized void sendPushMessage(String alias, String content) {
        jpushClient = new JPushClient(Constant.JPUSH_MASTER_SECRET, Constant.JPUSH_APP_KEY);
        PushPayload payload = null;
        // For push, all you need do is to build PushPayload object.
        // PushPayload payload = buildPushObject_all_all_alert();
        // 判断用户别名和tag不为空的情况下才推送修改标签（tag）
        if (content != null && alias != null) {
            payload = PushPayload.newBuilder()
                    .setAudience(Audience.alias(alias))
                    .setPlatform(Platform.all())
                    .setMessage(Message.content(content)).build();
        } else {
//            log.info("No notification - " + content);
        }
        try {
            System.out.println(payload.toString());
            PushResult result = jpushClient.sendPush(payload);
            System.out.println(result + "................................");
//            log.info("Got result - " + result);
        } catch (APIConnectionException e) {
            e.getStackTrace();
//            log.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            e.getStackTrace();
//            log.error("Error response from JPush server. Should review and fix it. ", e);
//            log.info("HTTP Status: " + e.getStatus());
//            log.info("Error Code: " + e.getErrorCode());
//            log.info("Error Message: " + e.getErrorMessage());
//            log.info("Msg ID: " + e.getMsgId());
        }
    }


    public static PushPayload buildPushObject_all_all_alias(String alias, String title, String content, Map<String, String> map) {
        return PushPayload
                .newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
                .setNotification(
                        Notification
                                .newBuilder()
                                .addPlatformNotification(
                                        IosNotification.newBuilder()
                                                .setAlert(content)
                                                .addExtras(map).build())
                                .addPlatformNotification(
                                        AndroidNotification.newBuilder()
                                                .setAlert(content)
                                                .setTitle(title).addExtras(map)
                                                .build())
                                .addPlatformNotification(
                                        WinphoneNotification.newBuilder()
                                                .setAlert(content)
                                                .addExtras(map).build())
                                .build()).build();

    }


    public static PushPayload buildPushObject_all_all_tag(String[] tags, String title, String content, Map<String, String> map) {
        return PushPayload
                .newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.tag(tags))
                .setNotification(
                        Notification
                                .newBuilder()
                                .addPlatformNotification(
                                        IosNotification.newBuilder()
                                                .setAlert(content)
                                                .addExtras(map).build())
                                .addPlatformNotification(
                                        AndroidNotification.newBuilder()
                                                .setAlert(content)
                                                .setTitle(title).addExtras(map)
                                                .build())
                                .addPlatformNotification(
                                        WinphoneNotification.newBuilder()
                                                .setAlert(content)
                                                .addExtras(map).build())
                                .build()).build();
    }


    public static PushPayload buildPushObject_all_all_aliasAndTag(String alias, String[] tags, String title, String content, Map<String, String> map) {
        return PushPayload
                .newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
                .setAudience(Audience.tag(tags))
                .setNotification(
                        Notification
                                .newBuilder()
                                .addPlatformNotification(
                                        IosNotification.newBuilder()
                                                .setAlert(content)
                                                .addExtras(map).build())
                                .addPlatformNotification(
                                        AndroidNotification.newBuilder()
                                                .setAlert(content)
                                                .setTitle(title).addExtras(map)
                                                .build())
                                .addPlatformNotification(
                                        WinphoneNotification.newBuilder()
                                                .setAlert(content)
                                                .addExtras(map).build())
                                .build()).build();
    }


    public static PushPayload buildPushObject_all_all(String title, String content, Map<String, String> map) {
        return PushPayload
                .newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.all())
                .setNotification(
                        Notification
                                .newBuilder()
                                .addPlatformNotification(
                                        IosNotification.newBuilder()
                                                .setAlert(content)
                                                .addExtras(map).build())
                                .addPlatformNotification(
                                        AndroidNotification.newBuilder()
                                                .setAlert(content)
                                                .setTitle(title).addExtras(map)
                                                .build())
                                .addPlatformNotification(
                                        WinphoneNotification.newBuilder()
                                                .setAlert(content)
                                                .addExtras(map).build())
                                .build()).build();
    }

}


