package cn.onuo.backend.common.utils.ocr;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * 京东验证身份接口
 */
public class TestCardIdAndName {

    /**
     * 验证身份证号与名字是否匹配
     */
    @Test
    public void testHttpFlow() {
        String cardId="522425199611015476";
        String cardName="汪应昌";
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response1 = template.getForEntity("https://way.jd.com/VerifyIdcard/J65?cardNo="+
            cardId+"&realName="+cardName+"&appkey=b0695387176591a3f89c3652cacf542e", String.class);
        System.out.println(response1.getBody());
        JSON json= JSON.parseObject(response1.getBody());
        String flag=((JSONObject) json).getJSONObject("result").getJSONObject("result").getString("isok");
        System.out.println("===========");
        System.out.println(flag);
    }
}
