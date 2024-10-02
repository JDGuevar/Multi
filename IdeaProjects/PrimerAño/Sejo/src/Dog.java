public class Dog extends Animal{
    private String sonido = "Guau, Guau";

    public Dog(String name) {
        super(name);
    }

    public void sonido(){
        System.out.println(sonido);
    }
}
