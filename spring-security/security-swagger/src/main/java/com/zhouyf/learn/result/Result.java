package com.zhouyf.learn.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Zhouyf
 * @Data 2020-07-28  15:25
 */
@Data
public class Result implements Serializable {

    private Object data;

    private String msg;

    private String code;

    public Result(Object data){
        this.data = data;
        this.msg = "操作成功";
        this.code = "SUCCESS";
    }
    public Result(String msg, String code){
        this.data = null;
        this.msg = msg;
        this.code = code == null ? "ERROR" : code;
    }

}
