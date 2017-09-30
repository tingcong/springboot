package com.springboot.common.entity.enums;

/**
 * Created by htc on 2017/9/30.
 */
public enum  Authority {

    //利用构造函数传参
    VISITOR("visitor"),
    ORDINARY("ordinary"),
    MEMBERSHIP("membership");

    //定义私有变量
    private String authority;

    //构造函数
    private Authority(String authority){
        this.authority=authority;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return String.valueOf(this.authority);
    }
}
