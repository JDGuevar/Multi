
public class KnightTrace extends Hypertext {
    private int N = 8;

    private int[][] sol;

    private int[] tx = new int[64];
    private int[] ty = new int[64];

    public KnightTrace(int n) {
        if (n > 2) N = n;
        html("KingsTour", "KingsTour");
    }

    /* A utility function to check if i,j are
       valid indexes for N*N chessboard */
    private boolean isSafe(int x, int y, int[][] sol) {
        return (x >= 0 && x < N && y >= 0 && y < N
                && sol[x][y] == -1);
    }

    /* A utility function to print solution
       matrix sol[N][N] */
    public void bodyContent() {
        solveKT();
    }
    public void imprimir(){
        pw.printf("<svg width=\"%d\" height=\"%d\" viewBox=\"0 0 %d %d\">\n", 400, 400, N, N);
        pw.println("<defs>");
        pw.println("<g id = \"chessboard\">");
        for (int f = 0; f < N; f++)
            for (int c = 0; c < N; c++)
            {
                pw.print("<path d=\"M " + c + " " + f + " ");
                pw.print("h 1 v 1 h -1 z\" fill=\"");
                pw.print(((f + c) % 2 == 0) ? "#000" : "#AAA");
                pw.println("\"/>");
            }
        pw.println("</g>");
        pw.println("</defs>");
        pw.println("<use xlink:href=\"#chessboard\"/>");
        pw.println("<path stroke=\"grey\" stroke-width=\"0.1\" d=\"M 0.5 0.5 ");
        for (int i = 1; i < 64; i++)
            pw.printf("L %d.5 %d.5 ", tx[i],ty[i]);
        pw.println(" \"/>");

        pw.println("</svg>");
    }

    public void styleContent(){
        pw.println("svg {stroke: none;\n fill: none;}");
    }
    private void solveKT() {
        sol = new int[8][8];

        /* Initialization of solution matrix */
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                sol[x][y] = -1;

        /* xMove[] and yMove[] define next move of Knight.
           xMove[] is for next value of x coordinate
           yMove[] is for next value of y coordinate */
        int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

        // Since the Knight is initially at the first block
        sol[0][0] = 0;

        /* Start from 0,0 and explore all tours using
           solveKTUtil() */
        if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("Solution does not exist");
        } else
            imprimir();

    }

    /* A recursive utility function to solve Knight
       Tour problem */
    private boolean solveKTUtil(int x, int y, int movei,
                                int[][] sol, int[] xMove,
                                int[] yMove) {
        int k, next_x, next_y;
        if (movei == N * N)
            return true;

        /* Try all next moves from the current coordinate
            x, y */
        for (k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = movei;
                if (solveKTUtil(next_x, next_y, movei + 1,
                        sol, xMove, yMove)){
                    tx[movei] = next_x;
                    ty[movei] = next_y;
                    return true;
                }
                else{
                    sol[next_x][next_y] = -1; // backtracking
                }

            }
        }

        return false;
    }
}