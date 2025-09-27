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

        Batalla batalla = new Batalla(heroe, villano);
        batalla.mostrarEstado();
        batalla.iniciarBatalla();
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

}
