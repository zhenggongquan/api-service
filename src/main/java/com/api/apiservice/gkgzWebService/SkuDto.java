/**
 * SkuDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.api.apiservice.gkgzWebService;

public class SkuDto  implements java.io.Serializable {
    private String productCode;

    private String productName;

    private String producer;

    private String productSpec;

    private String productUnit;

    private String productBatch;

    private String productClass;

    private int packetNum;

    public SkuDto() {
    }

    public SkuDto(
           String productCode,
           String productName,
           String producer,
           String productSpec,
           String productUnit,
           String productBatch,
           String productClass,
           int packetNum) {
           this.productCode = productCode;
           this.productName = productName;
           this.producer = producer;
           this.productSpec = productSpec;
           this.productUnit = productUnit;
           this.productBatch = productBatch;
           this.productClass = productClass;
           this.packetNum = packetNum;
    }


    /**
     * Gets the productCode value for this SkuDto.
     *
     * @return productCode
     */
    public String getProductCode() {
        return productCode;
    }


    /**
     * Sets the productCode value for this SkuDto.
     *
     * @param productCode
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }


    /**
     * Gets the productName value for this SkuDto.
     *
     * @return productName
     */
    public String getProductName() {
        return productName;
    }


    /**
     * Sets the productName value for this SkuDto.
     *
     * @param productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }


    /**
     * Gets the producer value for this SkuDto.
     *
     * @return producer
     */
    public String getProducer() {
        return producer;
    }


    /**
     * Sets the producer value for this SkuDto.
     *
     * @param producer
     */
    public void setProducer(String producer) {
        this.producer = producer;
    }


    /**
     * Gets the productSpec value for this SkuDto.
     *
     * @return productSpec
     */
    public String getProductSpec() {
        return productSpec;
    }


    /**
     * Sets the productSpec value for this SkuDto.
     *
     * @param productSpec
     */
    public void setProductSpec(String productSpec) {
        this.productSpec = productSpec;
    }


    /**
     * Gets the productUnit value for this SkuDto.
     *
     * @return productUnit
     */
    public String getProductUnit() {
        return productUnit;
    }


    /**
     * Sets the productUnit value for this SkuDto.
     *
     * @param productUnit
     */
    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }


    /**
     * Gets the productBatch value for this SkuDto.
     *
     * @return productBatch
     */
    public String getProductBatch() {
        return productBatch;
    }


    /**
     * Sets the productBatch value for this SkuDto.
     *
     * @param productBatch
     */
    public void setProductBatch(String productBatch) {
        this.productBatch = productBatch;
    }


    /**
     * Gets the productClass value for this SkuDto.
     *
     * @return productClass
     */
    public String getProductClass() {
        return productClass;
    }


    /**
     * Sets the productClass value for this SkuDto.
     *
     * @param productClass
     */
    public void setProductClass(String productClass) {
        this.productClass = productClass;
    }


    /**
     * Gets the packetNum value for this SkuDto.
     *
     * @return packetNum
     */
    public int getPacketNum() {
        return packetNum;
    }


    /**
     * Sets the packetNum value for this SkuDto.
     *
     * @param packetNum
     */
    public void setPacketNum(int packetNum) {
        this.packetNum = packetNum;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof SkuDto)) return false;
        SkuDto other = (SkuDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.productCode==null && other.getProductCode()==null) ||
             (this.productCode!=null &&
              this.productCode.equals(other.getProductCode()))) &&
            ((this.productName==null && other.getProductName()==null) ||
             (this.productName!=null &&
              this.productName.equals(other.getProductName()))) &&
            ((this.producer==null && other.getProducer()==null) ||
             (this.producer!=null &&
              this.producer.equals(other.getProducer()))) &&
            ((this.productSpec==null && other.getProductSpec()==null) ||
             (this.productSpec!=null &&
              this.productSpec.equals(other.getProductSpec()))) &&
            ((this.productUnit==null && other.getProductUnit()==null) ||
             (this.productUnit!=null &&
              this.productUnit.equals(other.getProductUnit()))) &&
            ((this.productBatch==null && other.getProductBatch()==null) ||
             (this.productBatch!=null &&
              this.productBatch.equals(other.getProductBatch()))) &&
            ((this.productClass==null && other.getProductClass()==null) ||
             (this.productClass!=null &&
              this.productClass.equals(other.getProductClass()))) &&
            this.packetNum == other.getPacketNum();
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
        if (getProductCode() != null) {
            _hashCode += getProductCode().hashCode();
        }
        if (getProductName() != null) {
            _hashCode += getProductName().hashCode();
        }
        if (getProducer() != null) {
            _hashCode += getProducer().hashCode();
        }
        if (getProductSpec() != null) {
            _hashCode += getProductSpec().hashCode();
        }
        if (getProductUnit() != null) {
            _hashCode += getProductUnit().hashCode();
        }
        if (getProductBatch() != null) {
            _hashCode += getProductBatch().hashCode();
        }
        if (getProductClass() != null) {
            _hashCode += getProductClass().hashCode();
        }
        _hashCode += getPacketNum();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SkuDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://vendorDDI.sinopharm_gz.com/", "SkuDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productSpec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productSpec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productUnit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productUnit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productBatch");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productBatch"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productClass");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productClass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("packetNum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "packetNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
