package com.api.apiservice.param;

import com.api.apiservice.util.MD5Util;

public class OperationParam extends Page {

    private  String orgCode;
    private  String operate;
    private  String rsaKey;
    private  String sign;

    public OperationParam(String orgCode, String operate, String rsaKey,int pageSize,int currentPage) {
        super(pageSize,currentPage);
        this.orgCode = orgCode;
        this.operate = operate;
        this.rsaKey = rsaKey;
        this.formatSign();

    }
    private void formatSign(){
       this.sign = MD5Util.md5(orgCode + rsaKey);
        System.out.println("sign:"+sign);
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public String getRsaKey() {
        return rsaKey;
    }

    public void setRsaKey(String rsaKey) {
        this.rsaKey = rsaKey;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
