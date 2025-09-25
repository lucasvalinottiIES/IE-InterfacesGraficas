/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ie.igr;


public class IEIGR {

    
public abstract class Personaje {

    public String nombre;
    public int vida;
    public int fuerza;
    public int bendicion;
    public String arma;

    public Personaje(String nombre, int vida, int fuerza, int bendicion,String arma) {
        this.nombre = nombre;
        this.vida = vida;
        this.fuerza = fuerza;
        this.bendicion = bendicion;
        this.arma = arma ;
    }

    public boolean estaVivo(Personaje personaje) {
        return personaje.vida > 0;
    }

    public void atacar(Personaje personajeEnemigo) {
        boolean estaVivo = this.estaVivo(personajeEnemigo);
        if (estaVivo) {
            personajeEnemigo.vida = personajeEnemigo.vida - this.fuerza;
        }
    }

    
}
    
}
