/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//================================================================
// Código del Cliente:
//================================================================
package tstgeneral;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long lngQuienSoy;
        long sumDeltaT, sumDeltaT2, dtMin = 0, dtMax = 0;
        long lngCuantosMilisFaltan;

        String host = (args.length < 1) ? null : args[0];
        long i, n, t0, t1, dt;
        String response;

        /*
Este parámetro recibe la cantidad de solicitudes deseadas; a pesar de que si el 
programa se corrre desde el estresador nunca sucede que args[1] == null
debido a como esta creado el estresador, se deja por si se decide ejecutar 
fuera del estresador
         */
        if (args[1] != null) {
            n = Integer.parseInt(args[1]);
        } else {
            n = 200;
        }

        try {
            Registry registry = LocateRegistry.getRegistry(host);
            IServDisparo servDisparo = (IServDisparo) registry.lookup("ServidorDeDisparo");
            lngQuienSoy = servDisparo.quienSoy();
            lngCuantosMilisFaltan = servDisparo.deltaTEnMilis();
            System.out.println("Cliente " + lngQuienSoy + " faltan " + lngCuantosMilisFaltan + " milisegundos");
            sumDeltaT = 0;
            sumDeltaT2 = 0;
            org.netbeans.j2ee.wsdl.serviciosventa.src.ventalibroswsdl.VentaLibrosWSDLService service = new org.netbeans.j2ee.wsdl.serviciosventa.src.ventalibroswsdl.VentaLibrosWSDLService();
            int ISBNcont1 = 7;
            int ISBNcont2 = 0;
            String tempISBN = "";
            for (i = 0; i < n; i++) {
                t0 = System.currentTimeMillis();
                response = ventaLibrosWSDLOperation("978-0-00-000000-2", "6", 10, 2, service);
//                response = newClient(Long.toString(i), "nombreCliente", 20, service);
//                response = modifyClient(Long.toString(i), 10, service);
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
//                response = newProduct("978-0-00-" + tempISBN + "-" + Integer.toString(ISBNcont1), "nombreLibro", 20, service);
//                response = modifyProduct("978-0-00-" + tempISBN + "-" + Integer.toString(ISBNcont1), 10, service);
                if (ISBNcont1 < 9) {
                    ISBNcont1++;
                } else {
                    ISBNcont1 = 0;
                    ISBNcont2++;
                }
                t1 = System.currentTimeMillis();
                dt = t1 - t0;
                sumDeltaT += dt;
                sumDeltaT2 += dt * dt;
                if (i == 0) {
                    dtMin = dt;
                    dtMax = dt;
                } else {
                    if (dt < dtMin) {
                        dtMin = dt;
                    }
                    if (dt > dtMax) {
                        dtMax = dt;
                    }
                }
                System.out.println("Clte " + lngQuienSoy + ": " + response);
            }
            servDisparo.acumula(sumDeltaT, sumDeltaT2, n, dtMax, dtMin);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
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
