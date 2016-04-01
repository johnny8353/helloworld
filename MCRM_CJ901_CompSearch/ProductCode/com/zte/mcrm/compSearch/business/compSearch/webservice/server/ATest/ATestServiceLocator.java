/**
 * ATestServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Dec 04, 2006 (10:38:30 GMT+08:00) WSDL2Java emitter.
 */

package com.zte.mcrm.compSearch.business.compSearch.webservice.server.ATest;

public class ATestServiceLocator extends org.apache.axis.client.Service implements com.zte.mcrm.compSearch.business.compSearch.webservice.server.ATest.ATestService {

    public ATestServiceLocator() {
    }


    public ATestServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ATestServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ATest
    private java.lang.String ATest_address = "http://10.5.6.196:8088/siebel/services/ATest";

    public java.lang.String getATestAddress() {
        return ATest_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ATestWSDDServiceName = "ATest";

    public java.lang.String getATestWSDDServiceName() {
        return ATestWSDDServiceName;
    }

    public void setATestWSDDServiceName(java.lang.String name) {
        ATestWSDDServiceName = name;
    }

    public com.zte.mcrm.compSearch.business.compSearch.webservice.server.ATest.ATest_PortType getATest() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ATest_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getATest(endpoint);
    }

    public com.zte.mcrm.compSearch.business.compSearch.webservice.server.ATest.ATest_PortType getATest(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.zte.mcrm.compSearch.business.compSearch.webservice.server.ATest.ATestSoapBindingStub _stub = new com.zte.mcrm.compSearch.business.compSearch.webservice.server.ATest.ATestSoapBindingStub(portAddress, this);
            _stub.setPortName(getATestWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setATestEndpointAddress(java.lang.String address) {
        ATest_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.zte.mcrm.compSearch.business.compSearch.webservice.server.ATest.ATest_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.zte.mcrm.compSearch.business.compSearch.webservice.server.ATest.ATestSoapBindingStub _stub = new com.zte.mcrm.compSearch.business.compSearch.webservice.server.ATest.ATestSoapBindingStub(new java.net.URL(ATest_address), this);
                _stub.setPortName(getATestWSDDServiceName());
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
        if ("ATest".equals(inputPortName)) {
            return getATest();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:siebel", "ATestService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:siebel", "ATest"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ATest".equals(portName)) {
            setATestEndpointAddress(address);
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
