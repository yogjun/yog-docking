
package com.docking.wsdl.xlt;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>orderInfoResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="orderInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="error" type="{http://service.hop.service.ws.hlt.com/}HopHopError" minOccurs="0"/>
 *         &lt;element name="lockedCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="orderList" type="{http://service.hop.service.ws.hlt.com/}order" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="success" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="successCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderInfoResponse", propOrder = {
    "error",
    "lockedCount",
    "orderList",
    "success",
    "successCount"
})
public class OrderInfoResponse {

    protected HopHopError error;
    protected Integer lockedCount;
    @XmlElement(nillable = true)
    protected List<Order> orderList;
    protected Boolean success;
    protected Integer successCount;

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
     * 获取lockedCount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLockedCount() {
        return lockedCount;
    }

    /**
     * 设置lockedCount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLockedCount(Integer value) {
        this.lockedCount = value;
    }

    /**
     * Gets the value of the orderList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orderList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrderList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Order }
     * 
     * 
     */
    public List<Order> getOrderList() {
        if (orderList == null) {
            orderList = new ArrayList<Order>();
        }
        return this.orderList;
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

    /**
     * 获取successCount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSuccessCount() {
        return successCount;
    }

    /**
     * 设置successCount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSuccessCount(Integer value) {
        this.successCount = value;
    }

}
