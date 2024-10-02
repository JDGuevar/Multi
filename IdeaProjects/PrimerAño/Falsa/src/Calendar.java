import java.util.InputMismatchException;
import java.util.Scanner;

public class Calendar {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        String[] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};

        int mes=0, any=0;

        System.out.print("Introduce el mes y el año en formato mm yyyy: ");
        try {

            mes = entrada.nextInt();
            any = entrada.nextInt();

        } catch (InputMismatchException e){
            System.err.println("Introduce 2 números enteros");
            System.exit(1);
        }

        int[] diesMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (any < 1 || (mes < 1 || mes > 12))
        {
            System.err.println("Fecha incorrecta");
            System.exit(3);
        }

        if ( ((any % 4 == 0) && (any % 100 != 0)) || (any % 400 == 0) )
        {
            diesMes[1] = 29;
        }

        int a = (14 - mes) / 12;
        int y = any - a;
        int m = mes + 12 * a - 2;
        int d = (1 + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12) % 7;

        int numdias = diesMes[mes - 1];
        int contdia = 1;

        System.out.println("\nCalendario del mes de " + meses[mes-1] + " del año " + any);

        System.out.println("│───────────────────────────│");

        System.out.println("│Lun│Mar│Mie│Jue│Vie│Sab│Dom│");

        System.out.print("│───│───│───│───│───│───│───│\n│");

        for (int i = 0; i < d - 1; i++){
            System.out.print("   │");
        }

        for (int i = d; i < numdias + d; i++){
            if (contdia < 10)
                System.out.print( " " + contdia + " │");
            else {
                if (contdia == 10) System.out.print(" " + contdia + "│ ");
                else System.out.print(contdia + "│ ");
            }

            if (i % 7 == 0){
                if (contdia < 10) System.out.print("\n│───│───│───│───│───│───│───│\n│");
                else System.out.print("\n│───│───│───│───│───│───│───│\n│ ");
            }
            contdia++;

        }

        if ((numdias + d - 1) % 7 != 0) {
            for (int i = numdias + d -1; i % 7 != 0 ; i++){
                System.out.print("  │ ");
            }

            System.out.println("\n│───────────────────────────│");
        }

    }
}
