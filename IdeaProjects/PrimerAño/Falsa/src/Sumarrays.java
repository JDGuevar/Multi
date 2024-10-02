public class Sumarrays
{
    public static void main(String[] args)
    {
        final int BASE = 1_000_000_000;
        int carry;
        int[] sumando = new int[34];

        for (int i = 0; i < sumando.length; i++) sumando[i] = 0;

        sumando[0] = 1;

        for (int j = 1; j <= 1000; j++)
        {
            carry = 0;

            for (int i = 0; i < sumando.length; i++)
            {
                sumando[i] = sumando[i] + sumando[i] + carry;

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
