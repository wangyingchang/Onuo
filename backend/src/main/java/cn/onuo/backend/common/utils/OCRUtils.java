package cn.onuo.backend.common.utils;



import cn.onuo.backend.common.entity.Card;
import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.utils.ocr.*;
import cn.onuo.backend.common.utils.ocr.Base64Util;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.net.URLEncoder;

/**
 * Created with IDEA
 * author:Yanze
 * Date:2018/7/7
 * Time:20:02
 */
public class OCRUtils {

    /**
     * 身份证OCR识别
     * @param fileCardFront
     * @return
     */
    public static JsonResult getCardInfo(MultipartFile fileCardFront) {
        // 身份证识别请求地址
        String cardRequestAddress = "https://aip.baidubce.com/rest/2.0/ocr/v1/idcard";
        // 获取access token
        String accessToken = BaiduOCR.getAuth();

        try {
            // 图片文件转换成二进制文件
            byte[] imgDataFront =fileCardFront.getBytes();
            // 编码转换
            String imgStrFront = cn.onuo.backend.common.utils.ocr.Base64Util.encode(imgDataFront);
            // 请求参数
            // 识别身份证正面id_card_side=front;识别身份证背面id_card_side=back;
            String paramsCardFront = "id_card_side=front&"
                    + URLEncoder.encode("image", "UTF-8")
                    + "="
                    + URLEncoder.encode(imgStrFront, "UTF-8");
            // 请求地址
            String resultCardFront = HttpUtil.post(cardRequestAddress,accessToken,paramsCardFront);
            System.out.println("正面身份证信息:"+resultCardFront);

            // 解析正面
            JSONObject json= JSON.parseObject(resultCardFront);
            JSONObject json1=json.getJSONObject("words_result");

            JSONObject jo1= (JSONObject)(json1).get("公民身份号码");
            String cardId=jo1.getString("words");

            JSONObject jo2= (JSONObject)(json1).get("姓名");
            String cardName=jo2.getString("words");

            JSONObject jo3= (JSONObject)(json1).get("性别");
            String cardSex=jo3.getString("words");

            JSONObject jo4= (JSONObject)(json1).get("民族");
            String cardFamousFamily=jo4.getString("words");

            JSONObject jo5= (JSONObject)(json1).get("出生");
            String cardBirthday=jo5.getString("words");

            JSONObject jo6= (JSONObject)(json1).get("住址");
            String cardAddress=jo6.getString("words");

            // 封装身份证信息
            Card card=new Card();
            card.setCardId(cardId);
            card.setCardName(cardName);
            card.setCardSex(cardSex);
            card.setCardFamousFamily(cardFamousFamily);
            card.setCarBirthday(cardBirthday);
            card.setCardAddress(cardAddress);
            // 有效时间  20230607

            return JsonResultGenerator.genSuccessResult(card);
        }catch (Exception e) {
            e.printStackTrace();
            return JsonResultGenerator.genFailResult("上传失败");
        }
    }


    /**
     * 驾驶证OCR识别
     * @param fileDriver
     * @return
     */
    public static JsonResult getDriverInfo(MultipartFile fileDriver) {
        //身份证识别请求地址
        String driverRequestAddress = "https://aip.baidubce.com/rest/2.0/ocr/v1/driving_license";
        //获取access token
        String accessToken = BaiduOCR.getAuth();
        try {
            //图片文件转换成二进制文件
            byte[] imgData =fileDriver.getBytes();
            //编码转换
            String imgStr = Base64Util.encode(imgData);

            // 请求参数
            // 识别身份证正面id_card_side=front;识别身份证背面id_card_side=back;
            String params = "detect_direction=true&"
                    + URLEncoder.encode("image", "UTF-8") + "="
                    + URLEncoder.encode(imgStr, "UTF-8");
            //请求地址
            String result = HttpUtil.post(driverRequestAddress,accessToken,params);
            System.out.println("驾驶证信息:"+result);

            //解析
            JSONObject json=JSON.parseObject(result);
            JSONObject json1=json.getJSONObject("words_result");

            JSONObject jo1= (JSONObject)(json1).get("证号");
            String driveId=jo1.getString("words");

            JSONObject jo2= (JSONObject)(json1).get("姓名");
            String driverName=jo2.getString("words");

            JSONObject jo3= (JSONObject)(json1).get("准驾车型");
            String driverType=jo3.getString("words");

            JSONObject jo4= (JSONObject)(json1).get("国籍");
            String driverCountry=jo4.getString("words");

            JSONObject jo5= (JSONObject)(json1).get("有效期限");
            String DriverValPeriod=jo5.getString("words");

            JSONObject jo6= (JSONObject)(json1).get("初次领证日期");
            String driverStartTime=jo6.getString("words");

            JSONObject jo7= (JSONObject)(json1).get("至");
            String driverEndTime=jo7.getString("words");

            JSONObject jo8= (JSONObject)(json1).get("出生日期");
            String driverBirthday=jo8.getString("words");

            JSONObject jo9= (JSONObject)(json1).get("性别");
            String driverSex=jo9.getString("words");

            JSONObject jo10= (JSONObject)(json1).get("住址");
            String driverAddress=jo10.getString("words");

            //封装驾驶证信息
            Driver driver=new Driver();
            driver.setDriveId(driveId);
            driver.setDriverName(driverName);
            driver.setDriverType(driverType);
            driver.setDriverCountry(driverCountry);
            driver.setDriverValPeriod(DriverValPeriod);
            driver.setDriverStartTime(driverStartTime);
            driver.setDriverEndTime(driverEndTime);
            driver.setDriverBirthday(driverBirthday);
            driver.setDriverSex(driverSex);
            driver.setDriverAddress(driverAddress);

            return JsonResultGenerator.genSuccessResult(driver);
        }catch (Exception e) {
            e.printStackTrace();
            return JsonResultGenerator.genFailResult("上传失败");
        }
    }
}
