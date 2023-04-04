
package com.docking.wsdl.xlt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>declareItem complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="declareItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="battery" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cnName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commodityNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customsNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="made" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="netWeight" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="netWeightSpecified" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pieces" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="piecesSpecified" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productMemo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rebate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="saleUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unitPrice" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="unitPriceSpecified" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="used" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vatNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "declareItem", propOrder = {
    "battery",
    "cnName",
    "commodityNum",
    "customsNo",
    "made",
    "name",
    "netWeight",
    "netWeightSpecified",
    "pieces",
    "piecesSpecified",
    "productMemo",
    "rebate",
    "saleUrl",
    "unitPrice",
    "unitPriceSpecified",
    "used",
    "vatNo"
})
public class DeclareItem {

    protected String battery;
    protected String cnName;
    protected String commodityNum;
    protected String customsNo;
    protected String made;
    protected String name;
    protected Double netWeight;
    protected String netWeightSpecified;
    protected Long pieces;
    protected String piecesSpecified;
    protected String productMemo;
    protected String rebate;
    protected String saleUrl;
    protected Double unitPrice;
    protected String unitPriceSpecified;
    protected String used;
    protected String vatNo;

    /**
     * 获取battery属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBattery() {
        return battery;
    }

    /**
     * 设置battery属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBattery(String value) {
        this.battery = value;
    }

    /**
     * 获取cnName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCnName() {
        return cnName;
    }

    /**
     * 设置cnName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCnName(String value) {
        this.cnName = value;
    }

    /**
     * 获取commodityNum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommodityNum() {
        return commodityNum;
    }

    /**
     * 设置commodityNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommodityNum(String value) {
        this.commodityNum = value;
    }

    /**
     * 获取customsNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomsNo() {
        return customsNo;
    }

    /**
     * 设置customsNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomsNo(String value) {
        this.customsNo = value;
    }

    /**
     * 获取made属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMade() {
        return made;
    }

    /**
     * 设置made属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMade(String value) {
        this.made = value;
    }

    /**
     * 获取name属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * 获取netWeight属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getNetWeight() {
        return netWeight;
    }

    /**
     * 设置netWeight属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setNetWeight(Double value) {
        this.netWeight = value;
    }

    /**
     * 获取netWeightSpecified属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNetWeightSpecified() {
        return netWeightSpecified;
    }

    /**
     * 设置netWeightSpecified属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNetWeightSpecified(String value) {
        this.netWeightSpecified = value;
    }

    /**
     * 获取pieces属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPieces() {
        return pieces;
    }

    /**
     * 设置pieces属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPieces(Long value) {
        this.pieces = value;
    }

    /**
     * 获取piecesSpecified属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPiecesSpecified() {
        return piecesSpecified;
    }

    /**
     * 设置piecesSpecified属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPiecesSpecified(String value) {
        this.piecesSpecified = value;
    }

    /**
     * 获取productMemo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductMemo() {
        return productMemo;
    }

    /**
     * 设置productMemo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductMemo(String value) {
        this.productMemo = value;
    }

    /**
     * 获取rebate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRebate() {
        return rebate;
    }

    /**
     * 设置rebate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRebate(String value) {
        this.rebate = value;
    }

    /**
     * 获取saleUrl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaleUrl() {
        return saleUrl;
    }

    /**
     * 设置saleUrl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaleUrl(String value) {
        this.saleUrl = value;
    }

    /**
     * 获取unitPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getUnitPrice() {
        return unitPrice;
    }

    /**
     * 设置unitPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setUnitPrice(Double value) {
        this.unitPrice = value;
    }

    /**
     * 获取unitPriceSpecified属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitPriceSpecified() {
        return unitPriceSpecified;
    }

    /**
     * 设置unitPriceSpecified属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitPriceSpecified(String value) {
        this.unitPriceSpecified = value;
    }

    /**
     * 获取used属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsed() {
        return used;
    }

    /**
     * 设置used属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsed(String value) {
        this.used = value;
    }

    /**
     * 获取vatNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVatNo() {
        return vatNo;
    }

    /**
     * 设置vatNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVatNo(String value) {
        this.vatNo = value;
    }

}
