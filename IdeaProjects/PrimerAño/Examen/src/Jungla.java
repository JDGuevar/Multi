public class Jungla extends Campeon{

    private String mensajillo;

    public Jungla(String nombre, String rol) {
        super(nombre, rol);
        mensajillo = nombre + " está batallando";
    }

    public void habilidad(){
        System.out.println("Hola " + super.getEnemigo().getNombre());
    }
}
