public class GranSuma
{
    public static void main(String[] args)
    {
        final int BASE = 1_000_000_000;
        int a, b, c, carry;

        a = 1;
        b = 0;
        c = 0;
        carry = 0;

        System.out.format("%010d%09d%09d\n", c, b, a);

        for (int i = 1 ; i <= 64; i++)
        {
            a = a + a + carry;

            carry = 0;

            if (a >= BASE)
            {
                a -= BASE;
                carry = 1;
            }

            b = b + b + carry;

            carry = 0;

            if (b >= BASE)
            {
                b -= BASE;
                carry = 1;
            }

            c = c + c + carry;

            carry = 0;

            if (c >= BASE)
            {
                c -= BASE;
                carry = 1;
            }

            System.out.format("%d%09d%09d%09d\n", carry, c, b, a);
        }
    }
}
