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
public class EspadaCelestial extends Arma{
    public EspadaCelestial(){
        super("Espada Celestial", 15);
    }
    @Override
    public void usarEfectoEspecial(Personaje objetivo) {
        // Cura y da defensa extra (buff)
        int curacion = 20;
        int defensaExtra = 5;
        objetivo.vida += curacion;
        objetivo.defensa += defensaExtra;
        System.out.println(objetivo.nombre + " se cura " + curacion + " y gana " + defensaExtra + " de defensa con la Espada Celestial.");
    }
}
