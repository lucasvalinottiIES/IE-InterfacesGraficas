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

    public Habilidad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Activa la habilidad.
     * @param usuario El personaje que la usa
     * @param enemigo El personaje objetivo
     * @param turnoActual El turno en curso (necesario para Leviatán)
     * @return Valor adicional del efecto (ej: curación positiva, veneno negativo, 0 si no aplica)
     */
    public abstract int activar(Personaje usuario, Personaje enemigo, int turnoActual);
}



