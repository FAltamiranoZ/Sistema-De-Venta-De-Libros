package com.adictosaltrabajo.webservice.almacen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    Connection con;
    Statement s;

    public Almacen() throws SQLException {
        this.con = DriverManager.getConnection("jdbc:derby://localhost:1527/serviciosVenta", "app", "app");
        this.s = con.createStatement();
    }

    /**
     * @param ISBN
     * @return
     */
    @WebMethod(operationName = "comprobarISBN")
    public Boolean comprobarISBN(@WebParam(name = "ISBN") String ISBN) {
        boolean flag = false;
        try {
            ResultSet rs = s.executeQuery("select ISBN from productos where ISBN = '" + ISBN + "'");
            if (rs.next()) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        int k = s.executeUpdate("INSERT INTO clientes (nombreCliente, saldo) VALUES ('ClientePrueba2', 1000)");
//        s.close();
//        if (k == 1) {
//            flag = true;
//        }
        return flag;
    }

    @WebMethod(operationName = "comprobarStock")
    public Boolean comprobarStock(@WebParam(name = "ISBN") String ISBN, @WebParam(name = "unidades") int unidades) {
        boolean flag = false;
        try {
            ResultSet rs = s.executeQuery("select ISBN from productos where ISBN = '" + ISBN + "' and unidades > " + unidades);
            if (rs.next()) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @WebMethod(operationName = "comprobarIdCliente")
    public Boolean comprobarIdCliente(@WebParam(name = "idCliente") int idCliente) {
        boolean flag = false;
        try {
            ResultSet rs = s.executeQuery("select idCliente from clientes where idCliente = " + idCliente);
            if (rs.next()) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @WebMethod(operationName = "comprobarSaldo")
    public Boolean comprobarSaldo(@WebParam(name = "unidades") int unidades, @WebParam(name = "precioUnidad") int precioUnidad) {
        boolean flag = false;
        try {
            ResultSet rs = s.executeQuery("select saldo from clientes where saldo > " + (unidades * precioUnidad));
            if (rs.next()) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

}
