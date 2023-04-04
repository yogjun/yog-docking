
package com.docking.wsdl.xlt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>orderWithVirtual complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="orderWithVirtual">
 *   &lt;complexContent>
 *     &lt;extension base="{http://service.hop.service.ws.hlt.com/}order">
 *       &lt;sequence>
 *         &lt;element name="virtualWno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderWithVirtual", propOrder = {
    "virtualWno"
})
public class OrderWithVirtual
    extends Order
{

    protected String virtualWno;

    /**
     * 获取virtualWno属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVirtualWno() {
        return virtualWno;
    }

    /**
     * 设置virtualWno属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVirtualWno(String value) {
        this.virtualWno = value;
    }

}
