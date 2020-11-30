/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//================================================================
// Código del Cliente:
//================================================================
package tsttiendaelectronica;

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
        boolean response;

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
            com.adictosaltrabajo.webservice.almacen.AlmacenService service = new com.adictosaltrabajo.webservice.almacen.AlmacenService();
            for (i = 0; i < n; i++) {
                t0 = System.currentTimeMillis();
                response = comprobarISBN("ISBN", service);
                response = comprobarStock("978-0-00-000000-0", 5, service);
                response = comprobarIdCliente("1", service);
                response = comprobarSaldo(5, 10, "1", service);
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
