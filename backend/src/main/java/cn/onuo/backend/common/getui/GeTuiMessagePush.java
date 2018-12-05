package cn.onuo.backend.common.getui;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.ITemplate;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.base.payload.APNPayload;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;

/**
 * Created by m1333 on 2018/6/15.
 */

public class GeTuiMessagePush {

    /**
     * 配置推送账户相关信息
     */
    private static String appId = "PhlO2oGg3j8Oq6kGmR16f1";
    private static String appKey = "CnvEqkSrk76spLZyoL16o4";
    private static String masterSecret = "6e9Qbc7j369KiE0zhKozV6";


    public static void sendMessage(PushMsg msg) {
        if (msg.getType().equals("android")) {
            ITemplate notificationTemplate = notificationTemplateDemo(
                    msg.getTitle(), msg.getMessageInfo(), msg.getBadge());
            pushSingleMessage(msg.getCid(), notificationTemplate, true);
            ITemplate iosTransmissionTemplate = iosTransmissionTemplate(
                    msg.getTitle(), msg.getMessageInfo(), msg.getBadge());// 带APNPayload
            pushSingleMessage(msg.getCid(), iosTransmissionTemplate, true);
        } else if (msg.getType().equals("ios")) {
            // ios透传通知 安卓透传
            ITemplate iosTransmissionTemplate = iosTransmissionTemplate(
                    msg.getTitle(), msg.getMessageInfo(), msg.getBadge());// 带APNPayload
            pushSingleMessage(msg.getCid(), iosTransmissionTemplate, true);
        }
    }

    /**
     * 消息推送和透传
     */
    public static void sendMessage4park(PushMsg msg,String parkinfo) {
        if (msg.getType().equals("android")) {
            ITemplate notificationTemplate = notificationTemplateDemo(
                    msg.getTitle(), parkinfo, msg.getBadge());
            pushSingleMessage(msg.getCid(), notificationTemplate, false);//推送通知
            ITemplate iosTransmissionTemplate = null;
            if(!"".equals(parkinfo)){
                iosTransmissionTemplate = iosTransmissionTemplate2(
                        msg.getTitle(), msg.getMessageInfo(), msg.getBadge(), parkinfo);// 带APNPayload
            } else {
                iosTransmissionTemplate = iosTransmissionTemplate(
                        msg.getTitle(), msg.getMessageInfo(), msg.getBadge());// 带APNPayload
            }
            pushSingleMessage(msg.getCid(), iosTransmissionTemplate, false);
        } else if (msg.getType().equals("ios")) {
            // ios透传通知 安卓透传
            ITemplate iosTransmissionTemplate = null;
            if(!"".equals(parkinfo)){
                iosTransmissionTemplate = iosTransmissionTemplate2(
                        msg.getTitle(), msg.getMessageInfo(), msg.getBadge(), parkinfo);// 带APNPayload
            } else {
                iosTransmissionTemplate = iosTransmissionTemplate(
                        msg.getTitle(), msg.getMessageInfo(), msg.getBadge());// 带APNPayload
            }
            pushSingleMessage(msg.getCid(), iosTransmissionTemplate, true);
        }
    }

    // 单个推送
    private static void pushSingleMessage(String Cid, ITemplate template,
                                          boolean offline) {
        IGtPush push = new IGtPush(appKey, masterSecret, true);

        SingleMessage message = new SingleMessage();

        message.setOffline(offline);
        // 离线有效时间，单位为毫秒，可选
        message.setOfflineExpireTime(24 * 3600 * 1000);
        message.setData(template);
        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
        message.setPushNetWorkType(0);
        Target target = new Target();
        target.setAppId(appId);
        target.setClientId(Cid);
        IPushResult ret = null;

        try {
            ret = push.pushMessageToSingle(message, target);
        } catch (RequestException e) {
            e.printStackTrace();
            ret = push.pushMessageToSingle(message, target, e.getRequestId());
        }
    }

