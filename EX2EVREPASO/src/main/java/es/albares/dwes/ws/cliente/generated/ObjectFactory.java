
package es.albares.dwes.ws.cliente.generated;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the es.albares.dwes.ws.cliente.generated package. 
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

    private static final QName _Destacados_QNAME = new QName("http://ws.ex2ev.dwes.albares.es/", "destacados");
    private static final QName _DestacadosResponse_QNAME = new QName("http://ws.ex2ev.dwes.albares.es/", "destacadosResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: es.albares.dwes.ws.cliente.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Destacados }
     * 
     * @return
     *     the new instance of {@link Destacados }
     */
    public Destacados createDestacados() {
        return new Destacados();
    }

    /**
     * Create an instance of {@link DestacadosResponse }
     * 
     * @return
     *     the new instance of {@link DestacadosResponse }
     */
    public DestacadosResponse createDestacadosResponse() {
        return new DestacadosResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Destacados }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Destacados }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.ex2ev.dwes.albares.es/", name = "destacados")
    public JAXBElement<Destacados> createDestacados(Destacados value) {
        return new JAXBElement<>(_Destacados_QNAME, Destacados.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DestacadosResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DestacadosResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.ex2ev.dwes.albares.es/", name = "destacadosResponse")
    public JAXBElement<DestacadosResponse> createDestacadosResponse(DestacadosResponse value) {
        return new JAXBElement<>(_DestacadosResponse_QNAME, DestacadosResponse.class, null, value);
    }

}
