public class Primcop {
    public static void main(String[] args) {
        int desde = 1;
        int hasta = Integer.MAX_VALUE;
        boolean esPrimo;
        int n=0;
        int contprim=0;
        int k;
        int[] guardaprimos = new int[hasta/3];

        for (int i = desde; i < hasta; i+= 2) {
            esPrimo = true;

            for (int j = 3; j <= Math.sqrt(i); j+= 2) {
                if (i % j == 0) {
                    esPrimo = false;
                    break;
                }
            }
            if (esPrimo){

                contprim++;

                k=i;
                guardaprimos[n++]= k;
                System.out.println(i);

            }
        }
        for (int i = 0; i < contprim; i++)
            System.out.println(guardaprimos[i]);
    }
}

