import java.time.LocalDate;

public class Club {

    private String nombre;
    private LocalDate fechaFundacion;
    public Jugador[] equipo = new Jugador[11];

    Club(String nombre, LocalDate fechaFundacion) {
        this.nombre = nombre;
        this.fechaFundacion = fechaFundacion;
    }

    public void formarEquipo(String[] nombres) {
        for (int i = 0; i < 11; i++) {
            equipo[i] = new Jugador(nombres[(int) (Math.random() * nombres.length)], i+1 , this);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaFundacion() {
        return fechaFundacion.toString();
    }

    public Jugador[] getEquipo() {
        return equipo;
    }
}
