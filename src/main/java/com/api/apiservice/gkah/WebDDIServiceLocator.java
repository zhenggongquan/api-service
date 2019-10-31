/**
 * WebDDIServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.api.apiservice.gkah;

public class WebDDIServiceLocator extends org.apache.axis.client.Service implements com.api.apiservice.gkah.WebDDIService {

    public WebDDIServiceLocator() {
    }


    public WebDDIServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WebDDIServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WebDDIServiceSoap12
    private String WebDDIServiceSoap12_address = "http://www.gykgah.com:8067/WebDDIService.asmx";

    public String getWebDDIServiceSoap12Address() {
        return WebDDIServiceSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private String WebDDIServiceSoap12WSDDServiceName = "WebDDIServiceSoap12";

    public String getWebDDIServiceSoap12WSDDServiceName() {
        return WebDDIServiceSoap12WSDDServiceName;
    }

    public void setWebDDIServiceSoap12WSDDServiceName(String name) {
        WebDDIServiceSoap12WSDDServiceName = name;
    }

    public com.api.apiservice.gkah.WebDDIServiceSoap_PortType getWebDDIServiceSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WebDDIServiceSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWebDDIServiceSoap12(endpoint);
    }

    public com.api.apiservice.gkah.WebDDIServiceSoap_PortType getWebDDIServiceSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.api.apiservice.gkah.WebDDIServiceSoap12Stub _stub = new com.api.apiservice.gkah.WebDDIServiceSoap12Stub(portAddress, this);
            _stub.setPortName(getWebDDIServiceSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWebDDIServiceSoap12EndpointAddress(String address) {
        WebDDIServiceSoap12_address = address;
    }


    // Use to get a proxy class for WebDDIServiceSoap
    private String WebDDIServiceSoap_address = "http://www.gykgah.com:8067/WebDDIService.asmx";

    public String getWebDDIServiceSoapAddress() {
        return WebDDIServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private String WebDDIServiceSoapWSDDServiceName = "WebDDIServiceSoap";

    public String getWebDDIServiceSoapWSDDServiceName() {
        return WebDDIServiceSoapWSDDServiceName;
    }

    public void setWebDDIServiceSoapWSDDServiceName(String name) {
        WebDDIServiceSoapWSDDServiceName = name;
    }

    public com.api.apiservice.gkah.WebDDIServiceSoap_PortType getWebDDIServiceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WebDDIServiceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWebDDIServiceSoap(endpoint);
    }

    public com.api.apiservice.gkah.WebDDIServiceSoap_PortType getWebDDIServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.api.apiservice.gkah.WebDDIServiceSoap_BindingStub _stub = new com.api.apiservice.gkah.WebDDIServiceSoap_BindingStub(portAddress, this);
            _stub.setPortName(getWebDDIServiceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWebDDIServiceSoapEndpointAddress(String address) {
        WebDDIServiceSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.api.apiservice.gkah.WebDDIServiceSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.api.apiservice.gkah.WebDDIServiceSoap12Stub _stub = new com.api.apiservice.gkah.WebDDIServiceSoap12Stub(new java.net.URL(WebDDIServiceSoap12_address), this);
                _stub.setPortName(getWebDDIServiceSoap12WSDDServiceName());
                return _stub;
            }
            if (com.api.apiservice.gkah.WebDDIServiceSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.api.apiservice.gkah.WebDDIServiceSoap_BindingStub _stub = new com.api.apiservice.gkah.WebDDIServiceSoap_BindingStub(new java.net.URL(WebDDIServiceSoap_address), this);
                _stub.setPortName(getWebDDIServiceSoapWSDDServiceName());
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
        if ("WebDDIServiceSoap12".equals(inputPortName)) {
            return getWebDDIServiceSoap12();
        }
        else if ("WebDDIServiceSoap".equals(inputPortName)) {
            return getWebDDIServiceSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "WebDDIService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "WebDDIServiceSoap12"));
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "WebDDIServiceSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {

if ("WebDDIServiceSoap12".equals(portName)) {
            setWebDDIServiceSoap12EndpointAddress(address);
        }
        else
if ("WebDDIServiceSoap".equals(portName)) {
            setWebDDIServiceSoapEndpointAddress(address);
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
