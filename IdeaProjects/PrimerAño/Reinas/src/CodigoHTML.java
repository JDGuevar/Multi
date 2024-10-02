import java.io.FileNotFoundException;
import java.io.PrintWriter;

public abstract class CodigoHTML {
    PrintWriter printer;

    public CodigoHTML(){
        try{
            printer= new PrintWriter("archivo.txt");
            contenido(printer);
            printer.close();
        } catch (FileNotFoundException e) {
            System.err.println("something went wrong");
        }
    }

    abstract void contenido(PrintWriter printer);
}
