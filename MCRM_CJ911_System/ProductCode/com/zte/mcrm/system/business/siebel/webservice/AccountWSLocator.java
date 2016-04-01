/**
 * AccountWSLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Dec 04, 2006 (10:38:30 GMT+08:00) WSDL2Java emitter.
 */

package com.zte.mcrm.system.business.siebel.webservice;

import com.zte.mcrm.framework.common.util.Env;

public class AccountWSLocator extends org.apache.axis.client.Service implements com.zte.mcrm.system.business.siebel.webservice.AccountWS {

    public AccountWSLocator() {
    }


    public AccountWSLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AccountWSLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AccountWSPort
    private java.lang.String AccountWSPort_address;

    public java.lang.String getAccountWSPortAddress() {
        return AccountWSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AccountWSPortWSDDServiceName = "AccountWSPort";

    public java.lang.String getAccountWSPortWSDDServiceName() {
        return AccountWSPortWSDDServiceName;
    }

    public void setAccountWSPortWSDDServiceName(java.lang.String name) {
        AccountWSPortWSDDServiceName = name;
    }

    public com.zte.mcrm.system.business.siebel.webservice.AccountWSPort_PortType getAccountWSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AccountWSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAccountWSPort(endpoint);
    }

    public com.zte.mcrm.system.business.siebel.webservice.AccountWSPort_PortType getAccountWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.zte.mcrm.system.business.siebel.webservice.AccountWSPort_BindingStub _stub = new com.zte.mcrm.system.business.siebel.webservice.AccountWSPort_BindingStub(portAddress, this);
            _stub.setPortName(getAccountWSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAccountWSPortEndpointAddress(java.lang.String address) {
        AccountWSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.zte.mcrm.system.business.siebel.webservice.AccountWSPort_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.zte.mcrm.system.business.siebel.webservice.AccountWSPort_BindingStub _stub = new com.zte.mcrm.system.business.siebel.webservice.AccountWSPort_BindingStub(new java.net.URL(AccountWSPort_address), this);
                _stub.setPortName(getAccountWSPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
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
        java.lang.String inputPortName = portName.getLocalPart();
        if ("AccountWSPort".equals(inputPortName)) {
            return getAccountWSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://siebel.com/asi/", "AccountWS");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://siebel.com/asi/", "AccountWSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AccountWSPort".equals(portName)) {
            setAccountWSPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
