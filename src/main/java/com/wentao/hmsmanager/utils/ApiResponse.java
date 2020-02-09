package com.wentao.hmsmanager.utils;

import java.io.Serializable;

public class ApiResponse implements Serializable {

    private Integer code;
    private String message;
    private Object data;

    public static ApiResponse ok() {
        return new ApiResponse(200, "成功", null);
    }

    public static ApiResponse ok(String message) {
        return new ApiResponse(200, message, null);
    }

    public static ApiResponse ok(Object data) {
        return new ApiResponse(200, "成功", data);
    }

    public static ApiResponse ok(String message, Object data) {
        return new ApiResponse(200, message, data);
    }

    public static ApiResponse fail() {
        return new ApiResponse(400, "失败", null);
    }

    public static ApiResponse fail(String message) {
        return new ApiResponse(400, message, null);
    }

    public ApiResponse(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
