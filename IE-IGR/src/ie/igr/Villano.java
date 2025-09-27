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

    public Villano(int salud, int defensa, int ataque) {
        super(salud, defensa, ataque);
    }

    // ✅ Ataque del villano: invoca hoz, aplica efecto, luego ataca
    @Override
    public void atacar(Personaje villano, Personaje heroe) {

        invocarArma();

        if (this.habilidad != null) {
            if (this.habilidad.estaDisponible()) {
                this.habilidad.ejecutar(villano, heroe);
                return;
            } else {
                System.out.println("❌ La habilidad " + this.habilidad.nombre + " aún no está lista. Restan " + this.habilidad.turnosCarga + " turnos.");
                this.habilidad.pasarTurno();
            }
        }

        if (arma != null) {
            System.out.println("☠️ " + GetApodo() + " activa el efecto especial de " + arma.getNombre() + "!");
            arma.usarEfectoEspecial(this); // 💥 efecto negativo sobre el héroe
        }

        int danoBase = this.ataque - heroe.defensa;
        if (danoBase < 0) {
            danoBase = 0;
        }

        // 20% de probabilidad de crítico
        if (Math.random() < 0.2) {
            danoBase *= 2; // aumenta el daño en un 50%
            this.bendicion += 10;
            System.out.println("🔥 ¡ATAQUE CRÍTICO! El daño aumenta a " + danoBase + " puntos! Y gana 10% mas de energía del vacío.");
        }

        heroe.recibirDano(danoBase);
        if (heroe.GetSalud() < 0) {
            heroe.salud = 0;
        }
        System.out.println("⚔️ " + this.GetApodo() + " ataca a " + heroe.GetApodo() + " causando " + danoBase + " de daño.");

        // 4️⃣ Incrementar maldición tras el ataque
        cargarBendicion();
    }

    // ✅ Invoca la hoz según el porcentaje de bendición
    @Override
    public void invocarArma() {
        // 🌀 Habilidad suprema
        if (bendicion >= 100 && habilidad == null) {
            System.out.println("🌑 " + GetApodo() + " ha alcanzado el 100% de corrupción... ¡Puede invocar al Leviatán!");
            cargarHabilidad();
            return; // 👈 salimos para evitar que invoque armas si ya tiene habilidad
        }

        // 🪓 Invocar Hoz Oxidada (solo si aún no hay arma)
        if (bendicion >= 20 && arma == null) {
            arma = new HozOxidada(this);
            System.out.println("🪓 " + GetApodo() + " invoca " + arma.getNombre() + "!");
        } // ☠️ Evoluciona a Hoz Venenosa (solo si la actual es Oxidada)
        else if (bendicion >= 40 && arma != null && arma.getNombre().equals("Hoz Oxidada")) {
            arma = new HozVenenosa(this);
            System.out.println("🪓 " + GetApodo() + " invoca " + arma.getNombre() + "!");
        } // 💀 Evoluciona a Hoz Mortífera (solo si la actual es Venenosa)
        else if (bendicion >= 70 && arma != null && arma.getNombre().equals("Hoz Venenosa")) {
            arma = new HozMortifera(this);
            System.out.println("🪓 " + GetApodo() + " invoca " + arma.getNombre() + "!");
        }
    }

    // ✅ Incrementar “bendición del vacío” (maldición)
    @Override
    public void cargarBendicion() {
        int incremento = 10;
        bendicion += incremento;
        if (bendicion > 100) {
            bendicion = 100;
        }

        System.out.println("🩸 " + GetApodo() + " incrementa su energía del vacío a " + bendicion + "%.");
    }

    // ✅ Inicializar la habilidad suprema si llega al 100%
    @Override
    public void cargarHabilidad() {
        if (bendicion >= 100) {
            habilidad = new LeviatanDelVacio();
            System.out.println("🌌 ¡" + GetApodo() + " ha invocado al " + habilidad.nombre + "!");
        }
    }
}
