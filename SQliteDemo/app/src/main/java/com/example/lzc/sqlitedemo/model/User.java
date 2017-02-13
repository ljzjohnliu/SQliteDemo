package com.example.lzc.sqlitedemo.model;

/**
 * 类描述：
 * 创建人：zz
 * 创建时间： 2016/12/16 13:14
 */


public class User {
    private String id;
    private String userName;
    private String passWord;

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
