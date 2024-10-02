public class Bucle
{
    public static void main(String[] args)
    {
        int contador=0;

        for (int c = 1; contador < 10; c++)
        {
            if ((c % 2 == 0) || (c % 3 == 0))
            {
                System.out.println(c);
                contador++;
            }
        }
    }
}
