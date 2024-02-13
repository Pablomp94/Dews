
package es.albares.dwes.ws.cliente.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para operacion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="operacion">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="literal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="operador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="operando1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="operando2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="resultado" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "operacion", propOrder = {
    "literal",
    "operador",
    "operando1",
    "operando2",
    "resultado"
})
public class Operacion {

    protected String literal;
    protected String operador;
    protected int operando1;
    protected int operando2;
    protected int resultado;

    /**
     * Obtiene el valor de la propiedad literal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLiteral() {
        return literal;
    }

    /**
     * Define el valor de la propiedad literal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLiteral(String value) {
        this.literal = value;
    }

    /**
     * Obtiene el valor de la propiedad operador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperador() {
        return operador;
    }

    /**
     * Define el valor de la propiedad operador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperador(String value) {
        this.operador = value;
    }

    /**
     * Obtiene el valor de la propiedad operando1.
     * 
     */
    public int getOperando1() {
        return operando1;
    }

    /**
     * Define el valor de la propiedad operando1.
     * 
     */
    public void setOperando1(int value) {
        this.operando1 = value;
    }

    /**
     * Obtiene el valor de la propiedad operando2.
     * 
     */
    public int getOperando2() {
        return operando2;
    }

    /**
     * Define el valor de la propiedad operando2.
     * 
     */
    public void setOperando2(int value) {
        this.operando2 = value;
    }

    /**
     * Obtiene el valor de la propiedad resultado.
     * 
     */
    public int getResultado() {
        return resultado;
    }

    /**
     * Define el valor de la propiedad resultado.
     * 
     */
    public void setResultado(int value) {
        this.resultado = value;
    }

}
