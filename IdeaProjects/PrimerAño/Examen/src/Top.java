public class Top extends Campeon{
    public Top(String nombre, String rol) {
        super(nombre, rol);
        setSpecifics();
    }
    public void setSpecifics(){
        super.setHP((1 + super.getPorcentaje()/100) * super.getHP());
    }

    public void habilidad(){
        //curarse
        super.setHP(super.getHP() + (super.getHP() * super.getPorcentaje()));
        System.out.println("Yo " + super.getNombre() + " he aumentado mi vida máxima a " + super.getHP() + "HP " + super.getEnemigo().getNombre() + " no tienes nada que hacer!!");
    }
}
