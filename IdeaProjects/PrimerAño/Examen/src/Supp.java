public class Supp extends Campeon{
    private int curacion;

    public Supp(String nombre, String rol) {
        super(nombre, rol);
        setSpecifics();
    }
    public void setSpecifics(){
        curacion = super.getPorcentaje();
    }

    @Override
    public String getRol() {
        return super.getRol();
    }

    public void habilidad(){
        //Curación
        super.getAliadoCercano().setHP((super.getAliadoCercano().getHP() - super.getAliadoCercano().getHPActual() * (curacion/100)));
    }
}
