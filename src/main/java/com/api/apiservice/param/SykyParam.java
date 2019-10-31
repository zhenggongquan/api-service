package com.api.apiservice.param;

public class SykyParam extends Page {

    private  String userID ;
    private  String userPwd ;
    private  String beginDate ;
    private  String endDate ;

    public SykyParam(String userID, String userPwd, String beginDate, String endDate) {
        this.userID = userID;
        this.userPwd = userPwd;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
