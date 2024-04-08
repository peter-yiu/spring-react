package com.yiu.backend.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse implements Serializable {

    private Integer code;

    private String msg;

    private Object data;

    public ApiResponse() {}



    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ApiResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    //todo update to getIsSucceed will be better 20211013  and ApiResult switch to ApiReturns,
    //have been update at healthone project
    public boolean getSuccess(){
        return this.code == 1? true :false;
    }

    public static ApiResponse success() {
        ApiResponse result = new ApiResponse();
        result.setResultCode(ApiResponseCode.SUCCESS);
        return result;
    }

    public static ApiResponse success(Object data) {
        ApiResponse result = new ApiResponse();
        result.setResultCode(ApiResponseCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static ApiResponse failure(ApiResponseCode apiResultCode) {
        ApiResponse result = new ApiResponse();
        result.setResultCode(apiResultCode);
        return result;
    }
    public static ApiResponse failMessage(String message) {
        ApiResponse result = new ApiResponse();
        result.setCode(0);
        result.setMsg(message);
        return result;
    }

    public static ApiResponse failure(ApiResponseCode apiResultCode, Object data) {
        ApiResponse result = new ApiResponse();
        result.setResultCode(apiResultCode);
        result.setData(data);
        return result;
    }

    private void setResultCode(ApiResponseCode apiResultCode) {
        this.code = apiResultCode.getCode();
        this.msg = apiResultCode.getMessage();
    }

}
