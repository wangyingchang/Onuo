package cn.onuo.backend.dao;


import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName testHttpFlow
 * @Description TODO
 * @Author nanaOni
 * @Date 2018/10/15 20:28
 * @Version 1.0
 **/
public class testHttpFlow {
    @Test
    public void testHttpFlow() {
        RestTemplate template=new RestTemplate();
        ResponseEntity<String> response1=template.getForEntity("https://way.jd.com/VerifyIdcard/J65?cardNo=41072719960315411X&realName=白育恺&appkey=bf355c9c2cdcdba8ac8116ae330670e7",String.class);
        System.out.println(response1.getBody());
        return ;
    }
}
