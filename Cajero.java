/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1.progra;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Felipe
 */
public class Cajero extends Persona {
    //Variables
    int saldo;
    private ArrayList<Cajero> ListCajero = new ArrayList();
    private ArrayList<String> ListLogs = new ArrayList();
    Random r = new Random();
    //Constructor 1
    public Cajero() {

    }
    //Constructor 2
    public Cajero(String Nombre, String Apellido1, String Apellido2, int Cedula, int Telefono, String Direccion) {
        super(Nombre, Apellido1, Apellido2, Cedula, Telefono, Direccion);

    }

    //Operacion para el cierre de la cuenta del cliente
    public boolean Cierre(Cliente c) {
        //Valida si posee cuenta bancaria o no
        if (c.isCuentaBancaria() == true) {
            //Si posee cuenta bancaria la cierra
            c.setCuentaBancaria(false);
            //Vuelve el saldo a 0, ya que sin cuenta no hay fondos
            c.setSaldo(0);
            //Imprime el resultado del cierre de la cuenta cliente
            System.out.println("\nSe ha cerrado la cuenta para " + c.getNombre() + " " + c.getApellido1());
            return true;
        } else {
            //Si no posee cuenta bancaria no se puede cerrar algo inexistente
            System.out.println("\nNo existe una cuenta para este Cliente, por lo que no se puede procesar esta operacion");
            return false;
        }
    }
    //Operacion para la apertura de la cuenta del cliente

    public boolean Apertura(Cliente c) {
        //Valida si posee cuenta bancaria o no
        if (c.isCuentaBancaria() == true) {
            //Si posee cuenta bancaria no se puede abrir otra
            System.out.println("\nYa posee una cuenta bancaria, elija otra opcion del menu");
            return false;
        //Si no posee cuenta bancaria    
        } else {
            //Se setea la cuenta bancaria del cliente a verdadero
            c.setCuentaBancaria(true);
            //Se setea el saldo a 0 ya que es una cuenta nueva
            c.setSaldo(0);
            //Se imprime el resultado de la apertura de la cuenta
            System.out.println("\nSe ha abierto una cuenta para " + c.getNombre() + " " + c.getApellido1());
            return true;
        }
    }

    //Operacion para añadir credito a la cuenta del cliente
    public boolean Credito(Cliente c, int credito) {
        //Se valida si el credito a introducir en la cuenta es menor o igual a 0
        if (credito <= 0) {
            //Imprime la validacion
            System.out.println("No se puede introducir a la cuenta un saldo menor o igual a 0");
            return false;
        // si el credito es diferente a negativo y a cero     
        } else {
            // Saca el saldo actual del cliente
            saldo = c.getSaldo();
            //Imprime el saldo actual del cliente
            System.out.println("Saldo actual de: " + c.getSaldo());
            // Suma el saldo actual mas el credito que se agregara
            saldo = saldo + credito;
            // Se setea el SetSaldo con el valor total de la operacion anterior
            c.setSaldo(saldo);
            //Se llama nuevamente al saldo para imprimirlo
            saldo = c.getSaldo();
            //Se imprime el total del saldo
            System.out.println("Credito a añadir: " + credito + "\nSu nuevo saldo es de: " + saldo);
            return true;
        }

    }

    //Operacion para retirar de la cuenta del cliente
    public boolean Retiro(Cliente c, int retiro) {
        //Se valida si el saldo es menor o igual a 0
        if (c.getSaldo() <= 0) {
            //Imprime la validacion
            System.out.println("No se puede retirar de esta cuenta por falta de saldo!");
            return false;
        } else {
            //Pone en la variable saldo el saldo actual
            saldo = c.getSaldo();
            //Imprime saldo actual
            System.out.println("Saldo actual de: " + c.getSaldo());
            //Valida si el retiro es mayor al saldo actual
            if (saldo < retiro) {
                //Imprime validacion
                System.out.println("El retiro que desea realizar es mas grande que su saldo en la cuenta");
                return false;
            //Si el retiro no es mayor al saldo actual    
            } else {
                //Se rebaja el retiro al saldo actual del cliente 
                saldo = saldo - retiro;
                // Se setea el nuevo saldo
                c.setSaldo(saldo);
                // Se agarra nuevamente la variable saldo para imprimr el nuevo saldo
                saldo = c.getSaldo();
                //Imprime el nuevo saldo
                System.out.println("Retiro de saldo solicitado:" + retiro + "\nSu nuevo saldo es de: " + saldo);
                return true;
            }

        }

    }

    //Metodo de la creacion de persona de cajero
    public void CreaCajero() {
        //Se crean Cajeros y se añaden a la lista de cajeros
        Cajero cajero1 = new Cajero("Carlos", "Sequeira", "Esquivel", 11536974, 83215552, "San Pedro");
        ListCajero.add(cajero1);
        Cajero cajero2 = new Cajero("Pedro", "Perez", "Fonseca", 13246598, 86541235, "San Antonio");
        ListCajero.add(cajero2);
        Cajero cajero3 = new Cajero("Julia", "Lopez", "Gomez", 14536589, 84513528, "Escazu");
        ListCajero.add(cajero3);
        Cajero cajero4 = new Cajero("Karla", "Rodriguez", "Vindas", 16535932, 81235484, "San Rafael");
        ListCajero.add(cajero4);
        Cajero cajero5 = new Cajero("Juan", "Fernandez", "Picado", 29746325, 71324586, "Guadalupe");
        ListCajero.add(cajero5);
    }

    //Asigna aleatoriamente un cajero a un cliente
    public boolean AsignaCajero(Cliente c) {
        //Valida si la lista de cajeros esta vacia
        if (ListCajero.isEmpty()) {
            return false;
        // Si no esta vacia    
        } else {
            //Se declara un numero random con respecto al tamaño de la lista
            int random = r.nextInt(ListCajero.size());
            //Se declara una variable de tipo Cajero y guarda el objeto random de la lista de cajeros
            Cajero caj = ListCajero.get(random);
            //Se imprime el objeto random
            System.out.println("\nCajero asignado: " + caj + "\nCliente a atender: " + c.getNombre() + " " + c.getApellido1() + " " + c.getApellido2() + "\nCedula :" + c.getCedula() + "\n");
            return true;
        }
    }

    //Imprime informacion del cliente a atender   
    public void SolicitaInfoCliente(Cliente c) {
        //Imprime informacion del cliente
        System.out.println("\nCual es su nombre: " + c.getNombre() + "\nCual es su apellido: " + c.getApellido1() + "\nCual es su cedula: " + c.getCedula() + "\nCual es su Banco: " + c.getNombreBanco());
    }

    //Agrega las operaciones realizadas por el cliente a la lista de Logs
    public void Log(String Log) {
        ListLogs.add(Log);
    }

    //Imprime lo que hay en la Lista del Log
    public void ImprimeLog() {
        //Valida si la lista de logs esta vacia
        if (ListLogs.isEmpty()) {
            //Imprime la validacion si esta vacia
            System.out.println("\nNo se ha hecho ninguna operacion para el cliente");
        // Si la lista no esta vacia    
        } else {
            //Recorre la lista de logs
            for (int x = 0; x < ListLogs.size(); x++) {
                //Imprime todo lo que hay en la lista
                System.out.println(ListLogs.get(x));
            }
        }

    }

    //Sobreescribe el metodo ToString para una impresion personalizada del Cajero
    @Override
    public String toString() {
        return this.getNombre()
                + " " + this.getApellido1()
                + " " + this.getApellido2()
                + "\nCedula: " + this.getCedula();
    }
}
