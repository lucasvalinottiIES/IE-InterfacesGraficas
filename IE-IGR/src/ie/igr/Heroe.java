/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie.igr;

public class Heroe extends Personaje {

    private int defensaExtra = 0;
    private int turnosDefensa = 0;

    public Heroe(String apodo, int salud, int ataque, int defensa, String habilidad, int bendicion, String arma) {
        super(apodo, salud, ataque, defensa, habilidad, bendicion, arma);
    }

    @Override
    public void invocarArma() {
        System.out.println(this.apodo + " invoca su arma: " + this.arma);
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

    // Curación propia
    public void curar(int puntos) {
        if (puntos > 0) {
            this.salud += puntos;
            System.out.println(this.apodo + " se curó " + puntos + " puntos de vida.");
        }
    }

    // Defensa especial
    public void activarDefensa(int extra, int turnos) {
        this.defensaExtra = extra;
        this.turnosDefensa = turnos;
        System.out.println(this.apodo + " activó defensa extra de +" + extra +
                           " por " + turnos + " turnos.");
    }

    // Método propio de Heroe (NO @Override)
    public int defensaActual() {
        // No decremento turnos acá; que se haga cuando corresponda en tu flujo
        if (this.turnosDefensa > 0) {
            return this.defensa + this.defensaExtra;
        }
        return this.defensa;
    }
}
