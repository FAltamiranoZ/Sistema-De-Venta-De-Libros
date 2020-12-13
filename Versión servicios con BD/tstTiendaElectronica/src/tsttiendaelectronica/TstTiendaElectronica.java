/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsttiendaelectronica;

/**
 *
 * @author Polupero
 */
public class TstTiendaElectronica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        com.adictosaltrabajo.webservice.almacen.AlmacenService service = new com.adictosaltrabajo.webservice.almacen.AlmacenService();
        int n = args.length;
        int ISBNcont1 = 7;
        int ISBNcont2 = 0;
        String tempISBN = "";
        if (n > 0) {
            n = Integer.parseInt(args[0]);
        } else {
            n = 17;
        }
        for (int i = 7; i < n; i++) {

            System.out.println(comprobarISBN("978-0-00-000000-0", service));
            System.out.println(comprobarStock("978-0-00-000000-0", 5, service));
            System.out.println(comprobarIdCliente("1", service));
            System.out.println(comprobarSaldo(5, 10, "1", service));

            System.out.println(altaCliente(Integer.toString(i), "nombreCliente", 20, service));
            System.out.println(modificarCliente(Integer.toString(i), 10, service));
            if (ISBNcont2 < 10) {
                tempISBN = "00000" + Integer.toString(ISBNcont2);
            } else if (ISBNcont2 < 100) {
                tempISBN = "0000" + Integer.toString(ISBNcont2);
            } else if (ISBNcont2 < 1000) {
                tempISBN = "000" + Integer.toString(ISBNcont2);
            } else if (ISBNcont2 < 10000) {
                tempISBN = "00" + Integer.toString(ISBNcont2);
            } else if (ISBNcont2 < 100000) {
                tempISBN = "0" + Integer.toString(ISBNcont2);
            }else {
                tempISBN = Integer.toString(ISBNcont2);
            }
            System.out.println(altaProducto("978-0-00-" + tempISBN + "-" + Integer.toString(ISBNcont1), "nombreLibro", 20, service));
//            System.out.println(modificarProducto("978-0-00-" + tempISBN + "-" + Integer.toString(ISBNcont1), 10, service));
            if (ISBNcont1 < 9) {
                ISBNcont1++;
            } else {
                ISBNcont1 = 0;
                ISBNcont2++;
            }
        }
    }

    private static Boolean comprobarISBN(java.lang.String isbn, com.adictosaltrabajo.webservice.almacen.AlmacenService service) {
        com.adictosaltrabajo.webservice.almacen.Almacen port = service.getAlmacenPort();
        return port.comprobarISBN(isbn);
    }

    private static Boolean comprobarStock(java.lang.String isbn, int unidades, com.adictosaltrabajo.webservice.almacen.AlmacenService service) {
        com.adictosaltrabajo.webservice.almacen.Almacen port = service.getAlmacenPort();
        return port.comprobarStock(isbn, unidades);
    }

    private static Boolean comprobarIdCliente(String idCliente, com.adictosaltrabajo.webservice.almacen.AlmacenService service) {
        com.adictosaltrabajo.webservice.almacen.Almacen port = service.getAlmacenPort();
        return port.comprobarIdCliente(idCliente);
    }

    private static Boolean comprobarSaldo(int unidades, int precioUnidad, String idCliente, com.adictosaltrabajo.webservice.almacen.AlmacenService service) {
        com.adictosaltrabajo.webservice.almacen.Almacen port = service.getAlmacenPort();
        return port.comprobarSaldo(unidades, precioUnidad, idCliente);
    }

    private static Boolean altaCliente(java.lang.String idCliente, java.lang.String nombreCliente, float saldo, com.adictosaltrabajo.webservice.almacen.AlmacenService service) {
        com.adictosaltrabajo.webservice.almacen.Almacen port = service.getAlmacenPort();
        return port.altaCliente(idCliente, nombreCliente, saldo);
    }

    private static Boolean altaProducto(java.lang.String isbn, java.lang.String nombrelibro, int unidades, com.adictosaltrabajo.webservice.almacen.AlmacenService service) {
        com.adictosaltrabajo.webservice.almacen.Almacen port = service.getAlmacenPort();
        return port.altaProducto(isbn, nombrelibro, unidades);
    }

    private static Boolean modificarCliente(java.lang.String idCliente, float saldo, com.adictosaltrabajo.webservice.almacen.AlmacenService service) {
        com.adictosaltrabajo.webservice.almacen.Almacen port = service.getAlmacenPort();
        return port.modificarCliente(idCliente, saldo);
    }

    private static Boolean modificarProducto(java.lang.String isbn, int unidades, com.adictosaltrabajo.webservice.almacen.AlmacenService service) {
        com.adictosaltrabajo.webservice.almacen.Almacen port = service.getAlmacenPort();
        return port.modificarProducto(isbn, unidades);
    }

}
