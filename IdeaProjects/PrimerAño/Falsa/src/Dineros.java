public class Dineros {
    public static void main(String[] args)
    {
        if (args.length != 1) {
            System.err.println("introduce un entero");
            System.exit(1);
        }

        int precio = Integer.parseInt(args[0]);

        int[] plata = { 500, 200, 100, 50, 20, 10, 5, 2, 1 };
        int[] conteo = new int[plata.length];

        System.out.println("precio a pagar: " + precio + " euros");

        for (int i = 0; i < plata.length; i++) {
            conteo[i] = precio / plata[i];
            precio = precio % plata[i];
        }

        for (int i = 0; i < plata.length; i++) {
            if (conteo[i] != 0) {
                System.out.println("Billetes/Monedas de " + plata[i] + ": " + conteo[i]);
            }
        }
    }
}
