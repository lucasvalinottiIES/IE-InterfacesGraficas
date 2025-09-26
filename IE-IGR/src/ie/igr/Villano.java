/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie.igr;

/**
 *
 * @author Usuario
 */
public class Villano extends Personaje {
        public String HabilidadLeviatan ="LeviatanDelVacio";
        public int TurnosLeviatan = 3;
        public boolean leviatanInvocado = false;
        public int turnosRestantes = 0;
        
        public int Veneno = 0;
        public int Curacion = 0;
        
        public Villano(String apodo, int salud, int ataque, int defensa,int bendicion){
        super(apodo, salud, ataque, defensa, bendicion);
    }

    @Override
    public void invocarArma() {
        System.out.println(apodo + " invoca su arma: " + arma);
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
    
    public void procesarEfectosDeTurno(Personaje enemigo) {
        if (enemigo == null || !estaVivo(enemigo)) return;
        
        // 1) (Futuro) Efectos de Habilidad (veneno, maldición, etc.)
        // TODO (cuando tengas la clase Habilidad):
        // Habilidad obj = this.getHabilidad();  // si cambiás String → Habilidad
        // if (obj != null) obj.aplicarEfectosInicioTurno(this, enemigo);
        
        if (HabilidadLeviatan.equalsIgnoreCase(this.habilidad)) {
            if (!leviatanInvocado) {
                leviatanInvocado = true;
                turnosRestantes = TurnosLeviatan;
                System.out.println(this.apodo + " invoca a Leviatán. Casteo: " + turnosRestantes + " turnos.");
            } else {
                if (turnosRestantes > 0) {
                    turnosRestantes--;
                    System.out.println("Leviatán casteando... Restan " + turnosRestantes + " turnos.");
                }
                if (turnosRestantes == 0) {
                    usarLeviatanDelVacio(enemigo);
                }
            }
        }
    }

    
    @Override
    public void atacar(Personaje enemigo) {
        if (enemigo == null || !estaVivo(enemigo)) return;

        int defensaEnemigo = Math.max(0, enemigo.defensa); 
        int danio = Math.max(0, this.ataque - defensaEnemigo);

        int antes = enemigo.salud;
        enemigo.salud = Math.max(0, enemigo.salud - danio);

        System.out.println(this.apodo + " ataca normalmente. Daño: " + danio +
            ". Salud enemigo: " + antes + " → " + enemigo.salud);
}

    public int usarLeviatanDelVacio(Personaje enemigo) {
        if (enemigo == null) return 0;
        if (!HabilidadLeviatan.equalsIgnoreCase(this.habilidad)) {
            System.out.println(this.apodo + " no tiene LeviatanDelVacio cargado.");
            return 0;
        }
        if (!leviatanInvocado || turnosRestantes != 0) {
            System.out.println("Leviatán aún no terminó de castear.");
            return 0;
        }

        int danio = enemigo.salud;
        enemigo.salud = 0;
        leviatanInvocado = false; 

        System.out.println("¡" + this.apodo + " desata a Leviatán del Vacío! Daño: " + danio +
                ". " + (enemigo.apodo != null ? enemigo.apodo : "El héroe") + " queda en 0.");

        return danio;
    }
        
    public int defensaActual() {
        return Math.max(0, this.defensa);
    }
}
