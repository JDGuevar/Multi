import java.io.PrintWriter;

public class Reinas extends CodigoHTML{
    public Reinas(){
        super();
    }

    public void contenido (PrintWriter printer){
        for (int i = 0; i < 10; i++)
            printer.println(i);
    }
}
