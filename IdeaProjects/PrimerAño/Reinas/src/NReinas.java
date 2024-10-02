public class NReinas {
    private final int n;
    private int[][] solucionesmatriz;

    private int soluciones;
    public NReinas(int N){
        n = N;
        solucionesmatriz = new int[n][n];
        soluciones = 1;
        Constructor(0,0);
    }

    private void Constructor(int cont, int cont2){
        for (int i = cont2; i < n; i++){
            for (int j = 0; j < n; j++){
                if(Valida(i ,j ,solucionesmatriz )){ //La posición es válida
                    solucionesmatriz[i][j] = 1;
                    cont++;
                    if (cont == n){ //Cuando llega a una solucion la cuenta y la imprime
                        imprimir();
                        soluciones++;
                    }else{ //Si no ha colocado todas las reinas, coloca la siguiente (recursividad)
                        Constructor(cont, i);
                    }
                    if(solucionesmatriz[i][j] == 1){ //Cuando encuentra una solución, borra todas las reinas y la matríz vuelve a ser de 0's
                        solucionesmatriz[i][j] = 0;
                        cont--;
                    }
                }
            }
        }
    }

    private boolean Valida(int i, int j, int[][] matriz){ //Posición válida

        boolean resultado = true;

        for (int k = 0; k < n; k++){
            if (matriz[k][j] == 1 || matriz[i][k] == 1){ //verticalidad y horizontalidad;
                resultado = false;
            }
            if ((i - k) >= 0 && (j - k) >= 0){ //Diagonal superior izquierda
                boolean flag = matriz[i - k][j - k] == 0;
                if(!flag) resultado = false;
            }
            if ((i + k) < n && (j + k) < n ){ //Diagonal inferior derecha
                boolean flag = matriz[i + k][j + k] == 0;
                if(!flag) resultado = false;
            }
            if ((i - k) >= 0 && (j + k) < n){ //Diagonal superior derecha
                boolean flag = matriz[i - k][j + k] == 0;
                if(!flag) resultado = false;
            }
            if ((i + k) < n && (j - k) >= 0){ //Diagonal superior izquierda
                boolean flag = matriz[i + k][j - k] == 0;
                if(!flag) resultado = false;
            }
        }
        return resultado;
    }
    private void imprimir(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){

                if(solucionesmatriz[i][j]==1){
                    System.out.printf("%3s","\u265B");
                }
                if (solucionesmatriz[i][j] == 0){
                    System.out.printf("%3s", ".");
                }

            }
            System.out.println();
        }
        System.out.println("Solución número " + soluciones);
    }
}