    private static NotificationTemplate notificationTemplateDemo(String title,
                                                                 String messageInfo, String badge) {
        NotificationTemplate template = new NotificationTemplate();
        // 设置APPID与APPKEY
        template.setAppId(appId);
        template.setAppkey(appKey);
        // 设置通知栏标题与内容
        template.setTitle(title);
        template.setText(messageInfo);
        // 配置通知栏图标
        template.setLogo("icon.png");
        // 配置通知栏网络图标
        template.setLogoUrl("");
        // 设置通知是否响铃，震动，或者可清除
        template.setIsRing(true);
        template.setIsVibrate(true);
        template.setIsClearable(true);
        template.setAPNInfo(getApnPayload(title, messageInfo, badge));
        template.setTransmissionType(2);
        template.setTransmissionContent("notification." + messageInfo);
        return template;
    }

    // ios透传，设置APNPayload参数
    private static TransmissionTemplate iosTransmissionTemplate(String title,
                                                                String messageInfo, String badge) {
        TransmissionTemplate template = transmissionTemplate(messageInfo);
        APNPayload payload = getApnPayload(title, messageInfo, badge);
        // 字典模式使用下者
        // payload.setAlertMsg(getDictionaryAlertMsg());
        template.setAPNInfo(payload);
        return template;
    }

    /**
     * ios透传，设置APNPayload参数
     * 附带特殊参数
     */
    private static TransmissionTemplate iosTransmissionTemplate2(String title,
                                                                 String messageInfo, String badge, String parkinfo) {
        TransmissionTemplate template = transmissionTemplate(messageInfo);
        //APNPayload payload = getApnPayload(title, messageInfo, badge);
        APNPayload payload = getApnPayload4park(title, messageInfo, badge,parkinfo);
        // 字典模式使用下者
        // payload.setAlertMsg(getDictionaryAlertMsg());
        template.setAPNInfo(payload);
        return template;
    }

    private static APNPayload getApnPayload(String title, String messageInfo,
                                            String badge) {
        APNPayload payload = new APNPayload();
        // +1在已有数字基础上加1显示，设置为-1时，在已有数字上减1显示，设置为数字时，显示指定数字
        payload.setAutoBadge(badge);
        payload.setContentAvailable(1);
        payload.setSound("123.wav");
        payload.setCategory("$由客户端定义");
        // //简单模式APNPayload.SimpleMsg
        // payload.setAlertMsg(new APNPayload.SimpleAlertMsg(messageInfo));
        APNPayload.DictionaryAlertMsg dictionaryAlertMsg = new APNPayload.DictionaryAlertMsg();
        dictionaryAlertMsg.setTitle(title);
        dictionaryAlertMsg.setBody(messageInfo);
        payload.setAlertMsg(dictionaryAlertMsg);
        //payload.addCustomMsg("parkinfo", "{\"parkid\":\"停车场id\",\"platenum\":\"车位号\",\"statue\":\"状态\"}");
        return payload;
    }

    /**
     * 停车场透传信息，附带parkinfo
     */
    private static APNPayload getApnPayload4park(String title, String messageInfo,
                                                 String badge, String parkinfo) {
        APNPayload payload = new APNPayload();
        // +1在已有数字基础上加1显示，设置为-1时，在已有数字上减1显示，设置为数字时，显示指定数字
        payload.setAutoBadge(badge);
        payload.setContentAvailable(1);
        payload.setSound("123.wav");
        payload.setCategory("$由客户端定义");
        // //简单模式APNPayload.SimpleMsg
        // payload.setAlertMsg(new APNPayload.SimpleAlertMsg(messageInfo));
        APNPayload.DictionaryAlertMsg dictionaryAlertMsg = new APNPayload.DictionaryAlertMsg();
        dictionaryAlertMsg.setTitle(title);
        dictionaryAlertMsg.setBody(messageInfo);
        payload.setAlertMsg(dictionaryAlertMsg);
        payload.addCustomMsg("parkinfo", parkinfo);
        return payload;
    }

    // 透传消息
    private static TransmissionTemplate transmissionTemplate(String messageInfo) {
        TransmissionTemplate template = new TransmissionTemplate();
        template.setAppId(appId);
        template.setAppkey(appKey);
        template.setTransmissionContent(messageInfo);
        template.setTransmissionType(2);
        return template;
    }

}
