package com.actsys.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @desc:
 * @author: Ping
 * @date: 2023/12/12 8:23
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult {
    public static final int SUCCESS = 200 ;
    public static final int ERROR = 400 ;
    public static final int  UNAUTHORIZED = 401 ;
    public static final int  FORBIDDEN = 403 ;
    public static final int  NOT_FOUND = 404 ;
    public static final int  INTERNAL_SERVER_ERROR = 500 ;

    private int code;
    private String msg;
    private Object data;

    public static ResponseResult success(String msg, Object data) {
        return new ResponseResult(SUCCESS, msg, data);
    }
    public static ResponseResult success(String msg) {
        return new ResponseResult(SUCCESS, msg, null);
    }

    public static ResponseResult error(String msg, Object data) {
        return new ResponseResult(ERROR, msg, data);
    }

    public static ResponseResult error(String msg) {
        return new ResponseResult(ERROR, msg, null);
    }

    public static ResponseResult unauthorized(String msg, Object data) {
        return new ResponseResult(UNAUTHORIZED, msg, data);
    }
    public static ResponseResult serverError() {
        return new ResponseResult(INTERNAL_SERVER_ERROR, "服务器异常", null);
    }

    public static ResponseResult unauthorized(String msg) {
        return new ResponseResult(UNAUTHORIZED, msg, null);
    }

    public static ResponseResult forbidden(String msg, Object data) {
        return new ResponseResult(FORBIDDEN, msg, data);
    }

    public static ResponseResult forbidden(String msg) {
        return new ResponseResult(FORBIDDEN, msg, null);
    }
    public static ResponseResult notFound() {
        return new ResponseResult(NOT_FOUND, "404",null);
    }

    public static ResponseResult notFound(String msg, Object data) {
        return new ResponseResult(NOT_FOUND, msg, data);
    }

    public static ResponseResult notFound(String msg) {
        return new ResponseResult(NOT_FOUND, msg, null);
    }


}
