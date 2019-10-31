/**
 * WebDDIServiceSoap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.api.apiservice.gkah;

public interface WebDDIServiceSoap_PortType extends java.rmi.Remote {

    /**
     * 数据直连-采购数据
     */
    public String webDDI_GetPurBill(String context) throws java.rmi.RemoteException;

    /**
     * 数据直连-销售数据
     */
    public String webDDI_GetSalBill(String context) throws java.rmi.RemoteException;

    /**
     * 数据直连-库存数据
     */
    public String webDDI_GetInv(String context) throws java.rmi.RemoteException;

    /**
     * 数据直连-授权令牌信息
     */
    public String webDDI_GetTokenInfo(String context) throws java.rmi.RemoteException;
}
