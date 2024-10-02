public class Primo {
    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            System.err.println("Just one integer number");
            System.exit(404);
        }

        int numero = Integer.parseInt(args[0]);

        for (int factor = 2; factor < numero; factor++)
        {
            if (numero % factor == 0)
            {
                System.out.println("The number " + numero + " is not a prime number");
                System.exit(0);
            }
        }

        System.out.println("The number " + numero + " is a prime number");
    }
}
