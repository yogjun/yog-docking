
package com.docking.wsdl.xlt;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>trace complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="trace">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enpathInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pathAddr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pathInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pathTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="rcountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="tno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rPaths" type="{http://service.hop.service.ws.hlt.com/}tracePath" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sPaths" type="{http://service.hop.service.ws.hlt.com/}tracePath" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trace", propOrder = {
    "enpathInfo",
    "pathAddr",
    "pathInfo",
    "pathTime",
    "rcountry",
    "status",
    "tno",
    "rPaths",
    "sPaths"
})
public class Trace {

    protected String enpathInfo;
    protected String pathAddr;
    protected String pathInfo;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar pathTime;
    protected String rcountry;
    protected Integer status;
    protected String tno;
    @XmlElement(nillable = true)
    protected List<TracePath> rPaths;
    @XmlElement(nillable = true)
    protected List<TracePath> sPaths;

    /**
     * 获取enpathInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnpathInfo() {
        return enpathInfo;
    }

    /**
     * 设置enpathInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnpathInfo(String value) {
        this.enpathInfo = value;
    }

    /**
     * 获取pathAddr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPathAddr() {
        return pathAddr;
    }

    /**
     * 设置pathAddr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPathAddr(String value) {
        this.pathAddr = value;
    }

    /**
     * 获取pathInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPathInfo() {
        return pathInfo;
    }

    /**
     * 设置pathInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPathInfo(String value) {
        this.pathInfo = value;
    }

    /**
     * 获取pathTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPathTime() {
        return pathTime;
    }

    /**
     * 设置pathTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPathTime(XMLGregorianCalendar value) {
        this.pathTime = value;
    }

    /**
     * 获取rcountry属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRcountry() {
        return rcountry;
    }

    /**
     * 设置rcountry属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRcountry(String value) {
        this.rcountry = value;
    }

    /**
     * 获取status属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置status属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStatus(Integer value) {
        this.status = value;
    }

    /**
     * 获取tno属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTno() {
        return tno;
    }

    /**
     * 设置tno属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTno(String value) {
        this.tno = value;
    }

    /**
     * Gets the value of the rPaths property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rPaths property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRPaths().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TracePath }
     * 
     * 
     */
    public List<TracePath> getRPaths() {
        if (rPaths == null) {
            rPaths = new ArrayList<TracePath>();
        }
        return this.rPaths;
    }

    /**
     * Gets the value of the sPaths property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sPaths property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSPaths().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TracePath }
     * 
     * 
     */
    public List<TracePath> getSPaths() {
        if (sPaths == null) {
            sPaths = new ArrayList<TracePath>();
        }
        return this.sPaths;
    }

}
