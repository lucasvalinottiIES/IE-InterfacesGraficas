/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie.igr;

/**
 *
 * @author Juani
 */
public class LeviatanDelVacio extends Habilidad {
    private int turnoDeInvocacion = -1;

    public LeviatanDelVacio() {
        super("Leviatán del Vacío");
    }

    @Override
    public int activar(Personaje usuario, Personaje enemigo, int turnoActual) {
        if (usuario.getBendicion() == 100) {
            if (turnoDeInvocacion == -1) {
                turnoDeInvocacion = turnoActual;
                System.out.println(usuario.getNombre() + " comienza a invocar al " + nombre + "!");
                return 0;
            } else if (turnoActual - turnoDeInvocacion >= 3) {
                int danio = enemigo.getVida();
                enemigo.recibirDanio(danio);

                int veneno = -15;
                enemigo.aplicarEstado("veneno", 3);

                System.out.println(nombre + " emerge y hace " + danio + " de daño + veneno (" + veneno + ").");
                turnoDeInvocacion = -1;
                usuario.resetearBendicion();
                return veneno;
            } else {
                System.out.println(nombre + " aún se está invocando... faltan "
                                   + (3 - (turnoActual - turnoDeInvocacion)) + " turnos.");
                return 0;
            }
        }
        System.out.println("No se puede invocar al " + nombre + " (bendición insuficiente).");
        return 0;
    }
}

