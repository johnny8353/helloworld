/**
 * WSServiceResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Dec 04, 2006 (10:38:30 GMT+08:00) WSDL2Java emitter.
 */

package com.zte.mcrm.compSearch.business.compSearch.webservice.server.common;

public class WSServiceResponse  implements java.io.Serializable {
    private java.lang.String returnStr;

    public WSServiceResponse() {
    }

    public WSServiceResponse(
           java.lang.String returnStr) {
           this.returnStr = returnStr;
    }


    /**
     * Gets the returnStr value for this WSServiceResponse.
     * 
     * @return returnStr
     */
    public java.lang.String getReturnStr() {
        return returnStr;
    }


    /**
     * Sets the returnStr value for this WSServiceResponse.
     * 
     * @param returnStr
     */
    public void setReturnStr(java.lang.String returnStr) {
        this.returnStr = returnStr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WSServiceResponse)) return false;
        WSServiceResponse other = (WSServiceResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.returnStr==null && other.getReturnStr()==null) || 
             (this.returnStr!=null &&
              this.returnStr.equals(other.getReturnStr())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getReturnStr() != null) {
            _hashCode += getReturnStr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WSServiceResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://com.zte.siebel/commonWS", ">WSServiceResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnStr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://com.zte.siebel/commonWS", "returnStr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
