package BibliotecaRamon;

public abstract class Persona {
    private String nombre;
    private int edad;

    static final int SIN_EDAD = -1;

    public Persona(String nombre, int edad) {
        setNombre(nombre);
        setEdad(edad);
    }

    public Persona(){
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad > 0)
            this.edad = edad;
    }
}
