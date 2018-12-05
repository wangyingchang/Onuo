package cn.onuo.backend.common.entity;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @author edward on 2018/5/8.
 * <p>
 * Restful Api 返回结果
 */

public class JsonResult implements Serializable {

    private int code;                //返回代码
    private String message;          //消息提示
    private Object data;             //返回数据

    public JsonResult setCode(ResponseCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public JsonResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public JsonResult setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
