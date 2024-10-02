public class Criba {
    public static void main(String[] args) {
        final int LIMITE = 5000;

        boolean[] esPrimo = new boolean[LIMITE];

        for (int i = 0; i < esPrimo.length; i++)
        {
            esPrimo[i] = true;
        }

        int cuadrado = 3;
        int proximo = 8;

        for (int i = 0; cuadrado < esPrimo.length; i++)
        {
            /*if (esPrimo[i]){
                int primo = i + i + 3;

                System.out.println(primo);

                int cuadrado = (primo * primo - 3) >> 1;

                for (int j = cuadrado; j < esPrimo.length; j += primo){
                    esPrimo[j] = false;
                }
            }*/


            if (esPrimo[i]){
                int primo = i + i + 3;


                //if (cuadrado >= esPrimo.length) break;


                for (int j = cuadrado; j < esPrimo.length; j += primo) esPrimo[j] = false;
            }
            cuadrado += proximo;
            proximo += 4;
        }

        for (int i = 0; i < esPrimo.length; i++){
            if (esPrimo[i])
                System.out.println(i + i + 3);
        }
    }
}
