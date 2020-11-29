/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tstmensajeriaexpress;

/**
 *
 * @author Polupero
 */
public class TstMensajeriaExpress {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        com.adictosaltrabajo.webservice.mensajeria.EnvioPaquetesService service = new com.adictosaltrabajo.webservice.mensajeria.EnvioPaquetesService();
        int n = args.length;
        if (n > 0) {
            n = Integer.parseInt(args[0]);
        } else {
            n = 10;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(enviarProducto("Empresa", "idPedido", service));
        }
    }

    private static Integer enviarProducto(java.lang.String empresa, java.lang.String idPedido, com.adictosaltrabajo.webservice.mensajeria.EnvioPaquetesService service) {
        com.adictosaltrabajo.webservice.mensajeria.EnvioPaquetes port = service.getEnvioPaquetesPort();
        return port.enviarProducto(empresa, idPedido);
    }

}
