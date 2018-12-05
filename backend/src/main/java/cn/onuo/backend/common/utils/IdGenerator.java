package cn.onuo.backend.common.utils;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class IdGenerator {
    public static String getNewUserId() {
        String ipAddress = "";
        try {
            //获取服务器IP地址
            ipAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //获取UUID
        String uuid = ipAddress + "$" + UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        //生成后缀
        long suffix = Math.abs(uuid.hashCode() % 100000000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String time = sdf.format(new Date(System.currentTimeMillis()));
        //生成前缀m
        long prefix = Long.parseLong(time) * 100000000;
        String userId = String.valueOf(prefix + suffix);
        return userId;
    }
    /**
     * 生成随机数
     * 创建指定数量的随机字符串
     * @param numberFlag 是否是数字
     * @param length
     * @return
     */
    public static String createRandom(boolean numberFlag, int length){
        String retStr;
        String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
        int len = strTable.length();
        boolean bDone = true;
        do {
            retStr = "";
            int count = 0;
            for (int i = 0; i < length; i++) {
                double dblR = Math.random() * len;
                int intR = (int) Math.floor(dblR);
                char c = strTable.charAt(intR);
                if (('0' <= c) && (c <= '9')) {
                    count++;
                }
                retStr += strTable.charAt(intR);
            }
            if (count >= 2) {
                bDone = false;
            }
        } while (bDone);
        return retStr;
    }
}
