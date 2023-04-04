
package com.docking.wsdl.xlt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>lookupOrderInfoLoadResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="lookupOrderInfoLoadResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="error" type="{http://service.hop.service.ws.hlt.com/}HopHopError" minOccurs="0"/>
 *         &lt;element name="order" type="{http://service.hop.service.ws.hlt.com/}orderWithInfoLoad" minOccurs="0"/>
 *         &lt;element name="success" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lookupOrderInfoLoadResponse", propOrder = {
    "error",
    "order",
    "success"
})
public class LookupOrderInfoLoadResponse {

    protected HopHopError error;
    protected OrderWithInfoLoad order;
    protected Boolean success;

    /**
     * 获取error属性的值。
     * 
     * @return
     *     possible object is
     *     {@link HopHopError }
     *     
     */
    public HopHopError getError() {
        return error;
    }

    /**
     * 设置error属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link HopHopError }
     *     
     */
    public void setError(HopHopError value) {
        this.error = value;
    }

    /**
     * 获取order属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OrderWithInfoLoad }
     *     
     */
    public OrderWithInfoLoad getOrder() {
        return order;
    }

    /**
     * 设置order属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OrderWithInfoLoad }
     *     
     */
    public void setOrder(OrderWithInfoLoad value) {
        this.order = value;
    }

    /**
     * 获取success属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSuccess() {
        return success;
    }

    /**
     * 设置success属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSuccess(Boolean value) {
        this.success = value;
    }

}
