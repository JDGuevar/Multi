import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Libro {
    private String titulo;
    private List<Autor> autores = new ArrayList<Autor>();

    public Libro(String titulo) {
        this.titulo = titulo;
    }

    public Libro(String titulo, Autor ... autores){
        this.titulo = titulo;
        this.autores.addAll(Arrays.asList(autores));
    }

    public void addAutor(Autor autor){
        autores.add(autor);
    }

    public void mostrarAutores(){
        System.out.println(autores.toString());
        for (Autor autor : autores)
            System.out.println(autor);
    }
}
