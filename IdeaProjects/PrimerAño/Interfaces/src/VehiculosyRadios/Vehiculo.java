package VehiculosyRadios;

public abstract class Vehiculo implements Control{
    String marca;
    String modelo;

    public Vehiculo(String marca, String modelo){
        this.marca = marca;
        this.modelo = modelo;
    }
}
