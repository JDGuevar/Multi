import java.util.Scanner;

public class ProgramaClasico {

    public static void main(String[] args) {

        Scanner teclado = new Scanner( System.in );

        System.out.print("Introduce tu nombre: ");
        String nom = teclado.nextLine();

        System.out.print("Introduce tu edad: ");
        int num = teclado.nextInt();

        System.out.println("Te llamas " + num + " y tu edad es " + nom + " años");
    }
}
