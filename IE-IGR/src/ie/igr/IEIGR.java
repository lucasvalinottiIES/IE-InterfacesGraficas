/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ie.igr;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author Usuario
 */
public class IEIGR {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
     boolean jugando = true;
        Historial historial = new Historial();
        
        while (jugando) {        
            
            Object[] info = jugar();
           
            historial.guardarBatalla(info);
            
            Heroe heroe = (Heroe) info[0];
            Villano villano = (Villano) info[1];
            
            historial.reporte(heroe, villano);
            historial.mostrarHistorial(); 
            
            jugando = false;
            
            if (!jugando) {
                jugando = jugarDeNuevo();
            }
        }
        System.out.println("Gracias por jugar");
    }

    public static Object[] jugar(){        
            Object[] personajes = getInfo();
            Heroe heroe = (Heroe) personajes[0];
            Villano villano = (Villano) personajes[1];  

            Batalla batalla = new Batalla(heroe, villano);
            batalla.mostrarEstado();
            Object[] info = batalla.iniciarBatalla();
            return info;
    }
    
    public static Object[] getInfo(){
        int saludHeroe = validarInput("Salud Heroe");
        int defensaHeroe = validarInput("Defensa Heroe");
        int ataqueHeroe = validarInput("Ataque Heroe");
        int saludVillano = validarInput("Salud Villano");
        int defensaVillano = validarInput("Defensa Villano");
        int ataqueVillano = validarInput("Ataque Villano");
        
        Heroe heroe = new Heroe(saludHeroe, defensaHeroe, ataqueHeroe);
        Villano villano = new Villano(saludVillano, defensaVillano, ataqueVillano);
        
        System.out.println("Apodo Heroe");
        heroe.ingresarApodo();
        System.out.println("Apodo Villano");
        villano.ingresarApodo();
    
        return new Object[]{heroe, villano};
    }
   
    public static int validarInput(String atributo) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print("Ingrese " + atributo + ":");
                numero = sc.nextInt();
                valido = true; 
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número entero.");
                sc.nextLine(); 
            }
        }

        return numero;
    }

    public static boolean jugarDeNuevo(){
        boolean jugarDeNuevo = false;
        
        Scanner sc = new Scanner(System.in);
        int opcion;
        boolean valido = false;
        System.out.print("Desea jugar de nuevo????");
        while (!valido) {
            try {
                System.out.print("Ingrese 1(Si) o 0 (No) :");
                opcion = sc.nextInt(); 
                if (opcion == 1) {valido = true; jugarDeNuevo = true;}
                else if (opcion == 0){valido = true; jugarDeNuevo = false;}
                else {System.out.println("Error: debe ingresar 1 (Si) o 0 (No."); valido = false;}
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar 1 (Si) o 0 (No).");
                sc.nextLine();
            }
        }

        return jugarDeNuevo;
    }
}
