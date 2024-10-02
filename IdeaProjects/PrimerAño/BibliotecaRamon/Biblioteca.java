package BibliotecaRamon;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private final List<Autor> conjuntoAutores = new ArrayList<>();
    private final List<Libro> conjuntoLibro = new ArrayList<>();

    public Biblioteca(){
        asignarAutores();
        asignarLibros();

        Menu principal = new Menu("MENÚ PRINCIPAL", "Listas", "Copia seguridad");
        Menu listados = new Menu("LISTADOS", "Lista autores", "Lista libros");
        int option = -1;

        while (option != 0) {
            option = principal.getOption();

            switch (option) {
                case 0 -> pass();
                case 1 -> {
                    int suboption = -1;

                    while (suboption != 0) {
                        suboption = listados.getOption();

                        switch (suboption) {
                            case 0 -> pass();
                            case 1 -> listaDeAutores();
                            case 2 -> listaDeLibros();
                            default -> System.out.println("Opción inválida");
                        }
                    }
                }
                case 2 -> {
                    escribirArchivos();
                    System.out.println("Se ha creado el archivo");
                }
                default -> System.out.println("Opción inválida");
            }
            escribirArchivos();
        }
        System.out.println("Biblioteca creada");
    }

    private void asignarAutores(){
        try (Scanner leer = new Scanner(new File("autores.csv"))){
            System.out.println("Leyendo autores.csv");
            while (leer.hasNextLine()){
                String[] linea = leer.nextLine().split(",");
                String idAutor = linea[0];
                String nombre = linea[1];
                conjuntoAutores.add(new Autor(idAutor, nombre));
            }
            System.out.println("Autores leidos");

        }
        catch (Exception e){
            System.err.println("Error al leer el archivo 1");
        }
    }

    private void asignarLibros(){
        try (Scanner leer = new Scanner(new File("Libros.csv"))){
            System.out.println("Leyendo Libros.csv");
            while (leer.hasNextLine()){
                String[] linea = leer.nextLine().split(",");
                String idLibro = linea[0];
                String titulo = linea[1];
                int puntos = Integer.parseInt(linea[2]);
                String idAutor = linea[3];
                conjuntoLibro.add(new Libro(idLibro, titulo, puntos, idAutor));

                for (Autor autor : conjuntoAutores){
                    if (autor.getIdAutor().equals(idAutor)){
                        autor.librosEscritos++;
                    }
                }
            }
            System.out.println("Libros leidos");
        }
        catch (Exception e){
            System.err.println("Error al leer el archivo 2");
        }
    }
    private void juntarAutoresLibros(){
        try (PrintWriter printer = new PrintWriter("autoresLibros.csv")){
            System.out.println("Imprimiendo autoresLibros.csv");

            conjuntoAutores.sort(Autor::compareTo);
            for (Autor autor: conjuntoAutores){
                for (Libro libro : conjuntoLibro){
                    if (libro.getAutores().contains(autor.getIdAutor())){
                        printer.println(autor.getNombre() + "," + libro.getTitulo());
                    }
                }
            }

            /*for (Libro libro : conjuntoLibro){
                for (Autor autor : conjuntoAutores){
                    if (libro.getAutores().contains(autor.getIdAutor())){
                        printer.println(libro.getTitulo() + "," + autor.getNombre());
                        break;
                    }
                }
            }*/
            System.out.println("Ya ta");
        }
        catch (Exception e1){
            System.err.println("Error al imprimir el archivo");
        }
    }


    private void reescribirAutores(){
        try (PrintWriter printer = new PrintWriter("autores.csv")){
            for (Autor autor : conjuntoAutores){
                printer.println(autor);
            }
        }
        catch (Exception e){
            System.err.println("Error al reescribir el archivo");
        }
    }

    private void reescribirLibros(){
        try (PrintWriter printer = new PrintWriter("Libros.csv")){
            for (Libro libro : conjuntoLibro){
                printer.println(libro);
            }
        }
        catch (Exception e){
            System.err.println("Error al reescribir el archivo");
        }
    }

    public void listaDeAutores() {
        try (PrintWriter listAutores = new PrintWriter("Lista_de_Autores.csv")) {
            for (Autor autor : conjuntoAutores) {
                int puntosTotales = 0;
                for (Libro libro : conjuntoLibro)
                    for (String dato : libro.getAutores())
                        if (dato.equals(autor.getIdAutor())) puntosTotales += libro.getPuntos();

                listAutores.println(autor.getIdAutor() + "," + autor.getNombre() + "," + puntosTotales);
            }
        } catch (IOException e) {
            System.out.println("Archivo no encontrado.");
        }
    }

    public void listaDeLibros() {
        try (PrintWriter AutoresTitulos = new PrintWriter("Lista_de_Libros.csv")) {
            for (Libro libro : conjuntoLibro)
                for (Autor autor : conjuntoAutores)
                    for (String dato : libro.getAutores())
                        if (dato.equals(autor.getIdAutor()))
                            AutoresTitulos.println(libro.getTitulo() + "," + libro.getPuntos() + "," + autor.getNombre());

        } catch (IOException e) {
            System.err.println("Archivo no encontrado.");
        }
    }

    public void escribirArchivos() {
        try (PrintWriter escribirAutores = new PrintWriter("autores.csv")) {
            for (Autor autor : conjuntoAutores) escribirAutores.println(autor);
        } catch (IOException e) {
            System.err.println("Archivo no encontrado.");
        }

        try (PrintWriter escribirLibros = new PrintWriter("libros.csv")) {
            for (Libro libro : conjuntoLibro) escribirLibros.println(libro);
        } catch (IOException e) {
            System.err.println("Archivo no encontrado.");
        }
    }

    private void pass() {}

    public static void main(String[] args) {
        new Biblioteca();
    }
}