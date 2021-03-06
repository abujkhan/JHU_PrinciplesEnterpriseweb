
package calculatorclient;

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
@WebService(name = "CalculatorWS", targetNamespace = "http://abu.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CalculatorWS {


    /**
     * 
     * @param j
     * @param i
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "add", targetNamespace = "http://abu.com/", className = "calculatorclient.Add")
    @ResponseWrapper(localName = "addResponse", targetNamespace = "http://abu.com/", className = "calculatorclient.AddResponse")
    @Action(input = "http://abu.com/CalculatorWS/addRequest", output = "http://abu.com/CalculatorWS/addResponse")
    public int add(
        @WebParam(name = "i", targetNamespace = "")
        int i,
        @WebParam(name = "j", targetNamespace = "")
        int j);

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://abu.com/", className = "calculatorclient.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://abu.com/", className = "calculatorclient.HelloResponse")
    @Action(input = "http://abu.com/CalculatorWS/helloRequest", output = "http://abu.com/CalculatorWS/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

}
