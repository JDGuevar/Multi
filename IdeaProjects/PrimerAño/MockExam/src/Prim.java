import java.util.Scanner;

public class Prim {
    public static void main(String[] args) {
        Scanner e = new Scanner (System.in);
        int desde = 2;
        int hasta = 2147483643;
        boolean esPrimo;
        int cp=0;
        int nb;
        int n=0;
        int k;
        System.out.println("Introduce cuantos primos necesitas: ");
        nb=e.nextInt();
        int[] vp = new int[Math.toIntExact(nb)];

        for (int i = desde; i <= hasta; i++) {
            esPrimo = true;

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    esPrimo = false;
                    break;
                }
            }
            if (esPrimo && cp<nb){

                cp++;
                k=i;
                vp[n++]= k;
            }if(cp >= nb){
                break;
            }
        }
        for (int i = 0; i < nb; i++)
            System.out.println(vp[i]);
    }
}

