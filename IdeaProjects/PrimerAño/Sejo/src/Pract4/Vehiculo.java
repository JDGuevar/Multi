package Pract4;

public class Vehiculo {
    private int velocidad;
    private String marca;
    private String modelo;

    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void acelerar(int velocidad) {
        this.velocidad += velocidad;
    }

    public void desacelerar(int velocidad) {
        if (this.velocidad - velocidad < 0) {
            this.velocidad = 0;
            return;
        }
        this.velocidad -= velocidad;
    }

    public int getVelocidad(){
        return this.velocidad;
    }
}
