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
            n = 17;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(ventaLibrosWSDLOperation("978-0-00-000000-2", "6", 10, 2, service));
        }

        int ISBNcont1 = 7;
        int ISBNcont2 = 0;
        String tempISBN = "";
        for (int i = 7; i < n; i++) {
            System.out.println(newClient(Integer.toString(i), "nombreCliente", 20, service));
            System.out.println(modifyClient(Integer.toString(i), 10, service));
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
            } else {
                tempISBN = Integer.toString(ISBNcont2);
            }
            System.out.println(newProduct("978-0-00-" + tempISBN + "-" + Integer.toString(ISBNcont1), "nombreLibro", 20, service));
            System.out.println(modifyProduct("978-0-00-" + tempISBN + "-" + Integer.toString(ISBNcont1), 10, service));
            if (ISBNcont1 < 9) {
                ISBNcont1++;
            } else {
                ISBNcont1 = 0;
                ISBNcont2++;
            }
        }

    }

    private static String ventaLibrosWSDLOperation(java.lang.String isbn, java.lang.String idCliente, int unidades, int precioUnidad, org.netbeans.j2ee.wsdl.serviciosventa.src.ventalibroswsdl.VentaLibrosWSDLService service) {
        org.netbeans.j2ee.wsdl.serviciosventa.src.ventalibroswsdl.VentaLibrosWSDLPortType port = service.getVentaLibrosWSDLPort();
        return port.ventaLibrosWSDLOperation(isbn, idCliente, unidades, precioUnidad);
    }

    private static String newClient(java.lang.String idCliente, java.lang.String nombreCliente, float saldo, org.netbeans.j2ee.wsdl.serviciosventa.src.ventalibroswsdl.VentaLibrosWSDLService service) {
        org.netbeans.j2ee.wsdl.serviciosventa.src.ventalibroswsdl.VentaLibrosWSDLPortType port = service.getVentaLibrosWSDLPort();
        return port.newClient(idCliente, nombreCliente, saldo);
    }

    private static String newProduct(java.lang.String isbn, java.lang.String nombreLibro, int unidades, org.netbeans.j2ee.wsdl.serviciosventa.src.ventalibroswsdl.VentaLibrosWSDLService service) {
        org.netbeans.j2ee.wsdl.serviciosventa.src.ventalibroswsdl.VentaLibrosWSDLPortType port = service.getVentaLibrosWSDLPort();
        return port.newProduct(isbn, nombreLibro, unidades);
    }

    private static String modifyClient(java.lang.String idCliente, float saldo, org.netbeans.j2ee.wsdl.serviciosventa.src.ventalibroswsdl.VentaLibrosWSDLService service) {
        org.netbeans.j2ee.wsdl.serviciosventa.src.ventalibroswsdl.VentaLibrosWSDLPortType port = service.getVentaLibrosWSDLPort();
        return port.modifyClient(idCliente, saldo);
    }

    private static String modifyProduct(java.lang.String isbn, int unidades, org.netbeans.j2ee.wsdl.serviciosventa.src.ventalibroswsdl.VentaLibrosWSDLService service) {
        org.netbeans.j2ee.wsdl.serviciosventa.src.ventalibroswsdl.VentaLibrosWSDLPortType port = service.getVentaLibrosWSDLPort();
        return port.modifyProduct(isbn, unidades);
    }

}
