import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Criba2 {
    public static void main(String[] args) {
    final int LIMITE = 10000;

        boolean[] esPrimo = new boolean[LIMITE];

        for (int i = 0; i < esPrimo.length; i++) esPrimo[i] = true;

        int cuadrado = 3;
        int proximo = 8;

        for (int i = 0; cuadrado < esPrimo.length; i++)
        {
            if (esPrimo[i]){
                int primo = i + i + 3;
                System.out.printf("%d\r", primo);
                for (int j = cuadrado; j < esPrimo.length; j += primo) esPrimo[j] = false;
            }
            cuadrado += proximo;
            proximo += 4;
        }

        try {
            PrintWriter salida = new PrintWriter("primos.txt");
            int contador = 0;

            for (int i = 0; i < esPrimo.length; i++){
                if (esPrimo[i]) {
                    salida.printf("%11d",i + i + 3);

                    if (++contador%10 == 0)
                        salida.printf("  |||  %d\n", contador);
                }
            }
            salida.close();
        }catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }

    }
}
