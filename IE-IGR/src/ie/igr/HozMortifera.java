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
public class HozMortifera extends Arma {
    
    public HozMortifera(){
        super("Hoz Mortifera",15);
    }
    @Override
    public void usarEfectoEspecial(Personaje objetivo) {
        // Veneno + cura villano
        System.out.println(objetivo.nombre + " ha sido gravemente envenenado.");
        // Para simplificar, no implementamos veneno en turnos
    }
}
