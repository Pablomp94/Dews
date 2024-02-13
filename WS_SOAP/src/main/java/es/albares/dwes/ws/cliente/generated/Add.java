
package es.albares.dwes.ws.cliente.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para add complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="add">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="op1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="op2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "add", propOrder = {
    "op1",
    "op2"
})
public class Add {

    protected int op1;
    protected int op2;

    /**
     * Obtiene el valor de la propiedad op1.
     * 
     */
    public int getOp1() {
        return op1;
    }

    /**
     * Define el valor de la propiedad op1.
     * 
     */
    public void setOp1(int value) {
        this.op1 = value;
    }

    /**
     * Obtiene el valor de la propiedad op2.
     * 
     */
    public int getOp2() {
        return op2;
    }

    /**
     * Define el valor de la propiedad op2.
     * 
     */
    public void setOp2(int value) {
        this.op2 = value;
    }

}
