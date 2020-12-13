package com.adictosaltrabajo.webservice.pasarelapago;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/serviciosVenta", "app", "app");
            Statement s = con.createStatement();
            ResultSet rs;
            rs = s.executeQuery("select max(CAST(idFactura as int)) from facturas");
            rs.next();
            idFactura = rs.getString(1);
//            System.out.println(idFactura);
            int temp = Integer.parseInt(idFactura) + 1;
//            System.out.println(temp);
            idFactura = Integer.toString(temp);
//            System.out.println("INSERT INTO facturas (idFactura, idCliente, cuantia) VALUES ('" + idFactura + "', '" + idCliente + "', " + cuantia + ")");
            s.executeUpdate("INSERT INTO facturas (idFactura, idCliente, cuantia) VALUES ('" + idFactura + "', '" + idCliente + "', " + cuantia + ")");
            rs.close();
            s.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idFactura;
    }

    /**
     *
     * @param idCliente
     * @param cuantia
     * @param ISBN
     * @param unidades
     * @return
     */
    @WebMethod(operationName = "actualizarInventario")
    public Boolean actualizarInventario(@WebParam(name = "idCliente") String idCliente, @WebParam(name = "cuantia") int cuantia, @WebParam(name = "ISBN") String ISBN, @WebParam(name = "unidades") int unidades) {
        boolean flag = false;
        float saldo;
        int unidadesTotales;
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/serviciosVenta", "app", "app");
            Statement s = con.createStatement();
            ResultSet rs1, rs2;

//            System.out.println(idCliente);
//            System.out.println(cuantia);
//            System.out.println(ISBN);
//            System.out.println(unidades);
//            System.out.println("select saldo from clientes where idcliente = '" + idCliente + "'");
            rs1 = s.executeQuery("select saldo from clientes where idcliente = '" + idCliente + "'");

            rs1.next();
            saldo = rs1.getFloat(1);
//            System.out.println(saldo);
//            System.out.println("update clientes set saldo = " + (saldo - cuantia) + " where idcliente = '" + idCliente + "'");
            s.executeUpdate("update clientes set saldo = " + (saldo - cuantia) + " where idcliente = '" + idCliente + "'");
            rs1.close();

//            System.out.println("select unidades from productos where ISBN = '" + ISBN + "'");
            rs2 = s.executeQuery("select unidades from productos where ISBN = '" + ISBN + "'");
            rs2.next();
            unidadesTotales = rs2.getInt(1);
//            System.out.println(unidadesTotales);
//            System.out.println("update productos set unidades = " + (unidadesTotales - unidades) + " where ISBN = '" + ISBN + "'");
            s.executeUpdate("update productos set unidades = " + (unidadesTotales - unidades) + " where ISBN = '" + ISBN + "'");
            rs2.close();
            s.close();
            con.close();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

}
