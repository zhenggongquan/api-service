/**
 * QueryService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.api.apiservice.axze;

public interface QueryService extends java.rmi.Remote {
    public String queryService(String orgCode, String operate, String param, String sign) throws java.rmi.RemoteException;
}
