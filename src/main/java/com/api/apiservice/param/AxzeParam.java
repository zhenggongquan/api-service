package com.api.apiservice.param;


public class AxzeParam extends OperationParam {

    private String startdate;
    private String keyword;

    public AxzeParam(String startdate, String keyword,int pageSize,int currentPage,
                     String orgCode, String operate, String rsaKey) {
        super(orgCode, operate, rsaKey,pageSize,currentPage);
        this.startdate = startdate;
        this.keyword = keyword;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
