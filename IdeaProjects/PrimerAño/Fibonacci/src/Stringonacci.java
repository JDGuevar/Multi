public class Stringonacci
{
    public Stringonacci(int n)
    {
        if (n >= 0)
            System.out.println(new StringBuilder(fibonacci(n)).reverse());
    }

    private String fibonacci(int n)
    {
        if (n == 0) return "0";

        String f0 = "0";
        String f1 = "1";

        for (int i = 2; i <= n; i++)
        {
            StringBuilder fn = new StringBuilder();
            int carrying = 0;
            for (int j = 0; j < f1.length(); j++)
            {
                int c0 = f0.charAt(j) - '0';
                int c1 = f1.charAt(j) - '0';

                int c = c0 + c1 + carrying;

                carrying = 0;

                if (c >= 10)
                {
                    c -= 10;
                    carrying = 1;
                }
                fn.append(c);
            }
            f0 = f1;
            f1 = fn.toString();
            if (carrying == 1)
            {
                f0 += "0";
                f1 += "1";
            }
        }
        System.out.println(f1.length());
        return f1;
    }

    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
        new Stringonacci(50000);
        System.out.println(System.currentTimeMillis() - start);
    }
}
