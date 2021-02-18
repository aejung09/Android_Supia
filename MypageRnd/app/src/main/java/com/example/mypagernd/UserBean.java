package com.example.mypagernd;

public class UserBean {

    String userId;
    String userPw;
    String userName;
    String userAddr;
    String userTel;



//    String userPlatform;


    public UserBean(String userId, String userPw, String userName, String userAddr, String userTel) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userAddr = userAddr;
        this.userTel = userTel;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }
}//--------------------
