package Pract1;

public class Helicoptero extends Vehiculo {
    private String tipo="Pract1.Helicoptero";
    private int numHelices;
    private int numPlazas;

    public Helicoptero(String matricula, String marca, String modelo, int potencia, int numHelices, int numPlazas) {
        super(matricula, marca, modelo, potencia);
        this.numHelices = numHelices;
        this.numPlazas = numPlazas;
        mostrarDatosEspecificos();
    }

    public int getNumHelices() {
        return numHelices;
    }

    public void setNumHelices(int numHelices) {
        this.numHelices = numHelices;
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
    }

    public void mostrarDatosEspecificos(){
        System.out.println("Numero de helices: " + numHelices);
        System.out.println("Numero de plazas: " + numPlazas);
    }
}
