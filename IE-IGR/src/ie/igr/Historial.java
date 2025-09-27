/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie.igr;

/**
 *
 * @author Benja
 */
public class Historial {
    private StringBuilder sbHistorial = new StringBuilder();
    private  int lineas = sbHistorial.toString().split("\\.").length;
    public void guardarBatalla(Object[] info) {
        Heroe heroe = (Heroe) info[0];
        Villano villano = (Villano) info[1];
        String ganador = (String) info[2];
        int turnos = (int) info[3];
        
        String batalla;
        if (lineas <= 5) {
            batalla = "BATALLA # " + lineas + " | Heroe: " + heroe.GetApodo() + " | Villano: " + villano.GetApodo() + " | Ganador: " + ganador + " | Turnos: " + turnos + ". \n";
            sbHistorial.append(batalla);
            lineas ++;
        } else {
            batalla = "BATALLA # " + lineas + " | Heroe: " + info[0] + " | Villano: " + info[1] + " | Ganador: " + info[2] + " | Turnos: " + info[3] + ". \n";
            sbHistorial.delete(0, batalla.length() - 1);
            sbHistorial.append(batalla);
            lineas ++;
        }
    }

    public void mostrarHistorial() {
        System.out.println("--------HISTORIAL RECIENTE--------");
        System.out.println(sbHistorial.toString());
    }
    
    public void reporte(Heroe heroe, Villano villano){
        String armasUsadasHeroe = validarArmas(heroe.getArmasInvocadas());
        String armasUsadasVillano = validarArmas(villano.getArmasInvocadas());
        
        System.out.println("===============================================");
        System.out.println("          REPORTE FINAL DE LA BATALLA          ");
        System.out.println("===============================================");
        System.out.println("Heroe: apodo " + heroe.GetApodo()+ " - Vida final: " + heroe.GetSalud());
        System.out.println("Villano: apodo " + villano.GetApodo()+ " - Vida final: " + villano.GetSalud());

        System.out.println("\n");        
        
        System.out.println("----> ARMAS INVOCADAS <----");
        System.out.println(heroe.GetApodo() + " " + armasUsadasHeroe) ;
        System.out.println(villano.GetApodo() + " " + armasUsadasVillano) ;
        
        System.out.println("\n");  
        
        System.out.println("----> ATAQUES ESPECIALES <----");
        
        if (heroe.getHabilidadesUsadas() >= 1) System.out.println(heroe.GetApodo() + "activó \"Castigo Bendito\" " + "( " + heroe.getHabilidadesUsadas() + " )") ;
        else System.out.println(heroe.GetApodo() + " no activo la habilidad especial") ;
        
        if (villano.getHabilidadesUsadas() >= 1)System.out.println(villano.GetApodo() + "activó \"Leviatán del Vacío\" " + "( " + villano.getHabilidadesUsadas() + " )") ;
        else System.out.println(villano.GetApodo() + " no activo la habilidad especial");
        
        System.out.println("\n");  
    }
    private String validarArmas(String[] armasUsadas){
        String armas = "";
        if(armasUsadas[0] != null)armas += armasUsadas[0] + ", ";
        if(armasUsadas[1] != null)armas += armasUsadas[1] + ", ";
        if(armasUsadas[2] != null)armas += armasUsadas[2] + ".";
        
        if (armas == null) armas = "No se invoco nigun arma";
        return armas;
    }
}
