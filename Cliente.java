/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1.progra;

import java.util.Scanner;

/**
 *
 * @author Felipe
 */
public class Cliente extends Persona {

    //Variables
    private boolean cuentaBancaria;
    private String nombreBanco;
    private int saldo = 0;
    //Variables para guardar el scan
    Scanner scan = new Scanner(System.in);
    String nombre;
    String apellido1;
    String apellido2;
    int cedula;
    int telefono;
    String direccion;
    String banco;

    //Constructor 1
    public Cliente() {
    }

    //Constructor 2
    public Cliente(String Nombre, String Apellido1, String Apellido2, int Cedula, int Telefono, String Direccion, boolean CuentaBancaria, String NombreBanco, int Saldo) {
        super(Nombre, Apellido1, Apellido2, Cedula, Telefono, Direccion);
        this.cuentaBancaria = CuentaBancaria;
        this.nombreBanco = NombreBanco;
        this.saldo = Saldo;
    }

    //Muestra la informacion del cliente
    public void MuestraCliente() {
        //Se declara una variable string
        String f;
        //Si posee una cuenta o no
        if (isCuentaBancaria() == true) {
            //Si posee cuenta, como es boolean, para imprimr se pone en la variable declarada anteriormente 
            f = "Si";
            //Si no posee cuenta    
        } else {
            ////Si no posee cuenta, como es boolean, para imprimr se pone en la variable declarada anteriormente 
            f = "No";
        }
        //Se imprime el cliente
        System.out.println("Nombre: " + getNombre() + "\nPrimero Apellido: " + getApellido1() + "\nSegundo Apellido: " + getApellido2() + "\nCedula: " + getCedula() + "\nTelefono: " + getTelefono() + "\nDireccion: " + getDireccion() + "\nNombre del Banco: " + getNombreBanco() + "\nPosee cuenta bancaria: " + f + "\nSaldo: " + getSaldo());
    }

    //Se crea un nuevo cliente a partir de lo digitado por el usuario
    public void CreaCliente() {
        //Mensaje de bienvenida
        System.out.println("Vamos a crear al cliente\n");
        //Se pregunta al usuario el nombre de cliente
        System.out.println("Nombre del cliente: ");
        //Se registra en la variable nombre lo escrito por el usuario
        nombre = scan.nextLine();
        //Se setea la variable nombre
        this.setNombre(nombre);

        //Se pregunta al usuario el primer apellido de cliente
        System.out.println("Primer apellido: ");
        //Se registra en la variable apellido1 lo escrito por el usuario
        apellido1 = scan.nextLine();
        //Se setea la variable apellido1
        this.setApellido1(apellido1);

        //Se pregunta al usuario el segundo apellido de cliente
        System.out.println("Segundo apellido: ");
        //Se registra en la variable apellido2 lo escrito por el usuario
        apellido2 = scan.nextLine();
        //Se setea la variable apellido2
        this.setApellido2(apellido2);

        //Se pregunta al usuario la cedula del cliente
        System.out.println("Numero de cedula: ");
        //Se registra en la variable cedula lo escrito por el usuario
        cedula = Integer.parseInt(scan.nextLine());
        //Se valida si es numerico o no lo digitado por el usuario
        if (this.IsNumeric(String.valueOf(cedula)) == true) {
            //Si es numero se setea la cedula con lo digitado
            this.setCedula(cedula);
        }

        //Se pregunta al usuario el telefono del cliente
        System.out.println("Numero de telefono: ");
        //Se registra en la variable telefono lo escrito por el usuario
        telefono = Integer.parseInt(scan.nextLine());
        //Se valida si es numerico o no lo digitado por el usuario
        if (this.IsNumeric(String.valueOf(telefono)) == true) {
            //Si es numero se setea el numero de telefono con lo digitado
            this.setTelefono(telefono);
        }

        //Se pregunta al usuario la direccion del cliente
        System.out.println("Direccion: ");
        //Se registra en la variable direccion lo escrito por el usuario
        direccion = scan.nextLine();
        //Se setea direccion
        this.setDireccion(direccion);

        //Se pregunta al usuario el banco del cliente
        System.out.println("Cual es su banco: ");
        //Se registra en la variable banco lo escrito por el usuario
        banco = scan.nextLine();
        //Se setea banco
        this.setNombreBanco(banco);

        //Se pregunta si posee cuenta bancaria o no
        System.out.println("Posee cuenta bancaria? Digite 1 para SI y 2 para NO: ");
        //Se declara una variable contadora
        int conta;
        //Se guarda en la variable conta lo digitado por el usuario
        conta = Integer.parseInt(scan.nextLine());
        //Se valida que lo digitado sea un numero
        if (this.IsNumeric(String.valueOf(conta)) == true) {
            //Mientras que lo digitado por el usuario no sea ni uno ni 2 se sigue en la iteracion
            while (conta > 2 || conta <= 0) {
                //Se vuelve a preguntar al usuario que solo se puede digitar 1 o 2
                System.out.println("Solo se debe digitar 1 para SI o 2 para NO");
                //Vuelve a guardar en la variable lo digitado por el usuario
                conta = Integer.parseInt(scan.nextLine());
            }
            //Switch Case con respecto a la variable digitada (1 o 2)
            switch (conta) {
                //En caso de que la variable digitada sea 1
                case 1:
                    //Se setea la cuenta bancaria a verdadera
                    this.setCuentaBancaria(true);
                    break;
                case 2:
                    //Se setea la cuenta bancaria a falso
                    this.setCuentaBancaria(false);
                    break;
                //En caso de no se ni 1 ni 2    
                default:
                    // Mensaje
                    System.out.println("Solo se acepta el numero 1 o numero 2");
                    break;

            }
        }

    }

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

    /**
     * @return the cuentaBancaria
     */
    public boolean isCuentaBancaria() {
        return cuentaBancaria;
    }

    /**
     * @param cuentaBancaria the cuentaBancaria to set
     */
    public void setCuentaBancaria(boolean cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    /**
     * @return the nombreBanco
     */
    public String getNombreBanco() {
        return nombreBanco;
    }

    /**
     * @param nombreBanco the nombreBanco to set
     */
    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    /**
     * @return the saldo
     */
    public int getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

}
