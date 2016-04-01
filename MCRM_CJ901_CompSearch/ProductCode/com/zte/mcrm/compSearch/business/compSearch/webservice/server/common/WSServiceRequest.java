/**
 * WSServiceRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Dec 04, 2006 (10:38:30 GMT+08:00) WSDL2Java emitter.
 */

package com.zte.mcrm.compSearch.business.compSearch.webservice.server.common;

public class WSServiceRequest  implements java.io.Serializable {
    private java.lang.String jsonStr;

    public WSServiceRequest() {
    }

    public WSServiceRequest(
           java.lang.String jsonStr) {
           this.jsonStr = jsonStr;
    }


    /**
     * Gets the jsonStr value for this WSServiceRequest.
     * 
     * @return jsonStr
     */
    public java.lang.String getJsonStr() {
        return jsonStr;
    }


    /**
     * Sets the jsonStr value for this WSServiceRequest.
     * 
     * @param jsonStr
     */
    public void setJsonStr(java.lang.String jsonStr) {
        this.jsonStr = jsonStr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WSServiceRequest)) return false;
        WSServiceRequest other = (WSServiceRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.jsonStr==null && other.getJsonStr()==null) || 
             (this.jsonStr!=null &&
              this.jsonStr.equals(other.getJsonStr())));
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
        if (getJsonStr() != null) {
            _hashCode += getJsonStr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WSServiceRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://com.zte.siebel/commonWS", ">WSServiceRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jsonStr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://com.zte.siebel/commonWS", "jsonStr"));
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
