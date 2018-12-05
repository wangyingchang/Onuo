package cn.onuo.backend.common.utils.ocr;


import org.junit.jupiter.api.Test;

import java.net.URLEncoder;

/**
 * 百度OCR识别
 */
public class TestOCR {

    /**
     * 测试身份证OCR
     */
    @Test
    public void testCard() {
        //access token
        String accessToken = BaiduOCR.getAuth();
        // 身份证识别url
        String cardRequestAddress = "https://aip.baidubce.com/rest/2.0/ocr/v1/idcard";

        // 本地图片路径
        String filePath = "D:\\image\\wycCardFront.JPG";
        String filePath2 = "D:\\image\\wycCardBack.JPG";
        try {
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            byte[] imgData2 = FileUtil.readFileByBytes(filePath2);
            String imgStr = Base64Util.encode(imgData);
            String imgStr2 = Base64Util.encode(imgData2);

            // 识别身份证正面id_card_side=front;识别身份证背面id_card_side=back;
            String params = "id_card_side=front&"
                    + URLEncoder.encode("image", "UTF-8")
                    + "="
                    + URLEncoder.encode(imgStr, "UTF-8");
            String params2 = "id_card_side=back&"
                    + URLEncoder.encode("image", "UTF-8")
                    + "="
                    + URLEncoder.encode(imgStr2, "UTF-8");

            String result = HttpUtil.post(cardRequestAddress, accessToken, params);
            String result2 = HttpUtil.post(cardRequestAddress, accessToken, params2);
            System.out.println("身份证正面："+result);
            System.out.println("身份证反面："+result2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试驾驶证OCR
     */
    @Test
    public void testDriver() {
        // 本地图片路径
        String filePath = "D:\\image\\bykDriver.JPG";
        try {
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);

            // 识别身份证正面id_card_side=front;识别身份证背面id_card_side=back;
            String params = "detect_direction=true&"
                    + URLEncoder.encode("image", "UTF-8")
                    + "="
                    + URLEncoder.encode(imgStr, "UTF-8");
            String accessToken = BaiduOCR.getAuth();
            // 身份证识别url
            String idcardIdentificate = "https://aip.baidubce.com/rest/2.0/ocr/v1/driving_license";
            String result = HttpUtil.post(idcardIdentificate, accessToken, params);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}