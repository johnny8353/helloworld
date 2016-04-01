/**
 * AccountWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Dec 04, 2006 (10:38:30 GMT+08:00) WSDL2Java emitter.
 */

package com.zte.mcrm.system.business.siebel.webservice;

public interface AccountWS extends javax.xml.rpc.Service {
    public java.lang.String getAccountWSPortAddress();

    public com.zte.mcrm.system.business.siebel.webservice.AccountWSPort_PortType getAccountWSPort() throws javax.xml.rpc.ServiceException;

    public com.zte.mcrm.system.business.siebel.webservice.AccountWSPort_PortType getAccountWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
