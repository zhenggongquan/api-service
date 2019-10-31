/**
 * SupplyInfoService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.api.apiservice.axze;

public interface SupplyInfoService extends javax.xml.rpc.Service {
    public String getQueryServicePortAddress();

    public com.api.apiservice.axze.QueryService getQueryServicePort() throws javax.xml.rpc.ServiceException;

    public com.api.apiservice.axze.QueryService getQueryServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
