package cn.onuo.backend.common.utils;

import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.entity.ResponseCode;

public class JsonResultGenerator {

    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private static final String DEFAULT_OK_MESSAGE = "OK";
    private static final String DEFAULT_UNAUTHORIZED_MESSAGE = "need token";
    private static final String DEFAULT_METHOD_NOT_ALLOWED_MESSAGE = "request method error";

    public static JsonResult genResult(ResponseCode code, String message, Object data){
        return new JsonResult()
                .setCode(code)
                .setMessage(message)
                .setData(data);
    }
    public static JsonResult genSuccessResult() {
        return new JsonResult()
                .setCode(ResponseCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static JsonResult genSuccessResult(Object data) {
        return new JsonResult()
                .setCode(ResponseCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static JsonResult genFailResult(String message) {
        return new JsonResult()
                .setCode(ResponseCode.FAIL)
                .setMessage(message);
    }

    public static JsonResult genUnauthorizedResult() {
        return new JsonResult()
                .setCode(ResponseCode.UNAUTHORIZED)
                .setMessage(DEFAULT_UNAUTHORIZED_MESSAGE);
    }


    public static JsonResult genInternalServerErrorResult(final String url) {
        return new JsonResult()
                .setCode(ResponseCode.INTERNAL_SERVER_ERROR)
                .setMessage("API [" + url + "] internal error");
    }
}
