/**
 * WebDDIService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.api.apiservice.gkah;

public interface WebDDIService extends javax.xml.rpc.Service {
    public String getWebDDIServiceSoap12Address();

    public  com.api.apiservice.gkah.WebDDIServiceSoap_PortType getWebDDIServiceSoap12() throws javax.xml.rpc.ServiceException;

    public com.api.apiservice.gkah.WebDDIServiceSoap_PortType getWebDDIServiceSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public String getWebDDIServiceSoapAddress();

    public com.api.apiservice.gkah.WebDDIServiceSoap_PortType getWebDDIServiceSoap() throws javax.xml.rpc.ServiceException;

    public com.api.apiservice.gkah.WebDDIServiceSoap_PortType getWebDDIServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
