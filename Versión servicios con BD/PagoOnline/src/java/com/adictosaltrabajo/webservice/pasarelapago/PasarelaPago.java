package com.adictosaltrabajo.webservice.pasarelapago;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class PasarelaPago {

    Connection con;
    Statement s;

    public PasarelaPago() throws SQLException {
        this.con = DriverManager.getConnection("jdbc:derby://localhost:1527/serviciosVenta", "app", "app");
        this.s = con.createStatement();
    }

    /**
     * Operacion de un servicio web implementado con JAX-WS que factura a un
     * determinado cliente cierta cuantia.
     *
     * @param idCliente Identificador de un cliente
     * @param cuantia Cuantia a cobrar al cliente
     * @return Identificador de factura
     */
    @WebMethod(operationName = "facturar")
    public String facturar(@WebParam(name = "idCliente") String idCliente, @WebParam(name = "cuantia") int cuantia) {
        String idFactura = "No se registró la factura";
        try {
            ResultSet rs = s.executeQuery("select max(idFactura) from facturas");
            rs.next();
            idFactura = rs.getString(1);
            int temp = Integer.parseInt(idFactura) + 1;
            idFactura = Integer.toString(temp);
            s.executeUpdate("INSERT INTO facturas (idFactura, idCliente, cuantia) VALUES ('" + idFactura + "', '" + idCliente + "', " + cuantia + ")");
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idFactura;
    }

}
