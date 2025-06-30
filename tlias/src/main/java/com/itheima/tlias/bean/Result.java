package com.itheima.tlias.bean;

import lombok.Data;

@Data
public class Result {
    private Object data;
    private Integer code;
    private String msg;

    public static Result success(Object object) {
        Result result = new Result();
        result.data = object;
        result.code = 1;
        result.msg = "success";
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.code = 0;
        result.msg = msg;
        return result;
    }
}