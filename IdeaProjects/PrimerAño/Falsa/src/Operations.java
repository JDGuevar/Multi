import java.util.InputMismatchException;
import java.util.Scanner;

public class Operations {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int uno = 0 , dos = 0;

        System.out.print("Ingresa 2 números enteros para sumarlos: ");
        try {
            uno = entrada.nextInt();
            dos = entrada.nextInt();
        }catch (InputMismatchException e) {
            System.err.println(" Introduce 2 números enteros");
            System.exit(4);
        }
        System.out.println("La suma da: " + sumar(uno,dos));
        System.out.println("La resta da: " + restar(uno,dos));
        System.out.println("La multiplicación da: " + multiplicar(uno,dos));
    }
    static int sumar(int x, int y){
        return x+y;
    }
    static int restar(int x, int y){
        return x-y;
    }
    static int multiplicar(int x, int y){
        return x*y;
    }
}
