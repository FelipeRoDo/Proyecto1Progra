/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1.progra;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Felipe
 */
public class Proyecto1Progra {
    
    //Variable fecha
    Date fecha;
    //Declarar instancia de Scanner
    Scanner scan = new Scanner(System.in);
    //Para el loop del SwitchCase
    int contador = -1;
    //Instancias
    Cliente c = new Cliente();
    Cajero ca = new Cajero();
    //Variables para guardar scan
    int credito;
    int retiro;
    //Log
    String apertura;
    String cierre;
    String cred;
    String ret;

    //Metodo que comprueba que los valores sean numeros
    public boolean IsNumeric(String valor) {
        try {
            Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException nfe) {
            System.out.println("Solo se aceptan numeros");
            return false;
        }
    }
    
    //Menu principal
    public void MenuOperaciones() {
        
        //Mensaje de Bienvenida
        System.out.println("Bienvenido al Sistema de Cajero!");
        //LLama al metodo de CrearCajero mediante su intancia ca
        ca.CreaCajero();
        //Llama al metodo CreaCliente mediante su intancia c
        c.CreaCliente();
        
        //Valida si ya se le asigno un cajero al cliente
        if (ca.AsignaCajero(c) == true) {
            //Imprime mensaje pidiendo la informacion del cliente
            System.out.println("Informacion necesaria para cumplir las operaciones: ");
            //Informacion del cliente, mediante el metodo SolicitaInfoCliente.
            ca.SolicitaInfoCliente(c);
            //Mientras el usuario no se salga del menu con 0, seguira desplegando el menu despues de cada operacion
            while (contador != 0) {
                //Mensaje para eligir operaciones
                System.out.println("\nElija la Operacion que desea realizar: ");
                //Operaciones
                System.out.println("\n1.- Apertura"
                        + "\n2.- Cierre\n"
                        + "3.- Credito\n"
                        + "4.- Retiro\n"
                        + "5.- Mostrar Cliente\n"
                        + "6.- Log de operaciones\n"
                        + "0.- Salir");
                //Guarda en la variable contados lo digitado por el usuario
                contador = Integer.parseInt(scan.nextLine());
                //Switch case con la variable contador
                switch (contador) {
                    //Si digita 1
                    case 1:
                        // Si el metodo de Apertura de la clase cajero devuelve verdadero
                        if (ca.Apertura(c) == true) {
                            //Fecha de la transaccion
                            fecha = new Date();
                            //Guarda en la variable apertura informacion 
                            apertura = "Se realizo la apertura de una cuenta para el cliente: " + c.getNombre() + " " + c.getApellido1()
                                    + "\nCedula: " + c.getCedula()
                                    + "\nOperacion realizada por el cajero: " + ca.getNombre() + " " + ca.getApellido1()
                                    + "Cedula: " + ca.getCedula()
                                    + "\nFecha y hora: " + fecha + "\n";
                        } else {
                            //Guarda en variable apertura
                            apertura = "No se realizo apertura de cuenta, ya que posee una cuenta";
                        }
                        //llama al metodo log para guardar la variable apertura dentro de su lista
                        ca.Log(apertura);
                        break;

                    //Si digita 2
                    case 2:
                        // Si el metodo de Cierre de la clase cajero devuelve verdadero
                        if (ca.Cierre(c) == true) {
                            //Fecha de la transaccion
                            fecha = new Date();
                            //Guarda en variable cierre
                            cierre = "Se realizo el cierre de la cuenta para el cliente: " + c.getNombre() + " " + c.getApellido1()
                                    + "\nCedula: " + c.getCedula()
                                    + "\nOperacion realizada por el cajero: " + ca.getNombre() + " " + ca.getApellido1()
                                    + "Cedula: " + ca.getCedula()
                                    + "\nFecha y hora: " + fecha + "\n";
                        } else {
                            //Guarda en variable cierre
                            cierre = "No se realizo el cierre de cuenta, ya que no posee una cuenta";
                        }
                        //llama al metodo log para guardar la variable apertura dentro de su lista
                        ca.Log(cierre);
                        break;
                    //Si digita 3
                    case 3:
                        // Si posee cuenta bancaria
                        if (c.isCuentaBancaria() == true) {
                            //Fecha de la transaccion
                            fecha = new Date();
                            //Pregunta al usuario el credito a añadir al saldo
                            System.out.println("Cuanto credito desea añadir a su saldo");
                            //Guarda en la variable credito lo digitado por el usuario
                            credito = Integer.parseInt(scan.nextLine());
                            //Valida si es numerico o no lo digitado por el usuario
                            if (this.IsNumeric(String.valueOf(credito)) == true) {
                                // Si el metodo credito devuelve verdadero
                                if (ca.Credito(c, credito) == true) {
                                    //Guarda en variable cred
                                    cred = "Se añadio credito: " + credito + " a la cuenta de: " + c.getNombre() + " " + c.getApellido1()
                                            + "\nCedula: " + c.getCedula()
                                            + "\nOperacion realizada por el cajero: " + ca.getNombre() + " " + ca.getApellido1()
                                            + "Cedula: " + ca.getCedula()
                                            + "\nFecha y hora: " + fecha + "\n";
                                } else {
                                    //Guarda en variable cred
                                    cred = "No se añadio credito a la cuenta de: " + c.getNombre() + " " + c.getApellido1()
                                            + "\nCedula: " + c.getCedula()
                                            + "\nOperacion realizada por el cajero: " + ca.getNombre() + " " + ca.getApellido1()
                                            + "Cedula: " + ca.getCedula()
                                            + "\nFecha y hora: " + fecha + "\n";
                                }
                                //llama al metodo log para guardar la variable apertura dentro de su lista
                                ca.Log(cred);
                            }
                        } else {
                            //Mensaje
                            System.out.println("Primero debe crear una cuenta bancaria");
                        }

                        break;
                    // Si digita 4
                    case 4:
                        // Si posee cuenta bancaria
                        if (c.isCuentaBancaria() == true) {
                            //Fecha de la transaccion
                            fecha = new Date();
                            //Pregunta al usuario el retiro al saldo
                            System.out.println("Cuanto desea retirar a su saldo");
                            //Guarda en la variable retiro lo digitado por el usuario
                            retiro = Integer.parseInt(scan.nextLine());
                            //Valida si lo digitado es numerico o no
                            if (this.IsNumeric(String.valueOf(retiro)) == true) {
                                // Si el metodo Retiro devuelve verdadero
                                if (ca.Retiro(c, retiro) == true) {
                                    //Guarda en variable ret
                                    ret = "Se retiro : " + retiro + " de la cuenta de: " + c.getNombre() + " " + c.getApellido1() 
                                            + "\nCedula: " + c.getCedula() 
                                            + "\nOperacion realizada por el cajero: " + ca.getNombre() + " " + ca.getApellido1()
                                            + "Cedula: " + ca.getCedula()
                                            + "\nFecha y hora: " + fecha + "\n";
                                } else {
                                    //Guarda en variable ret
                                    ret = "No se pudo hacer el retiro a la cuenta de: " + c.getNombre() + " " + c.getApellido1() 
                                            + "\nCedula: " + c.getCedula() 
                                            + "\nOperacion realizada por el cajero: " + ca.getNombre() + " " + ca.getApellido1()
                                            + "Cedula: " + ca.getCedula()
                                            + "\nFecha y hora: " + fecha + "\n";
                                }
                                //llama al metodo log para guardar la variable apertura dentro de su lista
                                ca.Log(ret);
                            }
                        } else {
                            //Mensaje
                            System.out.println("Primero debe crear una cuenta bancaria");
                        }

                        break;
                    //Si digita 5
                    case 5:
                        //Llama al metodo mostrar Cliente de la clase Cliente
                        c.MuestraCliente();
                        break;
                    //Si digita 6
                    case 6:
                        //Llama al metodo imprimir log de la clase Cajero
                        ca.ImprimeLog();
                        break;
                    //Si no escoge ninguna de las opciones del menu
                    default:
                        //Si el contador es 0 simplemente se sale
                        if (contador == 0) {
                        
                        //Si es diferente de 0 y diferente a las opciones del menu
                        } else {
                            //Mensaje
                            System.out.println("Debe escoger el numero correspondiente a la operacion que desea realizar");
                        }
                        break;
                }
            }
        }

    }

    //Main
    public static void main(String[] args) {
        //Instancia de la clase Proyecto1Progra
        Proyecto1Progra pp = new Proyecto1Progra();
        //Llama al metodo Menu Operaciones de la clase Proyecto1Progra
        pp.MenuOperaciones();

    }

}
