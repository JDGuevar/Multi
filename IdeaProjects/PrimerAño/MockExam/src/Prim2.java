public class Prim2 {
    public static void main(String[] args) {
        final int LIMITE = 100;
        boolean[] esPrimo = new boolean[LIMITE];

        for (int i = 0; i < esPrimo.length; i++) esPrimo[i] = true;
        for (int i = 1; i < esPrimo.length; i++)
            if(esPrimo[i]){
                int primo = i+1;
                System.out.println(primo);
                for (int j = i + primo; j< esPrimo.length; j += primo) esPrimo[j] = false;
            }
    }
}
