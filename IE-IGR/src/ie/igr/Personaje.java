/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie.igr;

import java.util.Scanner;

/**
 *
 * @author agusn
 */
public abstract class Personaje {

    public String apodo;
    public int salud;
    public int defensa;
    public int bendicion;
    public String arma;
    public String habilidad;
    public int ataque;

    public Personaje(String apodo, int salud, int ataque, int defensa, String habilidad, int bendicion, String arma) {
        this.apodo = apodo;
        this.salud = salud;
        this.defensa = defensa;
        this.bendicion = bendicion;
        this.arma = arma;
        this.habilidad = habilidad;
        this.ataque = ataque;
    }

    public boolean estaVivo(Personaje personaje) {
        return personaje.salud > 0;
    }

    public void atacar(Personaje personajeEnemigo) {
        boolean estaVivo = this.estaVivo(personajeEnemigo);
        if (estaVivo) {
            personajeEnemigo.salud = personajeEnemigo.salud - this.ataque;
        }
    }
    
      public abstract void invocarArma();
      public abstract void cargarBendicion();
      public abstract void cargarHabilidad(String habilidad);

      
       
    public boolean validarApodo(String apodo) {
        if (apodo == null || apodo.isEmpty()) {
            System.out.println("El apodo no puede estar vacío.");
            return false;
        }
        if (apodo.length() < 3 || apodo.length() > 10) {
            System.out.println("El apodo debe tener entre 3 y 10 caracteres.");
            return false;
        }
        if (!apodo.matches("[a-zA-Z ]+")) {
            System.out.println("El apodo solo puede contener letras y espacios.");
            return false;
        }
        return true;
    }

    // Método para ingresar apodo por consola
    public void ingresarApodo() {
        Scanner sc = new Scanner(System.in);
        String entrada;
        do {
            System.out.print("Ingresá tu apodo: ");
            entrada = sc.nextLine();
        } while (!validarApodo(entrada));
        this.apodo = entrada;
        System.out.println("Apodo válido asignado: " + this.apodo);
    }
   
        


   
}
