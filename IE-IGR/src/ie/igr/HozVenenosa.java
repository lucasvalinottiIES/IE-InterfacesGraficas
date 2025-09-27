/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie.igr;

import ie.igr.Arma;

/**
 *
 * @author Alumno
 */
public class HozVenenosa extends Arma{
    public HozVenenosa(){
        super("Hoz Venenosa",10);
    }
    @Override
    public void usarEfectoEspecial(Personaje objetivo) {
        // Aplica veneno (pierde 5 vida extra en los próximos 2 turnos)
        System.out.println(objetivo.nombre + " ha sido envenenado.");
        // Para simplificar, se podría implementar un sistema de veneno en batalla (no hecho aquí)
    }
}
