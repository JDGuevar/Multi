public class Stringonacci2
{
    final int BASE = 100;
    final int ZEROES = 2;
    public Stringonacci2(int n)
    {
        if (n >= 0)
            System.out.println(fibonacci(n));
    }

    private String fibonacci(int n)
    {
        String f0 = String.format("%0" + ZEROES + "d", 0);
        String f1 = String.format("%0" + ZEROES + "d", 1);

        for (int i = 2; i <= n; i++)
        {
            String fn = "";
            int carrying = 0;

            for (int j =f1.length(); j >= ZEROES; j -= ZEROES)
            {
                int c0 = Integer.parseInt(f0.substring(j - ZEROES, j));
                int c1 = Integer.parseInt(f1.substring(j - ZEROES, j));

                int c = c0 + c1 + carrying;

                carrying = 0;

                if (c >= BASE)
                {
                    c -= BASE;
                    carrying = 1;
                }
                fn = String.format("%0" + ZEROES + "d%s", c, fn);
            }
            f0 = f1;
            f1 = fn;
            if (carrying == 1)
            {
                f0 =  String.format("%0" + ZEROES + "d%s", 0, f0);
                f1 =  String.format("%0" + ZEROES + "d%s", 1, f1);
            }
        }
        System.out.println(f1.length());
        return f1;
    }

    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
        new Stringonacci2(499);
        System.out.println(System.currentTimeMillis() - start);
    }
}