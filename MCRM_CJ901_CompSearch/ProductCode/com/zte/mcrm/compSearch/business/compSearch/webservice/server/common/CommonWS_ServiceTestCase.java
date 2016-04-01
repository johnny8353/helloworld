/**
 * CommonWS_ServiceTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Dec 04, 2006 (10:38:30 GMT+08:00) WSDL2Java emitter.
 */

package com.zte.mcrm.compSearch.business.compSearch.webservice.server.common;

public class CommonWS_ServiceTestCase extends junit.framework.TestCase {
    public CommonWS_ServiceTestCase(java.lang.String name) {
        super(name);
    }

    public void testcommonWSWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new com.zte.mcrm.compSearch.business.compSearch.webservice.server.common.CommonWS_ServiceLocator().getcommonWSAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new com.zte.mcrm.compSearch.business.compSearch.webservice.server.common.CommonWS_ServiceLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1commonWSWSService() throws Exception {
        com.zte.mcrm.compSearch.business.compSearch.webservice.server.common.CommonWSSoapBindingStub binding;
        try {
            binding = (com.zte.mcrm.compSearch.business.compSearch.webservice.server.common.CommonWSSoapBindingStub)
                          new com.zte.mcrm.compSearch.business.compSearch.webservice.server.common.CommonWS_ServiceLocator().getcommonWS();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        com.zte.mcrm.compSearch.business.compSearch.webservice.server.common.WSServiceResponse value = null;
        value = binding.WSService(new com.zte.mcrm.compSearch.business.compSearch.webservice.server.common.WSServiceRequest());
        // TBD - validate results
    }

}
