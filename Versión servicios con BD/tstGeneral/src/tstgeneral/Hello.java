/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//Interfaz:
//================================================================
package tstgeneral;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Hello extends Remote 
{
    String sayHello() throws RemoteException;
}
