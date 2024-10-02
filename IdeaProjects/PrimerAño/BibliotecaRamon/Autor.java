package BibliotecaRamon;

public class Autor extends Persona implements Comparable <Autor>{
    private String idAutor;
    public int librosEscritos = 0;

    public Autor(String idAutor,String nombre){
        super(nombre,Persona.SIN_EDAD);
        this.idAutor = idAutor;
    }

    public Autor(String nombre){
        super(nombre,Persona.SIN_EDAD);
        this.idAutor = Helper.genId('A');
    }

    public String getIdAutor() {
        return idAutor;
    }

    public void mostrar(){
        System.out.printf("Autor: %s - %s - %d%n", idAutor, getNombre(), getEdad());
    }

    @Override
    public String toString() {
        return String.format("%s,%s", idAutor, getNombre());
    }

    @Override
    public int compareTo(Autor otro){
        return this.librosEscritos;
    }
}