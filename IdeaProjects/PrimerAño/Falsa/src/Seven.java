public class Seven
{
    public static void main(String[] args)
    {
        int a = 2;

       for (int n = 5; n < 100; n += a)
        {
            System.out.println(n);

            a = 6 - a;
        }
    }
}
