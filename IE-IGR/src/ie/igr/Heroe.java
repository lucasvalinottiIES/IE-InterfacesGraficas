/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie.igr;
public class Heroe extends Personaje {

    public Heroe() {
        super();
    }

    public Heroe(int salud, int defensa, int ataque) {
        super(salud, defensa, ataque);
    }

    @Override
    public void atacar(Personaje heroe, Personaje villano) {

        invocarArma();
        
        if (this.habilidad != null) {
            if(this.habilidad.estaDisponible()){
                this.habilidad.ejecutar(heroe, villano);
                return;
            }else{
                System.out.println("❌ La habilidad " + this.habilidad.nombre + " aún no está lista.");
                this.habilidad.pasarTurno();
            }
        }

        if (arma != null) {
            System.out.println("✨ " + GetApodo() + " utiliza el efecto especial de " + arma.getNombre() + "!");
            arma.usarEfectoEspecial(this); // ✅ ahora aplicamos el efecto AL ENEMIGO
        }

        int danoBase = this.ataque - villano.defensa;
        if (danoBase < 0) {
            danoBase = 0;
        }

        if (Math.random() < 0.2) {
            danoBase *= 2; // aumenta el daño en un 50%
            this.bendicion += 10;
            System.out.println("🔥 ¡ATAQUE CRÍTICO! El daño aumenta a " + danoBase + " puntos! Y gana 10% mas de bendicion celestial.");
        }

        villano.recibirDano(danoBase);
        if (villano.GetSalud() < 0) {
            villano.salud = 0;
        }
        System.out.println("🗡️ " + this.GetApodo() + " ataca a " + villano.GetApodo() + " causando " + danoBase + " de daño.");
        cargarBendicion();

    }

    @Override
    public void invocarArma() {
        if (bendicion >= 100 && habilidad == null) {
            System.out.println("⚡ " + GetApodo() + " ha alcanzado el 100% de bendición. ¡Puede usar su habilidad suprema!");
            cargarHabilidad();
            return; // 👈 no seguimos con armas si ya tiene habilidad
        }

        // 🗡️ Invocar Espada Simple (solo si no hay arma)
        if (bendicion >= 20 && arma == null) {
            arma = new EspadaSimple(this);
            System.out.println("🔮 " + GetApodo() + " invoca " + arma.getNombre() + "!");
        } // 🗡️ Evoluciona a Espada Sagrada (solo si la actual es Simple)
        else if (bendicion >= 40 && arma != null && arma.getNombre().equals("Espada Simple")) {
            arma = new EspadaSagrada(this);
            System.out.println("🔮 " + GetApodo() + " invoca " + arma.getNombre() + "!");
        } // 🗡️ Evoluciona a Espada Celestial (solo si la actual es Sagrada)
        else if (bendicion >= 70 && arma != null && arma.getNombre().equals("Espada Sagrada")) {
            arma = new EspadaCelestial(this);
            System.out.println("🔮 " + GetApodo() + " invoca " + arma.getNombre() + "!");
        }
    }

    @Override
    public void cargarBendicion() {
        int incremento = 10;
        bendicion += incremento;
        if (bendicion > 100) {
            bendicion = 100;
        }

        System.out.println("✨ " + GetApodo() + " aumenta su bendición a " + bendicion + "%.");
    }

    @Override
    public void cargarHabilidad() {
        if (bendicion >= 100) {
            habilidad = new CastigoBendito();
            System.out.println("🌟 ¡" + GetApodo() + " desbloqueó su habilidad suprema: " + habilidad.nombre + "!");
        }
    }
}