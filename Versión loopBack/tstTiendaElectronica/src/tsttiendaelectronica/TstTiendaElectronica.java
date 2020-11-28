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
        int n = args.length;
        if (n > 0) {
            n = Integer.parseInt(args[0]);
        } else {
            n = 10;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(comprobarStock("ISBN", 2));
        }
    }

    private static Boolean comprobarStock(java.lang.String isbn, int unidades) {
        com.adictosaltrabajo.webservice.almacen.AlmacenService service = new com.adictosaltrabajo.webservice.almacen.AlmacenService();
        com.adictosaltrabajo.webservice.almacen.Almacen port = service.getAlmacenPort();
        return port.comprobarStock(isbn, unidades);
    }
    
}
