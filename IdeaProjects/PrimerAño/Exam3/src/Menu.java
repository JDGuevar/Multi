import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public final int WIDTH = 30;
    String header;
    String[] options;

    public Menu(String header, String ... options) {
        this.header = header;
        this.options = options;
    }

    public void show() {
        System.out.println("\u001B[36m╔" + "═".repeat(WIDTH) + "╗\u001B[0m");
        System.out.printf("\u001B[36m║\u001B[35m%s\u001B[36m║\u001B[0m%n", centerText(header));
        System.out.println("\u001B[36m╠" + "═".repeat(WIDTH) + "╣\u001B[0m");

        int counter = 0;
        int rellenoAtras = WIDTH - 10;

        for (String option : options) {
            int relleno = WIDTH - option.length() - 5;
            counter++;
            System.out.printf("\u001B[36m║\u001B[0m \u001B[35m%d → \u001B[0m%s%n", counter, "\u001B[35m" + option + " ".repeat(relleno) + "\u001B[36m║\u001B[0m");
        }

        System.out.println("\u001B[36m╠" + "═".repeat(WIDTH) + "╣\u001B[0m");
        System.out.println("\u001B[36m║ \u001B[0m" + "\u001B[35m0 → Atrás" + " ".repeat(rellenoAtras) + "\u001B[36m║\u001B[0m");

        System.out.print("\u001B[36m╚" + "═".repeat(WIDTH) + "╝\u001B[0m" + "\n");


    }

    public int getOption() {
        Scanner get = new Scanner(System.in); //para leer lo que el usuario introduce(lee los números que pulsamos en nuestro caso)
        show();

        try {
            return get.nextInt(); // Solo deja que el programa lea carácteres numéricos a la hora de que el usuario introduzca algo
        }
        catch (InputMismatchException e) {
            doNothing();
        }
        return -1;
    }

    private String centerText(String texto) {
        int relleno = (WIDTH - texto.length()) / 2;
        return " ".repeat(relleno) + texto + " ".repeat(relleno);
    }

    private void doNothing() {
    }
}
