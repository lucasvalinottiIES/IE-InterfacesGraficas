/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie.igr;

/**
 *
 * @author Juani
 */
public class LeviatanDelVacio extends Habilidad{
    public LeviatanDelVacio() {
        super("Leviatán del Vacío", 3); // necesita 3 turnos de carga
    }

    @Override
    public void ejecutar(Personaje lanzador, Personaje objetivo) {

        // Daño = 100% de la salud actual del héroe
        int dano = objetivo.GetSalud();
        objetivo.recibirDano(dano);
        if (objetivo.GetSalud() < 0) {
            objetivo.salud = 0;
        }

        System.out.println("🌌 " + lanzador.GetApodo() + " invoca al " + nombre + "!");
        System.out.println("💀 El Leviatán desata su furia e inflige " + dano + " puntos de daño a " + objetivo.GetApodo() + ".");

        
        this.turnosCarga = 3;
    }
}

