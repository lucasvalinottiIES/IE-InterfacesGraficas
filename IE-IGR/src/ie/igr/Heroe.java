/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie.igr;
public class Heroe extends Personaje {

    public Heroe(String apodo, int salud, int ataque, int defensa, String habilidad, int bendicion, String arma) {
    super(apodo, salud, ataque, defensa, habilidad, bendicion, arma);
}

    @Override
    public void invocarArma() {
        System.out.println(this.apodo + " invoca su arma: " + this.arma);
    }
    @Override public void cargarBendicion(){}
    @Override public void cargarHabilidad(){}

    // Ataque especial CastigoBendito
    public void usarCastigoBendito(Personaje enemigo) {
        if (!"CastigoBendito".equalsIgnoreCase(this.habilidad)) {
            System.out.println(this.apodo + " no tiene CastigoBendito cargado.");
            return;
        }

        int defensaEnemigo = enemigo.defensa; // Personaje lo tiene público
        int danio = (this.ataque * 2) + this.bendicion - defensaEnemigo;
        if (danio < 0) danio = 0;

        enemigo.salud -= danio;
        int curacion = Math.max(1, danio / 5); // 20% del daño
        this.salud += curacion;

        System.out.println(this.apodo + " usó CastigoBendito: infligió " + danio +
                           " y se curó " + curacion);
        
    }
    
}