package BibliotecaRamon;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Libro implements Comparable<Libro>{
    private String idLibro;
    private String titulo;
    private int puntos;
    private List<String> autores = new ArrayList<String>();

    public Libro(String titulo) {
        this.idLibro = Helper.genId('L');
        this.titulo = titulo;
    }

    public Libro(String titulo, String ... autores){ /* "Argumentos variables", lo que permite que un método acepte un número variable de argumentos del mismo tipo. Como un array de objetos*/
        this.idLibro = Helper.genId('L');
        this.titulo = titulo;
        this.autores.addAll(Arrays.asList(autores));
    }

    public Libro(String ID, String titulo,int puntos, String ... autores){
        this.idLibro = ID;
        this.titulo = titulo;
        this.puntos = puntos;
        this.autores.addAll(Arrays.asList(autores));
    }


    public Libro(String titulo,int puntos, String ... autores){
        this.idLibro = Helper.genId('L');
        this.titulo = titulo;
        this.puntos = puntos;
        this.autores.addAll(Arrays.asList(autores));
    }

    public String getTitulo() {
        return titulo;
    }

    public void addAutor(String autor){
      autores.add(autor);
    }

    public void mostrarAutores(){
        System.out.println(autores.toString());
        for (String autor : autores)
            System.out.println(autor);
    }

    @Override
    public String toString(){
        StringBuilder texto = new StringBuilder();
        texto.append(idLibro).append(",");
        texto.append(titulo);
        texto.append(",").append(puntos).append(",");
        for (String autor : autores){
            if (autores.indexOf(autor) > 0)
                texto.append("|");
            texto.append(autor);
        }
        return texto.toString();
    }
    public int getPuntos() {
        return puntos;
    }

    @Override
    public int compareTo(Libro libro){
        return titulo.compareTo(libro.titulo);
    }

    public List<String> getAutores() {
        return autores;
    }
}
