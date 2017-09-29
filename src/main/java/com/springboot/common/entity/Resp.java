package com.springboot.common.entity;

import java.io.Serializable;

/**
 * Created by htc on 2017/9/28.
 */
public class Resp implements Serializable {
    private static final long serialVersionUID = 8243346218148512277L;
    private int status;
    private Object data;
    private String msg;

    public Resp() {
    }

    public Resp(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Resp(int status, Object data) {
        this.status = status;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
