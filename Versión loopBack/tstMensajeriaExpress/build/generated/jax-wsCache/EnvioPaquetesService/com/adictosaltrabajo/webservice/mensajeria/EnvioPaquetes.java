
package com.adictosaltrabajo.webservice.mensajeria;

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
@WebService(name = "EnvioPaquetes", targetNamespace = "http://mensajeria.webservice.adictosaltrabajo.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface EnvioPaquetes {


    /**
     * 
     * @param empresa
     * @param idPedido
     * @return
     *     returns java.lang.Integer
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "enviarProducto", targetNamespace = "http://mensajeria.webservice.adictosaltrabajo.com/", className = "com.adictosaltrabajo.webservice.mensajeria.EnviarProducto")
    @ResponseWrapper(localName = "enviarProductoResponse", targetNamespace = "http://mensajeria.webservice.adictosaltrabajo.com/", className = "com.adictosaltrabajo.webservice.mensajeria.EnviarProductoResponse")
    @Action(input = "http://mensajeria.webservice.adictosaltrabajo.com/EnvioPaquetes/enviarProductoRequest", output = "http://mensajeria.webservice.adictosaltrabajo.com/EnvioPaquetes/enviarProductoResponse")
    public Integer enviarProducto(
        @WebParam(name = "empresa", targetNamespace = "")
        String empresa,
        @WebParam(name = "idPedido", targetNamespace = "")
        String idPedido);

}
