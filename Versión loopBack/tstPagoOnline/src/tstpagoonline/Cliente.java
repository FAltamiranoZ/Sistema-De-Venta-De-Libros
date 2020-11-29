/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//================================================================
// Código del Cliente:
//================================================================
package tstpagoonline;

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
            com.adictosaltrabajo.webservice.pasarelapago.PasarelaPagoService service = new com.adictosaltrabajo.webservice.pasarelapago.PasarelaPagoService();
            for (i = 0; i < n; i++) {
                t0 = System.currentTimeMillis();
                response = facturar("idCliente", 20, service);
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

    private static String facturar(java.lang.String idCliente, int cuantia, com.adictosaltrabajo.webservice.pasarelapago.PasarelaPagoService service) {
        com.adictosaltrabajo.webservice.pasarelapago.PasarelaPago port = service.getPasarelaPagoPort();
        return port.facturar(idCliente, cuantia);
    }

}
