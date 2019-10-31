/**
 * XxdjWebServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.api.apiservice.gyyn;

public class XxdjWebServiceLocator extends org.apache.axis.client.Service implements com.api.apiservice.gyyn.XxdjWebService {

    public XxdjWebServiceLocator() {
    }


    public XxdjWebServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public XxdjWebServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for XxdjWebServiceSoap12
    private String XxdjWebServiceSoap12_address = "http://112.112.9.205:6666/XxdjWebService.asmx";

    public String getXxdjWebServiceSoap12Address() {
        return XxdjWebServiceSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private String XxdjWebServiceSoap12WSDDServiceName = "XxdjWebServiceSoap12";

    public String getXxdjWebServiceSoap12WSDDServiceName() {
        return XxdjWebServiceSoap12WSDDServiceName;
    }

    public void setXxdjWebServiceSoap12WSDDServiceName(String name) {
        XxdjWebServiceSoap12WSDDServiceName = name;
    }

    public com.api.apiservice.gyyn.XxdjWebServiceSoap_PortType getXxdjWebServiceSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(XxdjWebServiceSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getXxdjWebServiceSoap12(endpoint);
    }

    public com.api.apiservice.gyyn.XxdjWebServiceSoap_PortType getXxdjWebServiceSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.api.apiservice.gyyn.XxdjWebServiceSoap12Stub _stub = new com.api.apiservice.gyyn.XxdjWebServiceSoap12Stub(portAddress, this);
            _stub.setPortName(getXxdjWebServiceSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setXxdjWebServiceSoap12EndpointAddress(String address) {
        XxdjWebServiceSoap12_address = address;
    }


    // Use to get a proxy class for XxdjWebServiceSoap
    private String XxdjWebServiceSoap_address = "http://112.112.9.205:6666/XxdjWebService.asmx";

    public String getXxdjWebServiceSoapAddress() {
        return XxdjWebServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private String XxdjWebServiceSoapWSDDServiceName = "XxdjWebServiceSoap";

    public String getXxdjWebServiceSoapWSDDServiceName() {
        return XxdjWebServiceSoapWSDDServiceName;
    }

    public void setXxdjWebServiceSoapWSDDServiceName(String name) {
        XxdjWebServiceSoapWSDDServiceName = name;
    }

    public com.api.apiservice.gyyn.XxdjWebServiceSoap_PortType getXxdjWebServiceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(XxdjWebServiceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getXxdjWebServiceSoap(endpoint);
    }

    public com.api.apiservice.gyyn.XxdjWebServiceSoap_PortType getXxdjWebServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.api.apiservice.gyyn.XxdjWebServiceSoap_BindingStub _stub = new com.api.apiservice.gyyn.XxdjWebServiceSoap_BindingStub(portAddress, this);
            _stub.setPortName(getXxdjWebServiceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setXxdjWebServiceSoapEndpointAddress(String address) {
        XxdjWebServiceSoap_address = address;
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
            if (com.api.apiservice.gyyn.XxdjWebServiceSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.api.apiservice.gyyn.XxdjWebServiceSoap12Stub _stub = new com.api.apiservice.gyyn.XxdjWebServiceSoap12Stub(new java.net.URL(XxdjWebServiceSoap12_address), this);
                _stub.setPortName(getXxdjWebServiceSoap12WSDDServiceName());
                return _stub;
            }
            if (com.api.apiservice.gyyn.XxdjWebServiceSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.api.apiservice.gyyn.XxdjWebServiceSoap_BindingStub _stub = new com.api.apiservice.gyyn.XxdjWebServiceSoap_BindingStub(new java.net.URL(XxdjWebServiceSoap_address), this);
                _stub.setPortName(getXxdjWebServiceSoapWSDDServiceName());
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
        if ("XxdjWebServiceSoap12".equals(inputPortName)) {
            return getXxdjWebServiceSoap12();
        }
        else if ("XxdjWebServiceSoap".equals(inputPortName)) {
            return getXxdjWebServiceSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "XxdjWebService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "XxdjWebServiceSoap12"));
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "XxdjWebServiceSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {

if ("XxdjWebServiceSoap12".equals(portName)) {
            setXxdjWebServiceSoap12EndpointAddress(address);
        }
        else
if ("XxdjWebServiceSoap".equals(portName)) {
            setXxdjWebServiceSoapEndpointAddress(address);
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
