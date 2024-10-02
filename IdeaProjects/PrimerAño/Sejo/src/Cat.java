public class Cat extends Animal{
    private String sonido = "Miau, Miau";

    public Cat(String name) {
        super(name);
    }

    public void sonido(){
        System.out.println(sonido);
    }
}
