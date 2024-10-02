public class Fibonacci
{
    public static void main(String[] args)
    {
        int cantidad=100;
        long x=0;
        long y=1;

        System.out.println(0);
        for (int i = 0; i < cantidad; i++)
        {
            System.out.println(y);
            x=y-x;
            y=y+x;
        }
    }
}
