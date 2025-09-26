/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie.igr;

/**
 *
 * @author Usuario
 */
public class Villano extends Personaje { 
        public int Veneno = 0;
        public int Curacion = 0;
        
        public Villano(String apodo, int salud, int ataque, int defensa,int bendicion){
        super(apodo, salud, ataque, defensa, bendicion);
    }
        
     @Override
    public void cargarBendicion() {
        this.bendicion += 10;
        System.out.println(this.apodo + " ha cargado bendición. Bendición actual: " + this.bendicion);
    }
        
    @Override
    public void cargarHabilidad(String habilidad) {
        this.habilidad = habilidad;
        System.out.println(this.apodo + " cargó la habilidad: " + this.habilidad);
    }

    @Override
    public void invocarArma() {
        System.out.println(apodo + " invoca su arma: " + arma);
    }

    @Override
    public void atacar(Personaje enemigo) {
        if (enemigo == null || !estaVivo(enemigo)) return;

        int defensaEnemigo = Math.max(0, enemigo.defensa); 
        int danio = Math.max(0, this.ataque - defensaEnemigo);

        int antes = enemigo.salud;
        enemigo.salud = Math.max(0, enemigo.salud - danio);

        System.out.println(this.apodo + " ataca normalmente. Daño: " + danio +
            ". Salud enemigo: " + antes + " → " + enemigo.salud);
}
}
