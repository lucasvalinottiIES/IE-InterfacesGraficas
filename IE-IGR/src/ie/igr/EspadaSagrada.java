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
public class EspadaSagrada extends Arma{
    public EspadaSagrada(){
        super("Espada Sagrada",10);
    }
    @Override
    public void usarEfectoEspecial(Personaje objetivo) {
        // Cura al portador
        int curacion = 15;
        objetivo.vida += curacion;
        System.out.println(objetivo.nombre + " se cura " + curacion + " puntos con la Espada Sagrada.");
    }
}
