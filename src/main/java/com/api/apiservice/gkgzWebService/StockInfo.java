/**
 * StockInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.api.apiservice.gkgzWebService;

public class StockInfo  extends SkuDto  implements java.io.Serializable {
    private java.math.BigDecimal stockQty;

    private String validDate;

    private String produceDate;

    private String ownerID;

    private String quaStatus;

    private String stockStatus;

    private String ownerName;

    public StockInfo() {
    }

    public StockInfo(
           String productCode,
           String productName,
           String producer,
           String productSpec,
           String productUnit,
           String productBatch,
           String productClass,
           int packetNum,
           java.math.BigDecimal stockQty,
           String validDate,
           String produceDate,
           String ownerID,
           String quaStatus,
           String stockStatus,
           String ownerName) {
        super(
            productCode,
            productName,
            producer,
            productSpec,
            productUnit,
            productBatch,
            productClass,
            packetNum);
        this.stockQty = stockQty;
        this.validDate = validDate;
        this.produceDate = produceDate;
        this.ownerID = ownerID;
        this.quaStatus = quaStatus;
        this.stockStatus = stockStatus;
        this.ownerName = ownerName;
    }


    /**
     * Gets the stockQty value for this StockInfo.
     *
     * @return stockQty
     */
    public java.math.BigDecimal getStockQty() {
        return stockQty;
    }


    /**
     * Sets the stockQty value for this StockInfo.
     *
     * @param stockQty
     */
    public void setStockQty(java.math.BigDecimal stockQty) {
        this.stockQty = stockQty;
    }


    /**
     * Gets the validDate value for this StockInfo.
     *
     * @return validDate
     */
    public String getValidDate() {
        return validDate;
    }


    /**
     * Sets the validDate value for this StockInfo.
     *
     * @param validDate
     */
    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }


    /**
     * Gets the produceDate value for this StockInfo.
     *
     * @return produceDate
     */
    public String getProduceDate() {
        return produceDate;
    }


    /**
     * Sets the produceDate value for this StockInfo.
     *
     * @param produceDate
     */
    public void setProduceDate(String produceDate) {
        this.produceDate = produceDate;
    }


    /**
     * Gets the ownerID value for this StockInfo.
     *
     * @return ownerID
     */
    public String getOwnerID() {
        return ownerID;
    }


    /**
     * Sets the ownerID value for this StockInfo.
     *
     * @param ownerID
     */
    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }


    /**
     * Gets the quaStatus value for this StockInfo.
     *
     * @return quaStatus
     */
    public String getQuaStatus() {
        return quaStatus;
    }


    /**
     * Sets the quaStatus value for this StockInfo.
     *
     * @param quaStatus
     */
    public void setQuaStatus(String quaStatus) {
        this.quaStatus = quaStatus;
    }


    /**
     * Gets the stockStatus value for this StockInfo.
     *
     * @return stockStatus
     */
    public String getStockStatus() {
        return stockStatus;
    }


    /**
     * Sets the stockStatus value for this StockInfo.
     *
     * @param stockStatus
     */
    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }


    /**
     * Gets the ownerName value for this StockInfo.
     *
     * @return ownerName
     */
    public String getOwnerName() {
        return ownerName;
    }


    /**
     * Sets the ownerName value for this StockInfo.
     *
     * @param ownerName
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof StockInfo)) return false;
        StockInfo other = (StockInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) &&
            ((this.stockQty==null && other.getStockQty()==null) ||
             (this.stockQty!=null &&
              this.stockQty.equals(other.getStockQty()))) &&
            ((this.validDate==null && other.getValidDate()==null) ||
             (this.validDate!=null &&
              this.validDate.equals(other.getValidDate()))) &&
            ((this.produceDate==null && other.getProduceDate()==null) ||
             (this.produceDate!=null &&
              this.produceDate.equals(other.getProduceDate()))) &&
            ((this.ownerID==null && other.getOwnerID()==null) ||
             (this.ownerID!=null &&
              this.ownerID.equals(other.getOwnerID()))) &&
            ((this.quaStatus==null && other.getQuaStatus()==null) ||
             (this.quaStatus!=null &&
              this.quaStatus.equals(other.getQuaStatus()))) &&
            ((this.stockStatus==null && other.getStockStatus()==null) ||
             (this.stockStatus!=null &&
              this.stockStatus.equals(other.getStockStatus()))) &&
            ((this.ownerName==null && other.getOwnerName()==null) ||
             (this.ownerName!=null &&
              this.ownerName.equals(other.getOwnerName())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getStockQty() != null) {
            _hashCode += getStockQty().hashCode();
        }
        if (getValidDate() != null) {
            _hashCode += getValidDate().hashCode();
        }
        if (getProduceDate() != null) {
            _hashCode += getProduceDate().hashCode();
        }
        if (getOwnerID() != null) {
            _hashCode += getOwnerID().hashCode();
        }
        if (getQuaStatus() != null) {
            _hashCode += getQuaStatus().hashCode();
        }
        if (getStockStatus() != null) {
            _hashCode += getStockStatus().hashCode();
        }
        if (getOwnerName() != null) {
            _hashCode += getOwnerName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(StockInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://vendorDDI.sinopharm_gz.com/", "StockInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stockQty");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stockQty"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "validDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("produceDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "produceDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ownerID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quaStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "quaStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stockStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stockStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ownerName"));
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
