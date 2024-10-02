package Pract1;

public class Motocicleta extends Vehiculo {
    private String tipo="Pract1.Motocicleta";
    private int cilindrada;

    public Motocicleta(String matricula, String marca, String modelo, int potencia, int cilindrada) {
        super(matricula, marca, modelo, potencia);
        this.cilindrada = cilindrada;
        mostrarDatosEspecificos();
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public void mostrarDatosEspecificos(){
        System.out.println("Cilindrada: " + cilindrada + " cc");
    }
}
