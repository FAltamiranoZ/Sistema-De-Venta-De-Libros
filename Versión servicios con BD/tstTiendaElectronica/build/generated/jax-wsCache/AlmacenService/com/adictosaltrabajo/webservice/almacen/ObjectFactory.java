
package com.adictosaltrabajo.webservice.almacen;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.adictosaltrabajo.webservice.almacen package. 
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

    private final static QName _ComprobarStockResponse_QNAME = new QName("http://almacen.webservice.adictosaltrabajo.com/", "comprobarStockResponse");
    private final static QName _ComprobarSaldoResponse_QNAME = new QName("http://almacen.webservice.adictosaltrabajo.com/", "comprobarSaldoResponse");
    private final static QName _ComprobarISBN_QNAME = new QName("http://almacen.webservice.adictosaltrabajo.com/", "comprobarISBN");
    private final static QName _ComprobarSaldo_QNAME = new QName("http://almacen.webservice.adictosaltrabajo.com/", "comprobarSaldo");
    private final static QName _ComprobarStock_QNAME = new QName("http://almacen.webservice.adictosaltrabajo.com/", "comprobarStock");
    private final static QName _ComprobarIdClienteResponse_QNAME = new QName("http://almacen.webservice.adictosaltrabajo.com/", "comprobarIdClienteResponse");
    private final static QName _ComprobarISBNResponse_QNAME = new QName("http://almacen.webservice.adictosaltrabajo.com/", "comprobarISBNResponse");
    private final static QName _ComprobarIdCliente_QNAME = new QName("http://almacen.webservice.adictosaltrabajo.com/", "comprobarIdCliente");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.adictosaltrabajo.webservice.almacen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ComprobarISBNResponse }
     * 
     */
    public ComprobarISBNResponse createComprobarISBNResponse() {
        return new ComprobarISBNResponse();
    }

    /**
     * Create an instance of {@link ComprobarIdCliente }
     * 
     */
    public ComprobarIdCliente createComprobarIdCliente() {
        return new ComprobarIdCliente();
    }

    /**
     * Create an instance of {@link ComprobarIdClienteResponse }
     * 
     */
    public ComprobarIdClienteResponse createComprobarIdClienteResponse() {
        return new ComprobarIdClienteResponse();
    }

    /**
     * Create an instance of {@link ComprobarStock }
     * 
     */
    public ComprobarStock createComprobarStock() {
        return new ComprobarStock();
    }

    /**
     * Create an instance of {@link ComprobarISBN }
     * 
     */
    public ComprobarISBN createComprobarISBN() {
        return new ComprobarISBN();
    }

    /**
     * Create an instance of {@link ComprobarSaldo }
     * 
     */
    public ComprobarSaldo createComprobarSaldo() {
        return new ComprobarSaldo();
    }

    /**
     * Create an instance of {@link ComprobarStockResponse }
     * 
     */
    public ComprobarStockResponse createComprobarStockResponse() {
        return new ComprobarStockResponse();
    }

    /**
     * Create an instance of {@link ComprobarSaldoResponse }
     * 
     */
    public ComprobarSaldoResponse createComprobarSaldoResponse() {
        return new ComprobarSaldoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComprobarStockResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://almacen.webservice.adictosaltrabajo.com/", name = "comprobarStockResponse")
    public JAXBElement<ComprobarStockResponse> createComprobarStockResponse(ComprobarStockResponse value) {
        return new JAXBElement<ComprobarStockResponse>(_ComprobarStockResponse_QNAME, ComprobarStockResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComprobarSaldoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://almacen.webservice.adictosaltrabajo.com/", name = "comprobarSaldoResponse")
    public JAXBElement<ComprobarSaldoResponse> createComprobarSaldoResponse(ComprobarSaldoResponse value) {
        return new JAXBElement<ComprobarSaldoResponse>(_ComprobarSaldoResponse_QNAME, ComprobarSaldoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComprobarISBN }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://almacen.webservice.adictosaltrabajo.com/", name = "comprobarISBN")
    public JAXBElement<ComprobarISBN> createComprobarISBN(ComprobarISBN value) {
        return new JAXBElement<ComprobarISBN>(_ComprobarISBN_QNAME, ComprobarISBN.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComprobarSaldo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://almacen.webservice.adictosaltrabajo.com/", name = "comprobarSaldo")
    public JAXBElement<ComprobarSaldo> createComprobarSaldo(ComprobarSaldo value) {
        return new JAXBElement<ComprobarSaldo>(_ComprobarSaldo_QNAME, ComprobarSaldo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComprobarStock }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://almacen.webservice.adictosaltrabajo.com/", name = "comprobarStock")
    public JAXBElement<ComprobarStock> createComprobarStock(ComprobarStock value) {
        return new JAXBElement<ComprobarStock>(_ComprobarStock_QNAME, ComprobarStock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComprobarIdClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://almacen.webservice.adictosaltrabajo.com/", name = "comprobarIdClienteResponse")
    public JAXBElement<ComprobarIdClienteResponse> createComprobarIdClienteResponse(ComprobarIdClienteResponse value) {
        return new JAXBElement<ComprobarIdClienteResponse>(_ComprobarIdClienteResponse_QNAME, ComprobarIdClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComprobarISBNResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://almacen.webservice.adictosaltrabajo.com/", name = "comprobarISBNResponse")
    public JAXBElement<ComprobarISBNResponse> createComprobarISBNResponse(ComprobarISBNResponse value) {
        return new JAXBElement<ComprobarISBNResponse>(_ComprobarISBNResponse_QNAME, ComprobarISBNResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComprobarIdCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://almacen.webservice.adictosaltrabajo.com/", name = "comprobarIdCliente")
    public JAXBElement<ComprobarIdCliente> createComprobarIdCliente(ComprobarIdCliente value) {
        return new JAXBElement<ComprobarIdCliente>(_ComprobarIdCliente_QNAME, ComprobarIdCliente.class, null, value);
    }

}
