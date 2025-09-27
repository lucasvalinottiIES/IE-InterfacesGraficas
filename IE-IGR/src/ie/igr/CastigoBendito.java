/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie.igr;

/**
 *
 * @author Juani
 */
public class CastigoBendito extends Habilidad{
    public CastigoBendito() {
        super("Castigo Bendito", 0); // se puede usar inmediatamente al 100%
    }

    @Override
    public void ejecutar(Personaje lanzador, Personaje objetivo) {
        int dano = lanzador.GetSalud() / 2; // 50% de la vida actual del héroe
        objetivo.recibirDano(dano);
        
        objetivo.recibirDano(dano);
        if (objetivo.GetSalud() < 0) {
            objetivo.salud = 0;
        }
        
        

        System.out.println("⚡ " + lanzador.GetApodo() + " lanza " + nombre + "!");
        System.out.println("💥 El rayo divino inflige " + dano + " puntos de daño directo a " + objetivo.GetApodo() + ".");
        
        // La bendicion vuelve a la mitad despues de lanzarlo
        lanzador.bendicion = 50;
        System.out.println("💥 El rayo divino reduce la bendicion del heroe al 50%");
        lanzador.habilidad = null;
        
    }
}
