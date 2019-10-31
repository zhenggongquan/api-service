/**
 * PurchaseInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.api.apiservice.gkgzWebService;

public class PurchaseInfo  extends SkuDto  implements java.io.Serializable {
    private int id;

    private String produceDate;

    private String validDate;

    private String billNo;

    private String flowName;

    private String createDate;

    private String ownerID;

    private String deptName;

    private String venderCode;

    private String venderName;

    private java.math.BigDecimal excuteQty;

    private java.math.BigDecimal price;

    private java.math.BigDecimal netPrice;

    private java.math.BigDecimal value;

    private java.math.BigDecimal netValue;

    private String stockStatus;

    private String quaStatus;

    private String ownerName;

    public PurchaseInfo() {
    }

    public PurchaseInfo(
           String productCode,
           String productName,
           String producer,
           String productSpec,
           String productUnit,
           String productBatch,
           String productClass,
           int packetNum,
           int id,
           String produceDate,
           String validDate,
           String billNo,
           String flowName,
           String createDate,
           String ownerID,
           String deptName,
           String venderCode,
           String venderName,
           java.math.BigDecimal excuteQty,
           java.math.BigDecimal price,
           java.math.BigDecimal netPrice,
           java.math.BigDecimal value,
           java.math.BigDecimal netValue,
           String stockStatus,
           String quaStatus,
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
        this.id = id;
        this.produceDate = produceDate;
        this.validDate = validDate;
        this.billNo = billNo;
        this.flowName = flowName;
        this.createDate = createDate;
        this.ownerID = ownerID;
        this.deptName = deptName;
        this.venderCode = venderCode;
        this.venderName = venderName;
        this.excuteQty = excuteQty;
        this.price = price;
        this.netPrice = netPrice;
        this.value = value;
        this.netValue = netValue;
        this.stockStatus = stockStatus;
        this.quaStatus = quaStatus;
        this.ownerName = ownerName;
    }


    /**
     * Gets the id value for this PurchaseInfo.
     *
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this PurchaseInfo.
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the produceDate value for this PurchaseInfo.
     *
     * @return produceDate
     */
    public String getProduceDate() {
        return produceDate;
    }


    /**
     * Sets the produceDate value for this PurchaseInfo.
     *
     * @param produceDate
     */
    public void setProduceDate(String produceDate) {
        this.produceDate = produceDate;
    }


    /**
     * Gets the validDate value for this PurchaseInfo.
     *
     * @return validDate
     */
    public String getValidDate() {
        return validDate;
    }


    /**
     * Sets the validDate value for this PurchaseInfo.
     *
     * @param validDate
     */
    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }


    /**
     * Gets the billNo value for this PurchaseInfo.
     *
     * @return billNo
     */
    public String getBillNo() {
        return billNo;
    }


    /**
     * Sets the billNo value for this PurchaseInfo.
     *
     * @param billNo
     */
    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }


    /**
     * Gets the flowName value for this PurchaseInfo.
     *
     * @return flowName
     */
    public String getFlowName() {
        return flowName;
    }


    /**
     * Sets the flowName value for this PurchaseInfo.
     *
     * @param flowName
     */
    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }


    /**
     * Gets the createDate value for this PurchaseInfo.
     *
     * @return createDate
     */
    public String getCreateDate() {
        return createDate;
    }


    /**
     * Sets the createDate value for this PurchaseInfo.
     *
     * @param createDate
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }


    /**
     * Gets the ownerID value for this PurchaseInfo.
     *
     * @return ownerID
     */
    public String getOwnerID() {
        return ownerID;
    }


    /**
     * Sets the ownerID value for this PurchaseInfo.
     *
     * @param ownerID
     */
    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }


    /**
     * Gets the deptName value for this PurchaseInfo.
     *
     * @return deptName
     */
    public String getDeptName() {
        return deptName;
    }


    /**
     * Sets the deptName value for this PurchaseInfo.
     *
     * @param deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }


    /**
     * Gets the venderCode value for this PurchaseInfo.
     *
     * @return venderCode
     */
    public String getVenderCode() {
        return venderCode;
    }


    /**
     * Sets the venderCode value for this PurchaseInfo.
     *
     * @param venderCode
     */
    public void setVenderCode(String venderCode) {
        this.venderCode = venderCode;
    }


    /**
     * Gets the venderName value for this PurchaseInfo.
     *
     * @return venderName
     */
    public String getVenderName() {
        return venderName;
    }


    /**
     * Sets the venderName value for this PurchaseInfo.
     *
     * @param venderName
     */
    public void setVenderName(String venderName) {
        this.venderName = venderName;
    }


    /**
     * Gets the excuteQty value for this PurchaseInfo.
     *
     * @return excuteQty
     */
    public java.math.BigDecimal getExcuteQty() {
        return excuteQty;
    }


    /**
     * Sets the excuteQty value for this PurchaseInfo.
     *
     * @param excuteQty
     */
    public void setExcuteQty(java.math.BigDecimal excuteQty) {
        this.excuteQty = excuteQty;
    }


    /**
     * Gets the price value for this PurchaseInfo.
     *
     * @return price
     */
    public java.math.BigDecimal getPrice() {
        return price;
    }


    /**
     * Sets the price value for this PurchaseInfo.
     *
     * @param price
     */
    public void setPrice(java.math.BigDecimal price) {
        this.price = price;
    }


    /**
     * Gets the netPrice value for this PurchaseInfo.
     *
     * @return netPrice
     */
    public java.math.BigDecimal getNetPrice() {
        return netPrice;
    }


    /**
     * Sets the netPrice value for this PurchaseInfo.
     *
     * @param netPrice
     */
    public void setNetPrice(java.math.BigDecimal netPrice) {
        this.netPrice = netPrice;
    }


    /**
     * Gets the value value for this PurchaseInfo.
     *
     * @return value
     */
    public java.math.BigDecimal getValue() {
        return value;
    }


    /**
     * Sets the value value for this PurchaseInfo.
     *
     * @param value
     */
    public void setValue(java.math.BigDecimal value) {
        this.value = value;
    }


    /**
     * Gets the netValue value for this PurchaseInfo.
     *
     * @return netValue
     */
    public java.math.BigDecimal getNetValue() {
        return netValue;
    }


    /**
     * Sets the netValue value for this PurchaseInfo.
     *
     * @param netValue
     */
    public void setNetValue(java.math.BigDecimal netValue) {
        this.netValue = netValue;
    }


    /**
     * Gets the stockStatus value for this PurchaseInfo.
     *
     * @return stockStatus
     */
    public String getStockStatus() {
        return stockStatus;
    }


    /**
     * Sets the stockStatus value for this PurchaseInfo.
     *
     * @param stockStatus
     */
    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }


    /**
     * Gets the quaStatus value for this PurchaseInfo.
     *
     * @return quaStatus
     */
    public String getQuaStatus() {
        return quaStatus;
    }


    /**
     * Sets the quaStatus value for this PurchaseInfo.
     *
     * @param quaStatus
     */
    public void setQuaStatus(String quaStatus) {
        this.quaStatus = quaStatus;
    }


    /**
     * Gets the ownerName value for this PurchaseInfo.
     *
     * @return ownerName
     */
    public String getOwnerName() {
        return ownerName;
    }


    /**
     * Sets the ownerName value for this PurchaseInfo.
     *
     * @param ownerName
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof PurchaseInfo)) return false;
        PurchaseInfo other = (PurchaseInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) &&
            this.id == other.getId() &&
            ((this.produceDate==null && other.getProduceDate()==null) ||
             (this.produceDate!=null &&
              this.produceDate.equals(other.getProduceDate()))) &&
            ((this.validDate==null && other.getValidDate()==null) ||
             (this.validDate!=null &&
              this.validDate.equals(other.getValidDate()))) &&
            ((this.billNo==null && other.getBillNo()==null) ||
             (this.billNo!=null &&
              this.billNo.equals(other.getBillNo()))) &&
            ((this.flowName==null && other.getFlowName()==null) ||
             (this.flowName!=null &&
              this.flowName.equals(other.getFlowName()))) &&
            ((this.createDate==null && other.getCreateDate()==null) ||
             (this.createDate!=null &&
              this.createDate.equals(other.getCreateDate()))) &&
            ((this.ownerID==null && other.getOwnerID()==null) ||
             (this.ownerID!=null &&
              this.ownerID.equals(other.getOwnerID()))) &&
            ((this.deptName==null && other.getDeptName()==null) ||
             (this.deptName!=null &&
              this.deptName.equals(other.getDeptName()))) &&
            ((this.venderCode==null && other.getVenderCode()==null) ||
             (this.venderCode!=null &&
              this.venderCode.equals(other.getVenderCode()))) &&
            ((this.venderName==null && other.getVenderName()==null) ||
             (this.venderName!=null &&
              this.venderName.equals(other.getVenderName()))) &&
            ((this.excuteQty==null && other.getExcuteQty()==null) ||
             (this.excuteQty!=null &&
              this.excuteQty.equals(other.getExcuteQty()))) &&
            ((this.price==null && other.getPrice()==null) ||
             (this.price!=null &&
              this.price.equals(other.getPrice()))) &&
            ((this.netPrice==null && other.getNetPrice()==null) ||
             (this.netPrice!=null &&
              this.netPrice.equals(other.getNetPrice()))) &&
            ((this.value==null && other.getValue()==null) ||
             (this.value!=null &&
              this.value.equals(other.getValue()))) &&
            ((this.netValue==null && other.getNetValue()==null) ||
             (this.netValue!=null &&
              this.netValue.equals(other.getNetValue()))) &&
            ((this.stockStatus==null && other.getStockStatus()==null) ||
             (this.stockStatus!=null &&
              this.stockStatus.equals(other.getStockStatus()))) &&
            ((this.quaStatus==null && other.getQuaStatus()==null) ||
             (this.quaStatus!=null &&
              this.quaStatus.equals(other.getQuaStatus()))) &&
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
        _hashCode += getId();
        if (getProduceDate() != null) {
            _hashCode += getProduceDate().hashCode();
        }
        if (getValidDate() != null) {
            _hashCode += getValidDate().hashCode();
        }
        if (getBillNo() != null) {
            _hashCode += getBillNo().hashCode();
        }
        if (getFlowName() != null) {
            _hashCode += getFlowName().hashCode();
        }
        if (getCreateDate() != null) {
            _hashCode += getCreateDate().hashCode();
        }
        if (getOwnerID() != null) {
            _hashCode += getOwnerID().hashCode();
        }
        if (getDeptName() != null) {
            _hashCode += getDeptName().hashCode();
        }
        if (getVenderCode() != null) {
            _hashCode += getVenderCode().hashCode();
        }
        if (getVenderName() != null) {
            _hashCode += getVenderName().hashCode();
        }
        if (getExcuteQty() != null) {
            _hashCode += getExcuteQty().hashCode();
        }
        if (getPrice() != null) {
            _hashCode += getPrice().hashCode();
        }
        if (getNetPrice() != null) {
            _hashCode += getNetPrice().hashCode();
        }
        if (getValue() != null) {
            _hashCode += getValue().hashCode();
        }
        if (getNetValue() != null) {
            _hashCode += getNetValue().hashCode();
        }
        if (getStockStatus() != null) {
            _hashCode += getStockStatus().hashCode();
        }
        if (getQuaStatus() != null) {
            _hashCode += getQuaStatus().hashCode();
        }
        if (getOwnerName() != null) {
            _hashCode += getOwnerName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PurchaseInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://vendorDDI.sinopharm_gz.com/", "PurchaseInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("produceDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "produceDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "validDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("billNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "billNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flowName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "flowName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "createDate"));
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
        elemField.setFieldName("deptName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deptName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("venderCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "venderCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("venderName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "venderName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("excuteQty");
        elemField.setXmlName(new javax.xml.namespace.QName("", "excuteQty"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("price");
        elemField.setXmlName(new javax.xml.namespace.QName("", "price"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("netPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "netPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("value");
        elemField.setXmlName(new javax.xml.namespace.QName("", "value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("netValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "netValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stockStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stockStatus"));
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
