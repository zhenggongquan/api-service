/**
 * ServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.api.apiservice.syky;

public interface ServiceSoap extends java.rmi.Remote {

    /**
     * 获取采购数据，传入4个参数依次分别是，账户ID、账户密码、开始日期、结束日期。日期格式为yyyy-mm-dd,如：2018-06-01
     * 返回值：成功是字符串类型XML，失败是错误信息的字符串
     */
    public String getPurchaseInfo(String userID, String userPwd, String beginDate, String endDate) throws java.rmi.RemoteException;

    /**
     * 获取销售数据，传入4个参数依次分别是，账户ID、账户密码、开始日期、结束日期。注意：开始与结束日期不能大于60天，日期格式为yyyy-mm-dd,如：2018-06-01
     * 返回值，成功是字符串类型XML，失败是错误信息的字符串
     */
    public String getSaleInfo(String userID, String userPwd, String beginDate, String endDate) throws java.rmi.RemoteException;

    /**
     * 获取库存，传入3个参数依次分别是，账户ID、账户密码、库存日期。日期格式为yyyy-mm-dd,如：2018-06-01
     * 返回值，成功是字符串类型XML，失败是错误信息的字符串
     */
    public String getStockInfo(String userID, String userPwd, String nowDate) throws java.rmi.RemoteException;
}
