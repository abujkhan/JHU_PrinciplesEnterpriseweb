
package com.abu;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.abu package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Estimate_QNAME = new QName("http://abu.com/", "estimate");
    private final static QName _EstimateResponse_QNAME = new QName("http://abu.com/", "estimateResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.abu
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EstimateResponse }
     * 
     */
    public EstimateResponse createEstimateResponse() {
        return new EstimateResponse();
    }

    /**
     * Create an instance of {@link Estimate }
     * 
     */
    public Estimate createEstimate() {
        return new Estimate();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Estimate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://abu.com/", name = "estimate")
    public JAXBElement<Estimate> createEstimate(Estimate value) {
        return new JAXBElement<Estimate>(_Estimate_QNAME, Estimate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EstimateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://abu.com/", name = "estimateResponse")
    public JAXBElement<EstimateResponse> createEstimateResponse(EstimateResponse value) {
        return new JAXBElement<EstimateResponse>(_EstimateResponse_QNAME, EstimateResponse.class, null, value);
    }

}
