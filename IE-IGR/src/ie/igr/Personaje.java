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

    public Personaje(String apodo, int salud, int ataque, int defensa, int bendicion) {
        this.salud = salud;
        this.defensa = defensa;
        this.bendicion = bendicion;
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

      
       
    public void ingresarApodo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresá el apodo: ");
        this.apodo = sc.nextLine();
    }
    
     public boolean validarApodo(String apodo) {
    if (apodo == null || apodo.isEmpty()) {
        System.out.println("El apodo no puede estar vacío.");
        return false;
    }
    if (apodo.length() > 12) {
        System.out.println("El apodo no puede tener más de 12 caracteres.");
        return false;
    }
    if (!apodo.matches("[a-zA-Z0-9]+")) {
        System.out.println("El apodo solo puede contener letras y números.");
        return false;
    }
    // Si pasó todas las pruebas
    this.apodo = apodo;
    System.out.println("Apodo válido: " + apodo);
    return true;
}
   
        


   
}
