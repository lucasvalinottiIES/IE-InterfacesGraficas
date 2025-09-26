/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie.igr;

/**
 *
 * @author Juani
 */
public class CastigoBendito extends Habilidad {

    public CastigoBendito() {
        super("Castigo Bendito");
    }

    @Override
    public int activar(Personaje usuario, Personaje enemigo, int turnoActual) {
        if (usuario.getBendicion() == 100) {
            int danio = usuario.getVida() / 2;
            enemigo.recibirDanio(danio);

            int curacion = 20;
            usuario.recibirCuracion(curacion);

            System.out.println(usuario.getNombre() + " activa " + nombre +
                               " inflige " + danio + " de daño y se cura " + curacion + " puntos.");
            usuario.resetearBendicion();
            return curacion;
        }
        System.out.println("No se puede activar " + nombre + " (bendición insuficiente).");
        return 0;
    }
}
