package Pract1;

public class Automovil extends Vehiculo {
    private String tipo = "Pract1.Automovil";
    private int numPuertas;
    private int numPlazas;

    public Automovil(String matricula, String marca, String modelo, int potencia, int numPuertas, int numPlazas) {
        super(matricula, marca, modelo, potencia);
        this.numPuertas = numPuertas;
        this.numPlazas = numPlazas;
        mostrarDatosEspecificos();
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
    }

    public void mostrarDatosEspecificos(){
        System.out.println("Numero de puertas: " + numPuertas);
        System.out.println("Numero de plazas: " + numPlazas);
    }
}
