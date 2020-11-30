/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tstpagoonline;

/**
 *
 * @author Polupero
 */
public class TstPagoOnline {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        com.adictosaltrabajo.webservice.pasarelapago.PasarelaPagoService service = new com.adictosaltrabajo.webservice.pasarelapago.PasarelaPagoService();
        int n = args.length;
        if (n > 0) {
            n = Integer.parseInt(args[0]);
        } else {
            n = 1;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(facturar("6", 20, service));
        }
    }

    private static String facturar(java.lang.String idCliente, int cuantia, com.adictosaltrabajo.webservice.pasarelapago.PasarelaPagoService service) {
        com.adictosaltrabajo.webservice.pasarelapago.PasarelaPago port = service.getPasarelaPagoPort();
        return port.facturar(idCliente, cuantia);
    }

}
