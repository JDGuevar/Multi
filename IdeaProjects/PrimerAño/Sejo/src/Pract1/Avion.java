package Pract1;

public class Avion extends Vehiculo {
    private String tipo = "Pract1.Avion";
    private int numMotores;
    private int numPlazas;

    public Avion(String matricula, String marca, String modelo, int potencia, int numMotores, int numPlazas) {
        super(matricula, marca, modelo, potencia);
        this.numMotores = numMotores;
        this.numPlazas = numPlazas;
        mostrarDatosEspecificos();
    }

    public int getNumMotores() {
        return numMotores;
    }

    public void setNumMotores(int numMotores) {
        this.numMotores = numMotores;
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
    }

    public void mostrarDatosEspecificos(){
        System.out.println("Numero de motores: " + numMotores);
        System.out.println("Numero de plazas: " + numPlazas);
    }
}
