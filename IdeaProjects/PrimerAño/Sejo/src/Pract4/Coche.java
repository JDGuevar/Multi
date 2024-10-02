package Pract4;

public class Coche extends Vehiculo{
    private int numPuertas;
    private int CV;

    public Coche(String marca, String modelo, int numPuertas, int CV) {
        super(marca, modelo);
        this.numPuertas = numPuertas;
        this.CV = CV;
    }
    @Override
    public void acelerar(int velocidad){
        if ((super.getVelocidad() + velocidad > 250) && (CV < 400)){
            System.out.println("No se puede acelerar tanto este coche de " + CV + " CV");
            return;
        }
        super.acelerar(velocidad);
        System.out.println("Acelerando coche a "+ super.getVelocidad() + " km/h");
    }
    @Override
    public void desacelerar(int velocidad){
        super.desacelerar(velocidad);
        System.out.println("Desacelerando coche a "+ super.getVelocidad() + " km/h");
    }
}
