import java.util.Random;

public class Quadrat {
    private final int filas = 5;
    private final int columnas = 5;

    private final int mida = 5;
    private final Random rnd = new Random(13);

    private final int[][] tiraDeCoses = new int[filas][columnas];

    private final int[][] quadrat = new int[mida][mida];

    void omplir(){
        for (int f= 0; f< filas; f++)
            for (int c= 0; c<columnas; c++)
                tiraDeCoses[f][c] = rnd.nextInt(0, 50);
    }

    void mostrar(){
        for (int f= 0; f< filas; f++) {
            for (int c = 0; c < columnas; c++)
                System.out.print(tiraDeCoses[f][c] + " ");
            System.out.println();
        }
    }

    void omplirDirecte(){
        int f = 0;
        int c = (mida-1)/2;

        for (int q = 0; q< mida*mida; q++){
            if (q%mida == 0)
                f= (f - 1 + mida)% mida;
            else{
                f = (f + 1)% mida;
                c = (c + 1)% mida; // c = (c - 1 + mida)% mida;
            }
            quadrat[f][c] = 1 + q;
        }
    }

    void mostrarDirecte(){
        for (int i= 0; i< filas*columnas; i++) {
            int f = i / columnas;
            int c = i % columnas;
            System.out.printf("%3d", quadrat[f][c]);
            if ((i + 1) % 5 == 0) System.out.println();
        }
    }
}