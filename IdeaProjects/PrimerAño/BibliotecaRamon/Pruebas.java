package BibliotecaRamon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pruebas {
    List<Autor> conjuntoAutores = new ArrayList<>();
    List<Libro> conjuntoLibro = new ArrayList<>();

    public Pruebas() {
        leerTexto();
        mostrarAutores();
        mostrarLibros();
    }

    private void leerTexto() {
        boolean nuevoAutor;

        try (Scanner leer = new Scanner(new File("Libros.txt"))) {
            while (leer.hasNextLine()) {
                String[] linea = leer.nextLine().split("[|]");
                String titulo = linea[0];
                String autor = linea[1];
                int puntos = Integer.parseInt(linea[2]);
                nuevoAutor = true;
                Autor autor1 = new Autor(autor);

                for (Autor a : conjuntoAutores)
                    if (a.getNombre().contains(autor)){
                        nuevoAutor = false;
                        Helper.A -= 1;
                        break;
                    }
                conjuntoLibro.add(new Libro(titulo, puntos, autor1.getIdAutor()));

                if (nuevoAutor) {
                    conjuntoAutores.add(autor1);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error al leer el archivo");
        }
    }

    private void mostrarAutores() {
        try(PrintWriter printer = new PrintWriter("autores.csv")) {
            for (Autor autor : conjuntoAutores.stream().sorted().toList())
                printer.println(autor);
            System.out.println("Creados "+conjuntoAutores.size() + " autores");
        }
        catch (FileNotFoundException e) {
            System.err.println("Error al leer el archivo");
        }
    }

    private void mostrarLibros() {
        try(PrintWriter printer = new PrintWriter("Libros.csv")) {
            for (Libro libro : conjuntoLibro.stream().sorted().toList())
                printer.println(libro);
            System.out.println("Creados " +conjuntoLibro.size() + " libros");
        }
        catch (FileNotFoundException e) {
            System.err.println("Error al leer el archivo");
        }
    }
}
