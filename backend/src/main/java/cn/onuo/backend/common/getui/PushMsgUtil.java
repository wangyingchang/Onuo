package cn.onuo.backend.common.getui;

import cn.onuo.backend.sys.model.User;

import java.util.List;

/**
 * Created by m1333 on 2018/6/15.
 */
public class PushMsgUtil {

    public static void pushMsgForPda(int badge, String msgTitle, String msgContent, List<User> users, String parkinfo) {

        for (int i=0;i<users.size();i++)
        {
            String cidWithType="";//users.get(i).getResume();
            String [] typeAndCid=new String[2];
            if (cidWithType!=null)
            {
                typeAndCid=cidWithType.split(",");
            }
            //判断是否是ios用户
            if (typeAndCid[0]!=null)
            {
                String clientId = typeAndCid[1];
                System.out.println(clientId);
                PushMsg msg = PushMsg.initial(clientId, typeAndCid[0], msgTitle, msgContent, badge + "");
                //AppMessagePush.sendMessage(msg);
                //TODO add的信息使用的是parkinfo  到时候如果有需要可以改
                System.out.println(typeAndCid[0]);
                System.out.println(typeAndCid[1]);
                GeTuiMessagePush.sendMessage4park(msg, parkinfo);
            }
        }
//        String ios = "ios";
//        String android = "android";
//        System.out.println(ios.length());
//        System.out.println(android.length());
//        String[] iossdid = ios.split(";");
//        String[] androidsdid = android.split(";");
//        if (ios.length() > 0) {
//            for (int i = 0; i < iossdid.length; i++) {
//                String clientId = iossdid[i].substring(4, iossdid[i].length());
//                System.out.println(clientId);
//                PushMsg msg = PushMsg.initial(clientId, "ios", msgTitle, msgContent, badge + "");
//                //AppMessagePush.sendMessage(msg);
//                //TODO add的信息使用的是parkinfo  到时候如果有需要可以改
//                GeTuiMessagePush.sendMessage4park(msg, parkinfo);
//            }
//        }
//        if (android.length() > 0) {
//            for (int i = 0; i < androidsdid.length; i++) {
//                String clientId = users;
//                PushMsg msg = PushMsg.initial(clientId, "android", msgTitle, msgContent, badge + "");
//                //  AppMessagePush.sendMessage(msg);
//                GeTuiMessagePush.sendMessage4park(msg, parkinfo);
//            }
//        }
    }
}
