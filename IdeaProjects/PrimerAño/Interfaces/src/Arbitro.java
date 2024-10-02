public class Arbitro extends Persona{
    private int numeroColegiado;
    Arbitro(String nombre, int numeroColegiado) {
        super(nombre);
        this.numeroColegiado = numeroColegiado;
    }

    public int getNumeroColegiado() {
        return numeroColegiado;
    }
}
