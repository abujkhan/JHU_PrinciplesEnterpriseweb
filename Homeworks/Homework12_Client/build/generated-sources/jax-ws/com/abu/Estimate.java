
package com.abu;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for estimate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="estimate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="beginYear" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="beginMonth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="beginDay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endYear" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endMonth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endDay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="baseRate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numberInParty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "estimate", propOrder = {
    "beginYear",
    "beginMonth",
    "beginDay",
    "endYear",
    "endMonth",
    "endDay",
    "baseRate",
    "numberInParty"
})
public class Estimate {

    protected String beginYear;
    protected String beginMonth;
    protected String beginDay;
    protected String endYear;
    protected String endMonth;
    protected String endDay;
    protected String baseRate;
    protected String numberInParty;

    /**
     * Gets the value of the beginYear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeginYear() {
        return beginYear;
    }

    /**
     * Sets the value of the beginYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeginYear(String value) {
        this.beginYear = value;
    }

    /**
     * Gets the value of the beginMonth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeginMonth() {
        return beginMonth;
    }

    /**
     * Sets the value of the beginMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeginMonth(String value) {
        this.beginMonth = value;
    }

    /**
     * Gets the value of the beginDay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeginDay() {
        return beginDay;
    }

    /**
     * Sets the value of the beginDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeginDay(String value) {
        this.beginDay = value;
    }

    /**
     * Gets the value of the endYear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndYear() {
        return endYear;
    }

    /**
     * Sets the value of the endYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndYear(String value) {
        this.endYear = value;
    }

    /**
     * Gets the value of the endMonth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndMonth() {
        return endMonth;
    }

    /**
     * Sets the value of the endMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndMonth(String value) {
        this.endMonth = value;
    }

    /**
     * Gets the value of the endDay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDay() {
        return endDay;
    }

    /**
     * Sets the value of the endDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDay(String value) {
        this.endDay = value;
    }

    /**
     * Gets the value of the baseRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseRate() {
        return baseRate;
    }

    /**
     * Sets the value of the baseRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseRate(String value) {
        this.baseRate = value;
    }

    /**
     * Gets the value of the numberInParty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberInParty() {
        return numberInParty;
    }

    /**
     * Sets the value of the numberInParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberInParty(String value) {
        this.numberInParty = value;
    }

}
