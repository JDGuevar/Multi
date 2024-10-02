public class Mid extends Campeon{
    private int DV;

    public Mid(String nombre, String rol) {
        super(nombre, rol);
        setSpecifics();
    }

    public void setSpecifics(){
        DV = super.getPorcentaje();
    }

    @Override
    public String getRol() {
        return super.getRol();
    }

    public void habilidad(){
        //Daño verdadero
        super.getEnemigo().setHP(super.getEnemigo().getHP() - (super.getAtaqueM() + (DV/100) * super.getAtaqueM()));
    }

}
