package com.adictosaltrabajo.webservice.mensajeria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Random;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Codigo perteneciente a: Tutorial de BPEL con OpenESB
 *
 * @author www.adictosaltrabajo.com - Ivan Garcia Puebla
 * @version 1.0
 */
@WebService()
public class EnvioPaquetes {

    /**
     * Operacion de un servicio web implementado con JAX-WS que emite la orden
     * de envio de un producto.
     *
     * @param empresa Identificador de empresa
     * @param idPedido Identificador de pedido
     * @return Tiempo de reparto en dias
     */
    @WebMethod(operationName = "enviarProducto")
    public Integer enviarProducto(@WebParam(name = "empresa") String empresa, @WebParam(name = "idPedido") String idPedido) {
        Random rnd = new Random();
        int dias = rnd.nextInt(15) + 1;
        long temp = dias;
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/serviciosVenta", "app", "app");
            Statement s = con.createStatement();
            s.executeUpdate("INSERT INTO pedidos (idPedido, fecha, nombreEmpresa) VALUES ('" + idPedido + "', TIMESTAMP('" + new Timestamp((System.currentTimeMillis() + temp * 24 * 60 * 60 * 1000)) + "'), '" + empresa + "')");
            s.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dias;
    }

}
