public class CopQueens {
    //write a program that prints the solution to the n-queens problem in an ascii board
    //in the following format:
    // 0 1 0 0
    // 0 0 0 1
    // 1 0 0 0
    // 0 0 1 0
    // where 1 is a queen and 0 is an empty space
    public static void main(String[] args) {
        new Queen(8);
    }
    public static class Queen extends Hypertext {
        int N;
        int[][] board;

        public Queen(int n) {
            this.N = n;
            html("queens.html", "Queens");
        }

        public void styleContent() {
            pw.println("  table, th, td {\n" +
                    "    border: 1px solid;\n" +
                    "    border-collapse: collapse;\n" +
                    "    text-align: center;\n" +
                    "  }\n" +
                    "  tr:nth-child(even) td:nth-child(even), tr:nth-child(odd) td:nth-child(odd) {\n" +
                    "    background: grey;\n" +
                    "  }\n" +
                    "  tr:nth-child(odd) td:nth-child(even), tr:nth-child(even) td:nth-child(odd) {\n" +
                    "    background: white;\n" +
                    "  }\n" +
                    "  td{\n" +
                    "    height:40px;\n" +
                    "    width: 40px;\n" +
                    "  }\n");
        }

        public void bodyContent() {
            solveNQ();
        }

        public void solveNQ() {
            board = new int[N][N];
            if (solveNQUtil(0) == false) {
                System.out.print("Solution does not exist");
                return;
            }
            imprimir();
        }

        public boolean solveNQUtil(int col) {
            if (col >= N)
                return true;
            for (int i = 0; i < N; i++) {
                if (isSafe(i, col)) {
                    board[i][col] = 1;
                    if (solveNQUtil(col + 1) == true)
                        return true;
                    board[i][col] = 0;
                }
            }
            return false;
        }

        public boolean isSafe(int row, int col) {
            int i, j;
            for (i = 0; i < col; i++)
                if (board[row][i] == 1)
                    return false;
            for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
                if (board[i][j] == 1)
                    return false;
            for (i = row, j = col; j >= 0 && i < N; i++, j--)
                if (board[i][j] == 1)
                    return false;
            return true;
        }

        public void imprimir() {
            pw.println("<table>");
            for (int x = 0; x < N; x++) {
                pw.println("<tr>");
                for (int y = 0; y < N; y++)
                    pw.print("<td>" + board[x][y] + "</td>");
                pw.println("\n</tr>");
            }
            pw.println("</table>");
        }
    }
}
