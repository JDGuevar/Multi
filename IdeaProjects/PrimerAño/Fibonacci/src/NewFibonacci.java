public class NewFibonacci
{
    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
        final int BASE = 1_000_000_000; //no tocar.
        final int INTS = 100; //cantidad de ints usados.
        final int FIBOS = 1000; //cantidad de numero de Fibonacci que queremos
        int carry;
        int[] sumando = new int[INTS];
        int[] a = new int[INTS];
        int[] t = new int[INTS];
        sumando[0] = 0;
        System.out.printf("0 --> %09d\n",sumando[0]);
        a[0] = 1;

        for (int j = 1; j < FIBOS; j++) {
            carry = 0;
            for (int i = 0; i < sumando.length; i++) {

                t[i] = a[i];
                a[i] = sumando[i];
                sumando[i] = sumando[i] + t[i] + carry;
                carry = 0;

                if (sumando[i] >= BASE) {
                    sumando[i] -= BASE;
                    carry = 1;
                }
            }
            System.out.print(j + " --> ");
            mostrar(sumando);
        }
        long stop = System.currentTimeMillis();
        System.out.print(stop - start);
    }
    static void mostrar(int[] x){
        for (int i = x.length - 1; i >= 0; i--){
            if (x[i] == 0) continue;
            System.out.printf("%09d",x[i]);
        }
        System.out.println();
    }
}
