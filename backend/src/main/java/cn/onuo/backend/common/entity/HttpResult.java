package cn.onuo.backend.common.entity;

import lombok.Data;

/**
 * @ClassName HttpResult
 * @Description TODO
 * @Author nanaOni
 * @Date 2018/10/16 16:58
 * @Version 1.0
 **/
@Data
public class HttpResult {

    public HttpResult(){
    }
    public HttpResult(int code,String body){
        this.code=code;
        this.body=body;
    }
    private int code;
    private String body;
}
