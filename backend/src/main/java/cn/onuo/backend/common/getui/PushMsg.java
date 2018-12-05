package cn.onuo.backend.common.getui;

import lombok.Data;

/**
 * Created by m1333 on 2018/6/15.
 */

/**
 * 个推相关信息
 */
@Data
public class PushMsg {
    /**
     * 用户终端类型
     */
    private  String type;
    /**
     * 推送标题
     */
    private  String title;
    /**
     * 推送消息
     */
    private  String messageInfo;
    private  String badge;
    /**
     * 用户Id
     */
    private  String cid;

    /**
     * 初始化推送
     * @param clientId
     * @param android
     * @param msgTitle
     * @param msgContent
     * @param s
     * @return
     */
    public static PushMsg initial(String clientId, String android, String msgTitle, String msgContent, String s) {
        PushMsg pushMsg=new PushMsg();
        pushMsg.setCid(clientId);
        pushMsg.setType(android);
        pushMsg.setTitle(msgTitle);
        pushMsg.setMessageInfo(msgContent);
        pushMsg.setBadge(s);
        return pushMsg;
    }
}
