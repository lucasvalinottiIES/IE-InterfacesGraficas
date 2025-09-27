/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie.igr;

/**
 *
 * @author Juani
 */
public abstract class Habilidad {
    protected String nombre;
    protected int turnosCarga;

    public Habilidad(String nombre, int turnosCarga) {
        this.nombre = nombre;
        this.turnosCarga = turnosCarga;
    }

    public boolean estaDisponible() {
        return turnosCarga <= 0;
    }

    public abstract void ejecutar(Personaje lanzador, Personaje objetivo);

    public void pasarTurno() {
        if (turnosCarga > 0) {
            turnosCarga--;
        }
    }
}



