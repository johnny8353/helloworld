/**
 * AccountWSTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Dec 04, 2006 (10:38:30 GMT+08:00) WSDL2Java emitter.
 */

package com.zte.mcrm.system.business.siebel.webservice;

public class AccountWSTestCase extends junit.framework.TestCase {
    public AccountWSTestCase(java.lang.String name) {
        super(name);
    }

    public void testAccountWSPortWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new com.zte.mcrm.system.business.siebel.webservice.AccountWSLocator().getAccountWSPortAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new com.zte.mcrm.system.business.siebel.webservice.AccountWSLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1AccountWSPortAccountQueryPageMSO() throws Exception {
        com.zte.mcrm.system.business.siebel.webservice.AccountWSPort_BindingStub binding;
        try {
            binding = (com.zte.mcrm.system.business.siebel.webservice.AccountWSPort_BindingStub)
                          new com.zte.mcrm.system.business.siebel.webservice.AccountWSLocator().getAccountWSPort();
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
        com.zte.mcrm.system.business.siebel.webservice.AccountQueryPageMSO_Output value = null;
        value = binding.accountQueryPageMSO(new com.zte.mcrm.system.business.siebel.webservice.AccountQueryPageMSO_Input());
        // TBD - validate results
    }

}
