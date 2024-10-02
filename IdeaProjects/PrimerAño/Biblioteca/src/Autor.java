import java.util.ArrayList;
import java.util.List;

public class Autor extends Persona{
    private String idAutor;

    public Autor(String nombre, int edad){
        super(nombre, edad);
        this.idAutor = obtenerId('A');
    }

    public void mostrar(){
        System.out.printf("Autor: %s - %s - %d%n", idAutor, getNombre(), getEdad());
    }

    @Override
    public String toString() {
        return String.format("Autor: %s - %s - %d%n", getNombre(), getNombre(), getEdad());
    }
    public void generarAutores(){
        Autor[] autores = new Autor[25];
        for(Autor autor : autores){
            autor = new Autor("adada", 23);
        }
    }
}
