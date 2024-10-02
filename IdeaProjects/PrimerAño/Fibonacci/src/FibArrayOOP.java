import java.util.Arrays;

public class FibArrayOOP {

    int XIFRES = 100;
    int[] a = new int[XIFRES];
    int[] b = new int[XIFRES];

    final int BASE = 100000000;
    final int ZEROES = 8;

    public FibArrayOOP(int orden, boolean todos)
    {
        a[0] = 0;
        if (todos) mostrar(0, a);
        b[0] = 1;
        if (todos) mostrar(1, b);

        int[] c = new int[0];

        for (int i = 2; i <= orden; i++)
        {
            c = sumar(a, b);
            if (todos) mostrar(i, c);
            a = b;
            b = c;
        }
        if (!todos) mostrar(orden, c);
    }

    int[] sumar(int[] x, int[] y)
    {
        int[] z = new int[XIFRES];

        int acarreo = 0;

        for (int i = 0; i < XIFRES; i++)
        {
            z[i] = x[i] + y[i] + acarreo;
            acarreo = 0;
            if (z[i] >= BASE)
            {
                z[i] -= BASE;
                acarreo = 1;
            }
        }

        if (acarreo != 0)
        {
            int index = XIFRES;

            XIFRES += 10;

            a = Arrays.copyOf(a, XIFRES);
            b = Arrays.copyOf(b, XIFRES);
            z = Arrays.copyOf(z, XIFRES);

            z[index] = 1;
        }

        return z;
    }

    void mostrar(int orden, int[] x)
    {
        int index = XIFRES - 1;

        System.out.printf("%d ==> ", orden);

        while ((index != 0) && (x[index] == 0)) index--;

        System.out.print(x[index--]);

        while (index >= 0) System.out.printf("%0" + ZEROES + "d", x[index--]);

        System.out.println();
    }

    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
        new FibArrayOOP(500, true);
        System.out.println(System.currentTimeMillis() - start);
    }
}
