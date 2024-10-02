public class Biblioteca {

    public static void main(String[] args) {
        /*Autor autor = new Autor();
        autor.generarAutores();*/

        Autor autor1 = new Autor("Dennis Ritchie", 70);
        Autor autor2 = new Autor("Brian Kernighan", 80);
        Libro libro = new Libro("Lenguaje C", autor1, autor2);
        libro.mostrarAutores();
    }
}