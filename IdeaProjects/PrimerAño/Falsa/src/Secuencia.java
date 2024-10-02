public class Secuencia
{
    public static void main(String[] args)
    {
        int niveles = 10;

        System.out.println(" ".repeat(niveles-1) + "*");

        for (int i = 1; i <= niveles; i++)
        {
            System.out.println(" ".repeat(niveles-i) + "A".repeat(i+i-1));
        }
    }
}