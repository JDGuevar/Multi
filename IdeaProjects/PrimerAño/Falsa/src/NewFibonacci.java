public class NewFibonacci
{
    public static void main(String[] args)
    {
        final int BASE = 1_000_000_000;
        final int DIGITOS = 3;
        int carry;
        int[] sumando = new int[DIGITOS];
        int[] a = new int[DIGITOS];
        int[] t = new int[DIGITOS];

        for (int i = 0; i < sumando.length; i++)
        {
            sumando[i] = 0;
            a[i] = 0;
        }

        for (int i = sumando.length - 1; i >= 0; i--) System.out.format("%09d",sumando[i]);
        System.out.println();

        a[0] = 1;

        for (int j = 1; j <= 100; j++)
        {

            carry = 0;

            for (int i = 0; i < sumando.length; i++)
            {

                t[i] = a[i];

                a[i] = sumando[i];

                sumando[i] = sumando[i] + t[i] + carry;

                carry = 0;

                if (sumando[i] >= BASE)
                {
                    sumando[i] -= BASE;
                    carry = 1;

                }

            }

            for (int i = sumando.length - 1; i >= 0; i--) System.out.format("%09d",sumando[i]);
            System.out.println();
        }
    }
}
