public abstract class Persona {
    private String nombre;
    private int edad;
    static int contador = 0; //es static porque se actualiza en cada instancia que creas

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

    public String obtenerId(char letra) {
        return String.format("%c-%04d", letra,  ++contador);
    }
}
