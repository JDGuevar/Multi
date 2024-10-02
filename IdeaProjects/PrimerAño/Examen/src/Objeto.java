public class Objeto{
    private String nombre;
    private String rol;
    private int porcentaje;

    public Objeto(String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
        setPorcentaje();
    }

    public void setPorcentaje() {
        switch (rol){
            case "Mid":
                porcentaje = 50;
                break;
            case "Top":
                porcentaje = 25;
                break;
            case "ADC", "Supp":
                porcentaje = 30;
                break;
        }
    }
    public String getRol() {
        return rol;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public String getNombre(){
        return nombre;
    }
}
