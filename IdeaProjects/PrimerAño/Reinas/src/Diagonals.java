public class Diagonals {

    private int filas = 5;
    private int columnas = 5;

    private int matriz[][];

    public Diagonals(int filas, int columnas){
        if (filas > 0) this.filas = filas;
        if (columnas > 0) this.columnas = columnas;
        matriz = new int[filas][columnas];
    }

    private void suma(){
        for(int f = 0; f < filas; f++)
            for (int c = 0; c < columnas; c++)
                matriz[f][c] = f+c;
    }

    private void resta(){
        for(int f = 0; f < filas; f++)
            for (int c = 0; c < columnas; c++)
                matriz[f][c] = f - c + Math.max(filas, columnas);
    }

    private void mostrar(){
        for(int f = 0; f < filas; f++)
            for (int c = 0; c < columnas; c++)
                System.out.printf("%3d", matriz[f][c]);
        System.out.println();
    }
}
