/**
 * XxdjWebServiceSoap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.api.apiservice.gyyn;

import org.springframework.stereotype.Component;

public interface XxdjWebServiceSoap_PortType extends java.rmi.Remote {
    public String getTempCode(String id, String paswd) throws java.rmi.RemoteException;
    public String selected(String id, String paswd, String port, String begindata, String enddata, String code) throws java.rmi.RemoteException;
    public String selected_yf(String id, String paswd, String port, String begindata, String enddata, String code) throws java.rmi.RemoteException;
    public String selected_kh(String id, String paswd, String port, String begindata, String enddata, String code) throws java.rmi.RemoteException;
    public String selected_dc(String id, String paswd, String port, String begindata, String enddata, String code) throws java.rmi.RemoteException;
    public String updatepassword(String id, String oldpaswd, String newpaswd) throws java.rmi.RemoteException;
}
