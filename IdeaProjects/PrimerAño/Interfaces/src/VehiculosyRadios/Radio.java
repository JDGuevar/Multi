package VehiculosyRadios;

public class Radio implements Control{
    String nombreEmisora;
    double frecuenciaEmisora;
    boolean encendido;
    @Override
    public void encender(){
        encendido = true;
    }

    @Override
    public void apagar() {
        encendido = false;
    }
}
