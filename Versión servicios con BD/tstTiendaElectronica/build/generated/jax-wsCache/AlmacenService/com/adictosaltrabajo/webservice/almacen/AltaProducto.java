
package com.adictosaltrabajo.webservice.almacen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para altaProducto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="altaProducto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ISBN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombrelibro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="saldo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "altaProducto", propOrder = {
    "isbn",
    "nombrelibro",
    "saldo"
})
public class AltaProducto {

    @XmlElement(name = "ISBN")
    protected String isbn;
    protected String nombrelibro;
    protected int saldo;

    /**
     * Obtiene el valor de la propiedad isbn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISBN() {
        return isbn;
    }

    /**
     * Define el valor de la propiedad isbn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISBN(String value) {
        this.isbn = value;
    }

    /**
     * Obtiene el valor de la propiedad nombrelibro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombrelibro() {
        return nombrelibro;
    }

    /**
     * Define el valor de la propiedad nombrelibro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombrelibro(String value) {
        this.nombrelibro = value;
    }

    /**
     * Obtiene el valor de la propiedad saldo.
     * 
     */
    public int getSaldo() {
        return saldo;
    }

    /**
     * Define el valor de la propiedad saldo.
     * 
     */
    public void setSaldo(int value) {
        this.saldo = value;
    }

}
