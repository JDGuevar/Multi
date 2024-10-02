package Pract1;

public abstract class Vehiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private int potencia;

    public Vehiculo(String matricula, String marca, String modelo, int potencia) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        mostrarDatos();
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public void mostrarDatos(){
        System.out.println("Potencia: " + potencia + " CV");
        System.out.println("Matricula: " + matricula);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
    }
    public abstract void mostrarDatosEspecificos();
}
