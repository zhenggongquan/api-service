/**
 * SaleInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.api.apiservice.gkgzWebService;

public class SaleInfo  extends SkuDto  implements java.io.Serializable {
    private int id;

    private String billNo;

    private String flowName;

    private String ownerID;

    private String deptName;

    private String saleDate;

    private String releaseDate;

    private String transitDate;

    private String invoiceNo;

    private String invoiceDate;

    private String venderCode;

    private String venderName;

    private String customerCode;

    private String customerName;

    private String customerArea;

    private String customerType;

    private String transAddrCode;

    private String transAddr;

    private String transMode;

    private java.math.BigDecimal excuteQty;

    private java.math.BigDecimal price;

    private java.math.BigDecimal netPrice;

    private java.math.BigDecimal value;

    private java.math.BigDecimal netValue;

    private String ownerName;

    public SaleInfo() {
    }

    public SaleInfo(
           String productCode,
           String productName,
           String producer,
           String productSpec,
           String productUnit,
           String productBatch,
           String productClass,
           int packetNum,
           int id,
           String billNo,
           String flowName,
           String ownerID,
           String deptName,
           String saleDate,
           String releaseDate,
           String transitDate,
           String invoiceNo,
           String invoiceDate,
           String venderCode,
           String venderName,
           String customerCode,
           String customerName,
           String customerArea,
           String customerType,
           String transAddrCode,
           String transAddr,
           String transMode,
           java.math.BigDecimal excuteQty,
           java.math.BigDecimal price,
           java.math.BigDecimal netPrice,
           java.math.BigDecimal value,
           java.math.BigDecimal netValue,
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
        this.billNo = billNo;
        this.flowName = flowName;
        this.ownerID = ownerID;
        this.deptName = deptName;
        this.saleDate = saleDate;
        this.releaseDate = releaseDate;
        this.transitDate = transitDate;
        this.invoiceNo = invoiceNo;
        this.invoiceDate = invoiceDate;
        this.venderCode = venderCode;
        this.venderName = venderName;
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerArea = customerArea;
        this.customerType = customerType;
        this.transAddrCode = transAddrCode;
        this.transAddr = transAddr;
        this.transMode = transMode;
        this.excuteQty = excuteQty;
        this.price = price;
        this.netPrice = netPrice;
        this.value = value;
        this.netValue = netValue;
        this.ownerName = ownerName;
    }


    /**
     * Gets the id value for this SaleInfo.
     *
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this SaleInfo.
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the billNo value for this SaleInfo.
     *
     * @return billNo
     */
    public String getBillNo() {
        return billNo;
    }


    /**
     * Sets the billNo value for this SaleInfo.
     *
     * @param billNo
     */
    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }


    /**
     * Gets the flowName value for this SaleInfo.
     *
     * @return flowName
     */
    public String getFlowName() {
        return flowName;
    }


    /**
     * Sets the flowName value for this SaleInfo.
     *
     * @param flowName
     */
    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }


    /**
     * Gets the ownerID value for this SaleInfo.
     *
     * @return ownerID
     */
    public String getOwnerID() {
        return ownerID;
    }


    /**
     * Sets the ownerID value for this SaleInfo.
     *
     * @param ownerID
     */
    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }


    /**
     * Gets the deptName value for this SaleInfo.
     *
     * @return deptName
     */
    public String getDeptName() {
        return deptName;
    }


    /**
     * Sets the deptName value for this SaleInfo.
     *
     * @param deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }


    /**
     * Gets the saleDate value for this SaleInfo.
     *
     * @return saleDate
     */
    public String getSaleDate() {
        return saleDate;
    }


    /**
     * Sets the saleDate value for this SaleInfo.
     *
     * @param saleDate
     */
    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }


    /**
     * Gets the releaseDate value for this SaleInfo.
     *
     * @return releaseDate
     */
    public String getReleaseDate() {
        return releaseDate;
    }


    /**
     * Sets the releaseDate value for this SaleInfo.
     *
     * @param releaseDate
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }


    /**
     * Gets the transitDate value for this SaleInfo.
     *
     * @return transitDate
     */
    public String getTransitDate() {
        return transitDate;
    }


    /**
     * Sets the transitDate value for this SaleInfo.
     *
     * @param transitDate
     */
    public void setTransitDate(String transitDate) {
        this.transitDate = transitDate;
    }


    /**
     * Gets the invoiceNo value for this SaleInfo.
     *
     * @return invoiceNo
     */
    public String getInvoiceNo() {
        return invoiceNo;
    }


    /**
     * Sets the invoiceNo value for this SaleInfo.
     *
     * @param invoiceNo
     */
    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }


    /**
     * Gets the invoiceDate value for this SaleInfo.
     *
     * @return invoiceDate
     */
    public String getInvoiceDate() {
        return invoiceDate;
    }


    /**
     * Sets the invoiceDate value for this SaleInfo.
     *
     * @param invoiceDate
     */
    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }


    /**
     * Gets the venderCode value for this SaleInfo.
     *
     * @return venderCode
     */
    public String getVenderCode() {
        return venderCode;
    }


    /**
     * Sets the venderCode value for this SaleInfo.
     *
     * @param venderCode
     */
    public void setVenderCode(String venderCode) {
        this.venderCode = venderCode;
    }


    /**
     * Gets the venderName value for this SaleInfo.
     *
     * @return venderName
     */
    public String getVenderName() {
        return venderName;
    }


    /**
     * Sets the venderName value for this SaleInfo.
     *
     * @param venderName
     */
    public void setVenderName(String venderName) {
        this.venderName = venderName;
    }


    /**
     * Gets the customerCode value for this SaleInfo.
     *
     * @return customerCode
     */
    public String getCustomerCode() {
        return customerCode;
    }


    /**
     * Sets the customerCode value for this SaleInfo.
     *
     * @param customerCode
     */
    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }


    /**
     * Gets the customerName value for this SaleInfo.
     *
     * @return customerName
     */
    public String getCustomerName() {
        return customerName;
    }


    /**
     * Sets the customerName value for this SaleInfo.
     *
     * @param customerName
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    /**
     * Gets the customerArea value for this SaleInfo.
     *
     * @return customerArea
     */
    public String getCustomerArea() {
        return customerArea;
    }


    /**
     * Sets the customerArea value for this SaleInfo.
     *
     * @param customerArea
     */
    public void setCustomerArea(String customerArea) {
        this.customerArea = customerArea;
    }


    /**
     * Gets the customerType value for this SaleInfo.
     *
     * @return customerType
     */
    public String getCustomerType() {
        return customerType;
    }


    /**
     * Sets the customerType value for this SaleInfo.
     *
     * @param customerType
     */
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }


    /**
     * Gets the transAddrCode value for this SaleInfo.
     *
     * @return transAddrCode
     */
    public String getTransAddrCode() {
        return transAddrCode;
    }


    /**
     * Sets the transAddrCode value for this SaleInfo.
     *
     * @param transAddrCode
     */
    public void setTransAddrCode(String transAddrCode) {
        this.transAddrCode = transAddrCode;
    }


    /**
     * Gets the transAddr value for this SaleInfo.
     *
     * @return transAddr
     */
    public String getTransAddr() {
        return transAddr;
    }


    /**
     * Sets the transAddr value for this SaleInfo.
     *
     * @param transAddr
     */
    public void setTransAddr(String transAddr) {
        this.transAddr = transAddr;
    }


    /**
     * Gets the transMode value for this SaleInfo.
     *
     * @return transMode
     */
    public String getTransMode() {
        return transMode;
    }


    /**
     * Sets the transMode value for this SaleInfo.
     *
     * @param transMode
     */
    public void setTransMode(String transMode) {
        this.transMode = transMode;
    }


    /**
     * Gets the excuteQty value for this SaleInfo.
     *
     * @return excuteQty
     */
    public java.math.BigDecimal getExcuteQty() {
        return excuteQty;
    }


    /**
     * Sets the excuteQty value for this SaleInfo.
     *
     * @param excuteQty
     */
    public void setExcuteQty(java.math.BigDecimal excuteQty) {
        this.excuteQty = excuteQty;
    }


    /**
     * Gets the price value for this SaleInfo.
     *
     * @return price
     */
    public java.math.BigDecimal getPrice() {
        return price;
    }


    /**
     * Sets the price value for this SaleInfo.
     *
     * @param price
     */
    public void setPrice(java.math.BigDecimal price) {
        this.price = price;
    }


    /**
     * Gets the netPrice value for this SaleInfo.
     *
     * @return netPrice
     */
    public java.math.BigDecimal getNetPrice() {
        return netPrice;
    }


    /**
     * Sets the netPrice value for this SaleInfo.
     *
     * @param netPrice
     */
    public void setNetPrice(java.math.BigDecimal netPrice) {
        this.netPrice = netPrice;
    }


    /**
     * Gets the value value for this SaleInfo.
     *
     * @return value
     */
    public java.math.BigDecimal getValue() {
        return value;
    }


    /**
     * Sets the value value for this SaleInfo.
     *
     * @param value
     */
    public void setValue(java.math.BigDecimal value) {
        this.value = value;
    }


    /**
     * Gets the netValue value for this SaleInfo.
     *
     * @return netValue
     */
    public java.math.BigDecimal getNetValue() {
        return netValue;
    }


    /**
     * Sets the netValue value for this SaleInfo.
     *
     * @param netValue
     */
    public void setNetValue(java.math.BigDecimal netValue) {
        this.netValue = netValue;
    }


    /**
     * Gets the ownerName value for this SaleInfo.
     *
     * @return ownerName
     */
    public String getOwnerName() {
        return ownerName;
    }


    /**
     * Sets the ownerName value for this SaleInfo.
     *
     * @param ownerName
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof SaleInfo)) return false;
        SaleInfo other = (SaleInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) &&
            this.id == other.getId() &&
            ((this.billNo==null && other.getBillNo()==null) ||
             (this.billNo!=null &&
              this.billNo.equals(other.getBillNo()))) &&
            ((this.flowName==null && other.getFlowName()==null) ||
             (this.flowName!=null &&
              this.flowName.equals(other.getFlowName()))) &&
            ((this.ownerID==null && other.getOwnerID()==null) ||
             (this.ownerID!=null &&
              this.ownerID.equals(other.getOwnerID()))) &&
            ((this.deptName==null && other.getDeptName()==null) ||
             (this.deptName!=null &&
              this.deptName.equals(other.getDeptName()))) &&
            ((this.saleDate==null && other.getSaleDate()==null) ||
             (this.saleDate!=null &&
              this.saleDate.equals(other.getSaleDate()))) &&
            ((this.releaseDate==null && other.getReleaseDate()==null) ||
             (this.releaseDate!=null &&
              this.releaseDate.equals(other.getReleaseDate()))) &&
            ((this.transitDate==null && other.getTransitDate()==null) ||
             (this.transitDate!=null &&
              this.transitDate.equals(other.getTransitDate()))) &&
            ((this.invoiceNo==null && other.getInvoiceNo()==null) ||
             (this.invoiceNo!=null &&
              this.invoiceNo.equals(other.getInvoiceNo()))) &&
            ((this.invoiceDate==null && other.getInvoiceDate()==null) ||
             (this.invoiceDate!=null &&
              this.invoiceDate.equals(other.getInvoiceDate()))) &&
            ((this.venderCode==null && other.getVenderCode()==null) ||
             (this.venderCode!=null &&
              this.venderCode.equals(other.getVenderCode()))) &&
            ((this.venderName==null && other.getVenderName()==null) ||
             (this.venderName!=null &&
              this.venderName.equals(other.getVenderName()))) &&
            ((this.customerCode==null && other.getCustomerCode()==null) ||
             (this.customerCode!=null &&
              this.customerCode.equals(other.getCustomerCode()))) &&
            ((this.customerName==null && other.getCustomerName()==null) ||
             (this.customerName!=null &&
              this.customerName.equals(other.getCustomerName()))) &&
            ((this.customerArea==null && other.getCustomerArea()==null) ||
             (this.customerArea!=null &&
              this.customerArea.equals(other.getCustomerArea()))) &&
            ((this.customerType==null && other.getCustomerType()==null) ||
             (this.customerType!=null &&
              this.customerType.equals(other.getCustomerType()))) &&
            ((this.transAddrCode==null && other.getTransAddrCode()==null) ||
             (this.transAddrCode!=null &&
              this.transAddrCode.equals(other.getTransAddrCode()))) &&
            ((this.transAddr==null && other.getTransAddr()==null) ||
             (this.transAddr!=null &&
              this.transAddr.equals(other.getTransAddr()))) &&
            ((this.transMode==null && other.getTransMode()==null) ||
             (this.transMode!=null &&
              this.transMode.equals(other.getTransMode()))) &&
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
        if (getBillNo() != null) {
            _hashCode += getBillNo().hashCode();
        }
        if (getFlowName() != null) {
            _hashCode += getFlowName().hashCode();
        }
        if (getOwnerID() != null) {
            _hashCode += getOwnerID().hashCode();
        }
        if (getDeptName() != null) {
            _hashCode += getDeptName().hashCode();
        }
        if (getSaleDate() != null) {
            _hashCode += getSaleDate().hashCode();
        }
        if (getReleaseDate() != null) {
            _hashCode += getReleaseDate().hashCode();
        }
        if (getTransitDate() != null) {
            _hashCode += getTransitDate().hashCode();
        }
        if (getInvoiceNo() != null) {
            _hashCode += getInvoiceNo().hashCode();
        }
        if (getInvoiceDate() != null) {
            _hashCode += getInvoiceDate().hashCode();
        }
        if (getVenderCode() != null) {
            _hashCode += getVenderCode().hashCode();
        }
        if (getVenderName() != null) {
            _hashCode += getVenderName().hashCode();
        }
        if (getCustomerCode() != null) {
            _hashCode += getCustomerCode().hashCode();
        }
        if (getCustomerName() != null) {
            _hashCode += getCustomerName().hashCode();
        }
        if (getCustomerArea() != null) {
            _hashCode += getCustomerArea().hashCode();
        }
        if (getCustomerType() != null) {
            _hashCode += getCustomerType().hashCode();
        }
        if (getTransAddrCode() != null) {
            _hashCode += getTransAddrCode().hashCode();
        }
        if (getTransAddr() != null) {
            _hashCode += getTransAddr().hashCode();
        }
        if (getTransMode() != null) {
            _hashCode += getTransMode().hashCode();
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
        if (getOwnerName() != null) {
            _hashCode += getOwnerName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SaleInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://vendorDDI.sinopharm_gz.com/", "SaleInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("saleDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "saleDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("releaseDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "releaseDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transitDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transitDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("invoiceNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "invoiceNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("invoiceDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "invoiceDate"));
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
        elemField.setFieldName("customerCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customerCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customerName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerArea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customerArea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customerType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transAddrCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transAddrCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transAddr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transAddr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transMode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transMode"));
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
