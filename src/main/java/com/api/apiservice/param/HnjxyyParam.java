package com.api.apiservice.param;

public class HnjxyyParam extends Page {

    private String username ;
    private String password  ;
    private String output = "json";
    private String owner  ;
    private String startDate ;
    private String endDate  ;
    private String accessToken  ;

    public HnjxyyParam() {
    }

    public HnjxyyParam(String username, String password) {
        this.owner = username;
        this.password = password;
    }



    public HnjxyyParam(int pageSize, int currentPage,String username, String password) {
        super(pageSize, currentPage);
        this.owner = username;
        this.password = password;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
