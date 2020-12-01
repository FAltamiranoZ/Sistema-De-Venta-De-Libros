/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tstgeneral;

/**
 *
 * @author Polupero
 */
public class TstGeneral {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        org.netbeans.j2ee.wsdl.serviciosventa.src.ventalibroswsdl.VentaLibrosWSDLService service = new org.netbeans.j2ee.wsdl.serviciosventa.src.ventalibroswsdl.VentaLibrosWSDLService();
        int n = args.length;
        if (n > 0) {
            n = Integer.parseInt(args[0]);
        } else {
            n = 10;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(ventaLibrosWSDLOperation("978-0-00-000000-2", "6", 10, 2, service));
        }
    }

    private static String ventaLibrosWSDLOperation(java.lang.String isbn, java.lang.String idCliente, int unidades, int precioUnidad, org.netbeans.j2ee.wsdl.serviciosventa.src.ventalibroswsdl.VentaLibrosWSDLService service) {
        org.netbeans.j2ee.wsdl.serviciosventa.src.ventalibroswsdl.VentaLibrosWSDLPortType port = service.getVentaLibrosWSDLPort();
        return port.ventaLibrosWSDLOperation(isbn, idCliente, unidades, precioUnidad);
    }

}
