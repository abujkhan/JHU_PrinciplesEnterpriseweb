
package com.abu;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Homework12_WS", targetNamespace = "http://abu.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Homework12WS {


    /**
     * 
     * @param endYear
     * @param beginMonth
     * @param endDay
     * @param beginYear
     * @param baseRate
     * @param beginDay
     * @param endMonth
     * @param numberInParty
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "estimate", targetNamespace = "http://abu.com/", className = "com.abu.Estimate")
    @ResponseWrapper(localName = "estimateResponse", targetNamespace = "http://abu.com/", className = "com.abu.EstimateResponse")
    @Action(input = "http://abu.com/Homework12_WS/estimateRequest", output = "http://abu.com/Homework12_WS/estimateResponse")
    public String estimate(
        @WebParam(name = "beginYear", targetNamespace = "")
        String beginYear,
        @WebParam(name = "beginMonth", targetNamespace = "")
        String beginMonth,
        @WebParam(name = "beginDay", targetNamespace = "")
        String beginDay,
        @WebParam(name = "endYear", targetNamespace = "")
        String endYear,
        @WebParam(name = "endMonth", targetNamespace = "")
        String endMonth,
        @WebParam(name = "endDay", targetNamespace = "")
        String endDay,
        @WebParam(name = "baseRate", targetNamespace = "")
        String baseRate,
        @WebParam(name = "numberInParty", targetNamespace = "")
        String numberInParty);

}