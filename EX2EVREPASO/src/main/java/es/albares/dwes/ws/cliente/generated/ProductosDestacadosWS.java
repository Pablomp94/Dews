
package es.albares.dwes.ws.cliente.generated;

import java.util.List;
import jakarta.jws.WebMethod;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 * 
 */
@WebService(name = "ProductosDestacadosWS", targetNamespace = "http://ws.ex2ev.dwes.albares.es/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ProductosDestacadosWS {


    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "destacados", targetNamespace = "http://ws.ex2ev.dwes.albares.es/", className = "es.albares.dwes.ws.cliente.generated.Destacados")
    @ResponseWrapper(localName = "destacadosResponse", targetNamespace = "http://ws.ex2ev.dwes.albares.es/", className = "es.albares.dwes.ws.cliente.generated.DestacadosResponse")
    @Action(input = "http://ws.ex2ev.dwes.albares.es/ProductosDestacadosWS/destacadosRequest", output = "http://ws.ex2ev.dwes.albares.es/ProductosDestacadosWS/destacadosResponse")
    public List<String> destacados();

}
