import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ReinasSVG {
    private final int n;
    private int[][] solucionesmatriz;
    private PrintWriter pw;
    private int soluciones;
    public ReinasSVG(int N){
        n = N;
        solucionesmatriz = new int[n][n];
        soluciones = 0;

        try
        {
            pw = new PrintWriter(String.format("Reinas%02d.html", n));
            html();
            pw.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    private void Constructor(int cont, int cont2){
        for (int i = cont2; i < n; i++){
            for (int j = 0; j < n; j++){
                if(Valida(i ,j ,solucionesmatriz )){ //La posición es válida
                    solucionesmatriz[i][j] = 1;
                    cont++;
                    if (cont == n){ //Cuando llega a una solucion la cuenta y la imprime
                        svg();
                        soluciones++;
                        imprimirN();
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

    private void html()
    {
        pw.println("<!doctype html>");
        pw.println("<html>");
        head();
        body();
        pw.println("</html>");
    }

    private void head()
    {
        pw.println("<head>");
        pw.println("<meta charset=\"utf-8\">");
        pw.println("<title>Queens SVG</title>");
        style();
        pw.println("</head>");
    }

    private void body()
    {
        pw.println("<body>");
        Constructor(0, 0);
        pw.println("</body>");
    }

    private void style()
    {
        pw.println("<style>");
        pw.println("svg { stroke: none; }");
        pw.println("</style>");
    }
    private void svg(){
        pw.format("<svg width=\"%d\" height=\"%d\" viewBox=\"0 0 %d %d\">\n", 400, 400, n, n);
        path();
        pw.println("</svg>");
    }

    private void path()
    {
        int f, c;

        for (f = 0; f < n; f++)
            for (c = 0; c < n; c++)
            {
                pw.print("<path d=\"M " + c + " " + f + " ");
                pw.print("h 1 v 1 h -1 z\" fill=\"");
                pw.print(((f + c) % 2 == 0) ? "#000" : "#AAA");
                pw.println("\"/>");
            }
        for (f = 0; f < n; f++)
            for (c = 0; c < n; c++){
                if (solucionesmatriz[f][c] == 1){
                    pw.print("<circle ");
                    pw.print("cx=\"" + (c + 0.5) + "\" ");
                    pw.print("cy=\"" + (f + 0.5) + "\" ");
                    pw.print("r=\"" + 0.45 + "\" ");
                    pw.println("fill=\"red\"/>");
                }

            }
    }

    private void imprimirN(){
        pw.println("<p>Solución número " + soluciones + "</p>");
    }
}
