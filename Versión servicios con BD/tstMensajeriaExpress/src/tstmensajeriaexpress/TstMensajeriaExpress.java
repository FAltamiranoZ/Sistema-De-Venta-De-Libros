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
        String temp;
        com.adictosaltrabajo.webservice.mensajeria.EnvioPaquetesService service = new com.adictosaltrabajo.webservice.mensajeria.EnvioPaquetesService();
        int n = args.length;
        if (n > 0) {
            n = Integer.parseInt(args[0]);
        } else {
            n = 116;
        }
        for (int i = 6; i < n; i++) {
            try {
                System.out.println(enviarProducto("nombreEmpresa", Integer.toString(i), service));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private static Integer enviarProducto(java.lang.String empresa, java.lang.String idPedido, com.adictosaltrabajo.webservice.mensajeria.EnvioPaquetesService service){
        com.adictosaltrabajo.webservice.mensajeria.EnvioPaquetes port = service.getEnvioPaquetesPort();
        return port.enviarProducto(empresa, idPedido);
    }

}
