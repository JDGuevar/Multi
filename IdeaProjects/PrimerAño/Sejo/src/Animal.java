public abstract class Animal {
    private String name;
    private boolean duerme = false;

    public Animal(String name) {
        this.name = name;
    }

    public void duerme(){
        if (duerme) {
            System.out.println(name + " ya está durmiendo");
        } else {
            System.out.println(name + " se va a dormir");
            duerme = true;
        }
    }

    public void despierta(){
        if (duerme) {
            System.out.println(name + " se despierta");
            duerme = false;
        } else {
            System.out.println(name + " ya está despierto");
        }
    }

    abstract void sonido();
}
