package VehiculosyRadios;

public class Coche extends Vehiculo {
    private int velocidad;
    private boolean arrancado = false;
    private final Radio radio = new Radio();

    public Coche(String marca, String modelo){
        super(marca,modelo);
    }
    @Override
    public void encender(){
        arrancado = true;
        radio.encender();
    }
    @Override
    public void apagar(){
        if (velocidad > 0) return;
        arrancado = false;
        radio.apagar();
    }

    public void acelerar(int velocidad){
        this.velocidad = this.velocidad + velocidad;
    }

    public void desacelerar(int velocidad){
        if (this.velocidad - velocidad < 0) return;
        this.velocidad = this.velocidad - velocidad;
    }
}
