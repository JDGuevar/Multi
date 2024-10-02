public class ADC extends Campeon{
    private int Rango;
    private int Critico;

    public ADC(String nombre, String rol) {
        super(nombre, rol);
        setSpecifics();
    }

    public void setSpecifics(){
        Rango = 500 + (int)(Math.random() * 200);
        Critico = super.getPorcentaje();
    }

    @Override
    public String getRol() {
        return super.getRol();
    }

    public void habilidad(){
        //Ataque básico
        super.getEnemigo().setHP(super.getEnemigo().getHP() - (super.getAtaque() + (Critico/100) * super.getAtaque()));
    }
}
