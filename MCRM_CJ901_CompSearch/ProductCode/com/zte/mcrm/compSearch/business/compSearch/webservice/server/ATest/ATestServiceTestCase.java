/**
 * ATestServiceTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Dec 04, 2006 (10:38:30 GMT+08:00) WSDL2Java emitter.
 */

package com.zte.mcrm.compSearch.business.compSearch.webservice.server.ATest;

public class ATestServiceTestCase extends junit.framework.TestCase {
    public ATestServiceTestCase(java.lang.String name) {
        super(name);
    }

    public void testATestWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new com.zte.mcrm.compSearch.business.compSearch.webservice.server.ATest.ATestServiceLocator().getATestAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new com.zte.mcrm.compSearch.business.compSearch.webservice.server.ATest.ATestServiceLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1ATestSayHello() throws Exception {
        com.zte.mcrm.compSearch.business.compSearch.webservice.server.ATest.ATestSoapBindingStub binding;
        try {
            binding = (com.zte.mcrm.compSearch.business.compSearch.webservice.server.ATest.ATestSoapBindingStub)
                          new com.zte.mcrm.compSearch.business.compSearch.webservice.server.ATest.ATestServiceLocator().getATest();
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
        java.lang.String value = null;
        value = binding.sayHello(new java.lang.String());
        // TBD - validate results
    }

}
