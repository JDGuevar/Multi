import java.time.LocalDate;

public class Partido {
    String[] nombres = {
            "Ana", "Carlos", "Elena", "Diego", "Isabel",
            "Javier", "Laura", "Miguel", "Natalia", "Óscar",
            "Patricia", "Ricardo", "Sofía", "Tomás", "Valeria",
            "Xavier", "Yolanda", "Zara", "Fernando", "Gloria",
            "Hugo", "Inés", "Juan", "Luisa", "María",
            "Nacho", "Olga", "Pedro", "Raquel", "Samuel",
            "Teresa", "Ulises", "Verónica", "Walter", "Ximena",
            "Yago", "Zoe", "Felipe", "Gabriela", "Héctor",
            "Irene", "José", "Karla", "Lorenzo", "Marta"
    };

    private Club clubLocal;
    private Club clubVisitante;
    private Arbitro arbitro;

    public void generarPartido(){
        clubLocal = new Club("Real Madrid", LocalDate.of(1902, 3, 6));
        clubVisitante = new Club("Barcelona", LocalDate.of(1899, 11, 29));
        arbitro = new Arbitro(nombres[(int)(Math.random() * nombres.length)], (int)(Math.random() * 1000));
        clubLocal.formarEquipo(nombres);
        clubVisitante.formarEquipo(nombres);
    }

    public void mostrarDatos(){
        System.out.println("Club local: " + clubLocal.getNombre());
        System.out.println("Club visitante: " + clubVisitante.getNombre());
        System.out.println("Árbitro: " + arbitro.getNombre() + " - " + arbitro.getNumeroColegiado());
        System.out.println("Fecha de fundación del club local: " + clubLocal.getFechaFundacion());
        System.out.println("Fecha de fundación del club visitante: " + clubVisitante.getFechaFundacion());
        System.out.println("Jugadores del club local:");
        for (Jugador jugador : clubLocal.getEquipo()) {
            System.out.println(jugador.getNombre() + " - " + jugador.getDorsal());
        }
        System.out.println("Jugadores del club visitante:");
        for (Jugador jugador : clubVisitante.getEquipo()) {
            System.out.println(jugador.getNombre() + " - " + jugador.getDorsal());
        }
    }
}
