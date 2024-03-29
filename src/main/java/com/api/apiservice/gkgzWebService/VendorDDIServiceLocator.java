/**
 * VendorDDIServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.api.apiservice.gkgzWebService;

public class VendorDDIServiceLocator extends org.apache.axis.client.Service implements VendorDDIService {

    public VendorDDIServiceLocator() {
    }


    public VendorDDIServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public VendorDDIServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for vendorDDIPort
    private String vendorDDIPort_address = "http://59.41.111.229:9000/vendorService";

    public String getvendorDDIPortAddress() {
        return vendorDDIPort_address;
    }

    // The WSDD service name defaults to the port name.
    private String vendorDDIPortWSDDServiceName = "vendorDDIPort";

    public String getvendorDDIPortWSDDServiceName() {
        return vendorDDIPortWSDDServiceName;
    }

    public void setvendorDDIPortWSDDServiceName(String name) {
        vendorDDIPortWSDDServiceName = name;
    }

    public VendorService getvendorDDIPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(vendorDDIPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getvendorDDIPort(endpoint);
    }

    public VendorService getvendorDDIPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            VendorDDIServiceSoapBindingStub _stub = new VendorDDIServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getvendorDDIPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setvendorDDIPortEndpointAddress(String address) {
        vendorDDIPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (VendorService.class.isAssignableFrom(serviceEndpointInterface)) {
                VendorDDIServiceSoapBindingStub _stub = new VendorDDIServiceSoapBindingStub(new java.net.URL(vendorDDIPort_address), this);
                _stub.setPortName(getvendorDDIPortWSDDServiceName());
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
        if ("vendorDDIPort".equals(inputPortName)) {
            return getvendorDDIPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://vendorDDI.sinopharm_gz.com/", "vendorDDIService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://vendorDDI.sinopharm_gz.com/", "vendorDDIPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {

if ("vendorDDIPort".equals(portName)) {
            setvendorDDIPortEndpointAddress(address);
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
