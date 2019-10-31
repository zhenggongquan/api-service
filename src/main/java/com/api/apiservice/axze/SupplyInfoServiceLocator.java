/**
 * SupplyInfoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.api.apiservice.axze;

public class SupplyInfoServiceLocator extends org.apache.axis.client.Service implements com.api.apiservice.axze.SupplyInfoService {

    public SupplyInfoServiceLocator() {
    }


    public SupplyInfoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SupplyInfoServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for QueryServicePort
    private String QueryServicePort_address = "http://222.175.123.206:9980/QueryService";

    public String getQueryServicePortAddress() {
        return QueryServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private String QueryServicePortWSDDServiceName = "QueryServicePort";

    public String getQueryServicePortWSDDServiceName() {
        return QueryServicePortWSDDServiceName;
    }

    public void setQueryServicePortWSDDServiceName(String name) {
        QueryServicePortWSDDServiceName = name;
    }

    public com.api.apiservice.axze.QueryService getQueryServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(QueryServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getQueryServicePort(endpoint);
    }

    public com.api.apiservice.axze.QueryService getQueryServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.api.apiservice.axze.SupplyInfoServiceSoapBindingStub _stub = new com.api.apiservice.axze.SupplyInfoServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getQueryServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setQueryServicePortEndpointAddress(String address) {
        QueryServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.api.apiservice.axze.QueryService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.api.apiservice.axze.SupplyInfoServiceSoapBindingStub _stub = new com.api.apiservice.axze.SupplyInfoServiceSoapBindingStub(new java.net.URL(QueryServicePort_address), this);
                _stub.setPortName(getQueryServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("QueryServicePort".equals(inputPortName)) {
            return getQueryServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ysk360.com/", "SupplyInfoService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ysk360.com/", "QueryServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("QueryServicePort".equals(portName)) {
            setQueryServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
