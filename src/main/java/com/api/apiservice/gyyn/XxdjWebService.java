/**
 * XxdjWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.api.apiservice.gyyn;

public interface XxdjWebService extends javax.xml.rpc.Service {
    public String getXxdjWebServiceSoap12Address();

    public com.api.apiservice.gyyn.XxdjWebServiceSoap_PortType getXxdjWebServiceSoap12() throws javax.xml.rpc.ServiceException;

    public com.api.apiservice.gyyn.XxdjWebServiceSoap_PortType getXxdjWebServiceSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public String getXxdjWebServiceSoapAddress();

    public com.api.apiservice.gyyn.XxdjWebServiceSoap_PortType getXxdjWebServiceSoap() throws javax.xml.rpc.ServiceException;

    public com.api.apiservice.gyyn.XxdjWebServiceSoap_PortType getXxdjWebServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
