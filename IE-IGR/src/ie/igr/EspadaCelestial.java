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
    public EspadaCelestial(Personaje heroe){
        super("Espada Celestial", 10);
        heroe.incrementarAtaque(danioExtra);
        System.out.println(this.nombre + " brinda " + danioExtra + " de puntos de ataque.");
    }
    
    @Override
    public void usarEfectoEspecial(Personaje portador){
        int curacion = 8;
        int incrementoDefensa = 3;
        portador.curarse(curacion);
        portador.incrementarDefensa(incrementoDefensa);
        System.out.println(this.nombre + " se cura " + curacion + " puntos de vida.");
        System.out.println(this.nombre + " incrementa su defensa en: " + incrementoDefensa + " puntos.");
    }
}
