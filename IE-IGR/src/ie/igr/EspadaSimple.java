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
public class EspadaSimple extends Arma {
    
    public EspadaSimple(){
        super("Espada Simple",5);
    }
    @Override
    public void usarEfectoEspecial(Personaje objetivo) {
        // Solo daño extra
    }
}
