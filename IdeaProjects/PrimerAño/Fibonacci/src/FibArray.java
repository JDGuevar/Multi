public class FibArray {
    public static void main(String[] args) {
        byte[] a = new byte[50];
        byte[] b = new byte[50];
        a[0] = 0;
        mostrar(a);
        b[0] = 1;
        mostrar(b);

        for (int i = 2; i < 100; i++){
            byte[] c = sumar(a, b);
            mostrar(c);
            a = b;
            b = c;
        }
    }
    static byte[] sumar(byte[] x, byte[] y){
        byte[] z = new byte[x.length];
        byte acarreo = 0;

        for (int i = 0; i < x.length; i++){
            z[i] = (byte) (x[i] + y[i] + acarreo);
            acarreo = 0;
            if (z[i] >= 10){
                z[i] -= 10;
                acarreo = 1;
            }
        }
        return z;
    }
    static void mostrar(byte[] x){
        for (int j = x.length - 1; j >= 0; j--)
            System.out.print(x[j]);
        System.out.println();
    }
}
