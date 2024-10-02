public class Factorial
{
    public static double factorial(double numero)
    {
        int resultat = 1;
        for (int i = 1; i <= numero; i++)
        {
            resultat = resultat * i;
        }
        return resultat;
    }

    public static void main(String[] args) {

        System.out.println(factorial(5));
    }
}
