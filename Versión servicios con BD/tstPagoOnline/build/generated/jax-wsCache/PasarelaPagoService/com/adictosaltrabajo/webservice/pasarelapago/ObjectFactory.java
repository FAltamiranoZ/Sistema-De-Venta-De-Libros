
package com.adictosaltrabajo.webservice.pasarelapago;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.adictosaltrabajo.webservice.pasarelapago package. 
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

    private final static QName _ActualizarInventarioResponse_QNAME = new QName("http://pasarelapago.webservice.adictosaltrabajo.com/", "actualizarInventarioResponse");
    private final static QName _Facturar_QNAME = new QName("http://pasarelapago.webservice.adictosaltrabajo.com/", "facturar");
    private final static QName _FacturarResponse_QNAME = new QName("http://pasarelapago.webservice.adictosaltrabajo.com/", "facturarResponse");
    private final static QName _ActualizarInventario_QNAME = new QName("http://pasarelapago.webservice.adictosaltrabajo.com/", "actualizarInventario");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.adictosaltrabajo.webservice.pasarelapago
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ActualizarInventarioResponse }
     * 
     */
    public ActualizarInventarioResponse createActualizarInventarioResponse() {
        return new ActualizarInventarioResponse();
    }

    /**
     * Create an instance of {@link ActualizarInventario }
     * 
     */
    public ActualizarInventario createActualizarInventario() {
        return new ActualizarInventario();
    }

    /**
     * Create an instance of {@link Facturar }
     * 
     */
    public Facturar createFacturar() {
        return new Facturar();
    }

    /**
     * Create an instance of {@link FacturarResponse }
     * 
     */
    public FacturarResponse createFacturarResponse() {
        return new FacturarResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarInventarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pasarelapago.webservice.adictosaltrabajo.com/", name = "actualizarInventarioResponse")
    public JAXBElement<ActualizarInventarioResponse> createActualizarInventarioResponse(ActualizarInventarioResponse value) {
        return new JAXBElement<ActualizarInventarioResponse>(_ActualizarInventarioResponse_QNAME, ActualizarInventarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Facturar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pasarelapago.webservice.adictosaltrabajo.com/", name = "facturar")
    public JAXBElement<Facturar> createFacturar(Facturar value) {
        return new JAXBElement<Facturar>(_Facturar_QNAME, Facturar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FacturarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pasarelapago.webservice.adictosaltrabajo.com/", name = "facturarResponse")
    public JAXBElement<FacturarResponse> createFacturarResponse(FacturarResponse value) {
        return new JAXBElement<FacturarResponse>(_FacturarResponse_QNAME, FacturarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarInventario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pasarelapago.webservice.adictosaltrabajo.com/", name = "actualizarInventario")
    public JAXBElement<ActualizarInventario> createActualizarInventario(ActualizarInventario value) {
        return new JAXBElement<ActualizarInventario>(_ActualizarInventario_QNAME, ActualizarInventario.class, null, value);
    }

}
