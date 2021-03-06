
package com.adictosaltrabajo.webservice.pasarelapago;

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
@WebService(name = "PasarelaPago", targetNamespace = "http://pasarelapago.webservice.adictosaltrabajo.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PasarelaPago {


    /**
     * 
     * @param idCliente
     * @param cuantia
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "facturar", targetNamespace = "http://pasarelapago.webservice.adictosaltrabajo.com/", className = "com.adictosaltrabajo.webservice.pasarelapago.Facturar")
    @ResponseWrapper(localName = "facturarResponse", targetNamespace = "http://pasarelapago.webservice.adictosaltrabajo.com/", className = "com.adictosaltrabajo.webservice.pasarelapago.FacturarResponse")
    @Action(input = "http://pasarelapago.webservice.adictosaltrabajo.com/PasarelaPago/facturarRequest", output = "http://pasarelapago.webservice.adictosaltrabajo.com/PasarelaPago/facturarResponse")
    public String facturar(
        @WebParam(name = "idCliente", targetNamespace = "")
        String idCliente,
        @WebParam(name = "cuantia", targetNamespace = "")
        int cuantia);

    /**
     * 
     * @param idCliente
     * @param cuantia
     * @param isbn
     * @param unidades
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "actualizarInventario", targetNamespace = "http://pasarelapago.webservice.adictosaltrabajo.com/", className = "com.adictosaltrabajo.webservice.pasarelapago.ActualizarInventario")
    @ResponseWrapper(localName = "actualizarInventarioResponse", targetNamespace = "http://pasarelapago.webservice.adictosaltrabajo.com/", className = "com.adictosaltrabajo.webservice.pasarelapago.ActualizarInventarioResponse")
    @Action(input = "http://pasarelapago.webservice.adictosaltrabajo.com/PasarelaPago/actualizarInventarioRequest", output = "http://pasarelapago.webservice.adictosaltrabajo.com/PasarelaPago/actualizarInventarioResponse")
    public Boolean actualizarInventario(
        @WebParam(name = "idCliente", targetNamespace = "")
        String idCliente,
        @WebParam(name = "cuantia", targetNamespace = "")
        int cuantia,
        @WebParam(name = "ISBN", targetNamespace = "")
        String isbn,
        @WebParam(name = "unidades", targetNamespace = "")
        int unidades);

}
