
package com.adictosaltrabajo.webservice.mensajeria;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.adictosaltrabajo.webservice.mensajeria package. 
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

    private final static QName _EnviarProducto_QNAME = new QName("http://mensajeria.webservice.adictosaltrabajo.com/", "enviarProducto");
    private final static QName _EnviarProductoResponse_QNAME = new QName("http://mensajeria.webservice.adictosaltrabajo.com/", "enviarProductoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.adictosaltrabajo.webservice.mensajeria
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EnviarProductoResponse }
     * 
     */
    public EnviarProductoResponse createEnviarProductoResponse() {
        return new EnviarProductoResponse();
    }

    /**
     * Create an instance of {@link EnviarProducto }
     * 
     */
    public EnviarProducto createEnviarProducto() {
        return new EnviarProducto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnviarProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mensajeria.webservice.adictosaltrabajo.com/", name = "enviarProducto")
    public JAXBElement<EnviarProducto> createEnviarProducto(EnviarProducto value) {
        return new JAXBElement<EnviarProducto>(_EnviarProducto_QNAME, EnviarProducto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnviarProductoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mensajeria.webservice.adictosaltrabajo.com/", name = "enviarProductoResponse")
    public JAXBElement<EnviarProductoResponse> createEnviarProductoResponse(EnviarProductoResponse value) {
        return new JAXBElement<EnviarProductoResponse>(_EnviarProductoResponse_QNAME, EnviarProductoResponse.class, null, value);
    }

}
