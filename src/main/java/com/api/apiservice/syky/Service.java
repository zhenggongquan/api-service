/**
 * Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.api.apiservice.syky;

public interface Service extends javax.xml.rpc.Service {
    public String getServiceSoapAddress();

    public com.api.apiservice.syky.ServiceSoap getServiceSoap() throws javax.xml.rpc.ServiceException;

    public com.api.apiservice.syky.ServiceSoap getServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
