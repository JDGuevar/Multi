import java.util.InputMismatchException;
import java.util.Scanner;

public class Reducir {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce un número a reducir: ");
        int numero = 0;

        try {
            numero = entrada.nextInt();
        }catch (InputMismatchException e) {
            System.err.println(" Introduce un número entero");
            System.exit(4);
        }

        int resultado = reduccion(numero);
        System.out.println(resultado);
    }

    public static int reduction(int numero) {
        while (numero >= 10) {
            int suma = 0;
            while (numero > 0) {
                suma += numero % 10;
                numero /= 10;
            }
            numero = suma;
        }
        return numero;
    }
    public static int reductor(int numero){
        return 1+((numero-1)%9);
    }
    public static int reduccion(int numero){
        int result = numero % 9;
        return (result!=0) ? result : 9;
    }
}