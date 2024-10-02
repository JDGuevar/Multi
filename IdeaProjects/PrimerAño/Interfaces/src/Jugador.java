public class Jugador extends Persona{
    private int dorsal;
    private Club club;

    Jugador(String nombre, int dorsal, Club club) {
        super(nombre);
        this.dorsal = dorsal;
        this.club = club;
    }

    public int getDorsal() {
        return dorsal;
    }
}
