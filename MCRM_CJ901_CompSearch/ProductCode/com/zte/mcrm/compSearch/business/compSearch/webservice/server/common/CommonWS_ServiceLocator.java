/**
 * CommonWS_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Dec 04, 2006 (10:38:30 GMT+08:00) WSDL2Java emitter.
 */

package com.zte.mcrm.compSearch.business.compSearch.webservice.server.common;

public class CommonWS_ServiceLocator extends org.apache.axis.client.Service implements com.zte.mcrm.compSearch.business.compSearch.webservice.server.common.CommonWS_Service {

    public CommonWS_ServiceLocator() {
    }


    public CommonWS_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CommonWS_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for commonWS
    private java.lang.String commonWS_address = "http://10.5.6.196:8088/siebel/services/commonWS";

    public java.lang.String getcommonWSAddress() {
        return commonWS_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String commonWSWSDDServiceName = "commonWS";

    public java.lang.String getcommonWSWSDDServiceName() {
        return commonWSWSDDServiceName;
    }

    public void setcommonWSWSDDServiceName(java.lang.String name) {
        commonWSWSDDServiceName = name;
    }

    public com.zte.mcrm.compSearch.business.compSearch.webservice.server.common.CommonWS_PortType getcommonWS() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(commonWS_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getcommonWS(endpoint);
    }

    public com.zte.mcrm.compSearch.business.compSearch.webservice.server.common.CommonWS_PortType getcommonWS(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.zte.mcrm.compSearch.business.compSearch.webservice.server.common.CommonWSSoapBindingStub _stub = new com.zte.mcrm.compSearch.business.compSearch.webservice.server.common.CommonWSSoapBindingStub(portAddress, this);
            _stub.setPortName(getcommonWSWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setcommonWSEndpointAddress(java.lang.String address) {
        commonWS_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.zte.mcrm.compSearch.business.compSearch.webservice.server.common.CommonWS_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.zte.mcrm.compSearch.business.compSearch.webservice.server.common.CommonWSSoapBindingStub _stub = new com.zte.mcrm.compSearch.business.compSearch.webservice.server.common.CommonWSSoapBindingStub(new java.net.URL(commonWS_address), this);
                _stub.setPortName(getcommonWSWSDDServiceName());
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
        if ("commonWS".equals(inputPortName)) {
            return getcommonWS();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://com.zte.siebel/commonWS", "commonWS");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://com.zte.siebel/commonWS", "commonWS"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("commonWS".equals(portName)) {
            setcommonWSEndpointAddress(address);
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
