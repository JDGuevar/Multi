public class Primeasen {
    public static void main(String[] args) {
        int desde = 1;
        int hasta = Integer.MAX_VALUE;
        boolean esPrimo;

        for (int i = desde; i < hasta; i+=2) {
            esPrimo = true;

            for (int j = 3; j <= Math.sqrt(i); j+=2) {
                if (i % j == 0) {
                    esPrimo = false;
                    break;
                }
            }
            if (esPrimo){

                System.out.println(i);

            }
        }
    }
}
