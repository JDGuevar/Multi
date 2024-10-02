package Pract4;

public class Moto extends Vehiculo{
    private int Cilindrada = 100;

    public Moto(String marca, String modelo, int Cilindrada) {
        super(marca, modelo);
        if (Cilindrada > 0) this.Cilindrada = Cilindrada;
        if (this.Cilindrada < 500) {
            System.out.println("Esta moto de Cilindrada " + this.Cilindrada + " no permite viajes largos");
        }
    }

    @Override
    public void acelerar(int velocidad) {
        if (this.Cilindrada < 500 && (velocidad + super.getVelocidad()) > 250){
            System.out.println("No se puede acelerar tanto esta moto de Cilindrada " + this.Cilindrada);
            return;
        }
        super.acelerar(velocidad);
        System.out.println("Acelerando moto a "+ super.getVelocidad() + " km/h");
    }
    @Override
    public void desacelerar(int velocidad){
        super.desacelerar(velocidad);
        System.out.println("Desacelerando moto a "+ super.getVelocidad() + " km/h");
    }

}
