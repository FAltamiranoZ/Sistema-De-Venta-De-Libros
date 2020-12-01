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
        if (n > 0) {
            n = Integer.parseInt(args[0]);
        } else {
            n = 100;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(comprobarISBN("978-0-00-000000-0", service));
            System.out.println(comprobarStock("978-0-00-000000-0", 5, service));
            System.out.println(comprobarIdCliente("1", service));
            System.out.println(comprobarSaldo(5, 10, "1", service));
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

}
