import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class Campeon{
    private String nombre;
    private String rol;
    private int HP;
    private int HPActual;
    private int Armadura;
    private int RMagica;
    private int AD;
    private int AP;
    private int porcentaje;
    private Objeto objeto;
    private Campeon enemigo;
    private Campeon aliadoCercano;

    public Campeon(String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
        cogerObjeto();
        setStats();
    }

    public void setEnemigo(Campeon enemigo){
        this.enemigo = enemigo;
    }
    public Campeon getEnemigo(){
        return enemigo;
    }

    public void setAliadoCercano(Campeon aliado){
        this.aliadoCercano = aliado;
    }
    public Campeon getAliadoCercano(){
        return aliadoCercano;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
        this.HPActual = HP;
    }

    private void cogerObjeto(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("objectes.txt"));
            while (br.readLine() != null) {
                String objecte = br.readLine();
                String[] parts = objecte.split("#");
                String nom = parts[0];
                String role = parts[1];
                if (role.equals(rol)) {
                    objeto = new Objeto(nom, role);
                    System.out.println("Objeto: " + objeto.getNombre() +" Asignado a" + nombre);
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Algo fue mal con la generación de objeto");
        }

    }

    public Objeto getObjeto(){
        return objeto;
    }
    private void setStats(){
        HP = 1000 + (int)(Math.random() * 2000);
        HPActual = HP;
        Armadura = 25 + (int)(Math.random() * 75);
        RMagica = 25 + (int)(Math.random() * 75);
        AD = 50 + (int)(Math.random() * 100);
        AP = 50 + (int)(Math.random() * 100);
        porcentaje = (int)(Math.random() * 10) + objeto.getPorcentaje();
    }
    
    public int getPorcentaje() {
        return porcentaje;
    }

    public int getAtaque() {
        return AD;
    }
    public int getAtaqueM() {
        return AP;
    }

    public int getHPActual() {
        return HPActual;
    }
}
