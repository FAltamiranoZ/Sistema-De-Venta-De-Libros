package com.adictosaltrabajo.webservice.almacen;

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
public class Almacen {

    /**
     * @param ISBN
     * @return
     */
    @WebMethod(operationName = "comprobarISBN")
    public Boolean comprobarISBN(@WebParam(name = "ISBN") String ISBN) {
        boolean flag = false;
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/serviciosVenta", "app", "app");
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select ISBN from productos where ISBN = '" + ISBN + "'");
            if (rs.next()) {
                flag = true;
            }
            rs.close();
            s.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @WebMethod(operationName = "comprobarStock")
    public Boolean comprobarStock(@WebParam(name = "ISBN") String ISBN, @WebParam(name = "unidades") int unidades) {
        boolean flag = false;
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/serviciosVenta", "app", "app");
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select ISBN from productos where ISBN = '" + ISBN + "' and unidades >= " + unidades);
            if (rs.next()) {
                flag = true;
            }
            rs.close();
            s.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @WebMethod(operationName = "comprobarIdCliente")
    public Boolean comprobarIdCliente(@WebParam(name = "idCliente") String idCliente) {
        boolean flag = false;
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/serviciosVenta", "app", "app");
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select idCliente from clientes where idCliente = '" + idCliente + "'");
            if (rs.next()) {
                flag = true;
            }
            rs.close();
            s.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @WebMethod(operationName = "comprobarSaldo")
    public Boolean comprobarSaldo(@WebParam(name = "unidades") int unidades, @WebParam(name = "precioUnidad") int precioUnidad, @WebParam(name = "idCliente") String idCliente) {
        boolean flag = false;
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/serviciosVenta", "app", "app");
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select saldo from clientes where saldo >= " + (unidades * precioUnidad) + "and idCliente = '" + idCliente + "'");
            if (rs.next()) {
                flag = true;
            }
            rs.close();
            s.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

}
