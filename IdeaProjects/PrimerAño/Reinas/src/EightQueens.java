import java.awt.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class EightQueens extends Hypertext{
    public int N = 8;
    private final int[] queens;

    public EightQueens(int n){
        if (n>3) N = n;
        queens = new int[N];
        String name = N + " Reinas";
        html(name,name);
    }

    private void solveQueensProblem(int row) {
        if (row == N) {
            path();
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                queens[row] = col;
                solveQueensProblem(row + 1);
            }
        }
    }

    private boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || queens[i] - i == col - row || queens[i] + i == col + row) {
                return false;
            }
        }
        return true;
    }
    public void bodyContent()
    {
        svgDefs();
        solveQueensProblem(0);
    }

    public void styleContent()
    {
        pw.println("svg { stroke: none; }");
    }
    public void svgDefs(){
        pw.println("<svg width = \"0\" height=\"0\">");
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
        pw.println("<path id=\"queen\" d=\"M 0.5069 0.095 C 0.4722 0.095 0.4435 0.1238 0.4435 0.1584 C 0.4435 0.1815 0.4563 0.2018 0.4752 0.2129 L 0.4752 0.2614 C 0.4752 0.2748 0.4649 0.2851 0.4514 0.2851 L 0.3772 0.2851 C 0.3673 0.2851 0.3585 0.2804 0.3534 0.2732 C 0.3696 0.2617 0.3802 0.2429 0.3802 0.2218 C 0.3802 0.1871 0.3515 0.1584 0.3168 0.1584 C 0.2821 0.1584 0.2534 0.1871 0.2534 0.2218 C 0.2534 0.2449 0.2662 0.2652 0.2851 0.2762 L 0.2851 0.3297 L 0.294 0.3396 L 0.3683 0.4138 C 0.3538 0.4193 0.3454 0.4344 0.3484 0.4495 C 0.3513 0.4647 0.3647 0.4756 0.3802 0.4752 L 0.401 0.4752 L 0.3515 0.6514 L 0.3495 0.6564 L 0.3287 0.697 L 0.2851 0.697 C 0.2841 0.697 0.2831 0.697 0.2821 0.697 C 0.2647 0.6978 0.2511 0.7127 0.252 0.7301 C 0.2528 0.7476 0.2677 0.7612 0.2851 0.7603 L 0.2277 0.8366 L 0.2218 0.8445 L 0.2218 0.9187 L 0.792 0.9187 L 0.792 0.8445 L 0.7861 0.8366 L 0.7286 0.7603 C 0.74 0.7604 0.7507 0.7545 0.7565 0.7446 C 0.7622 0.7347 0.7622 0.7226 0.7565 0.7127 C 0.7507 0.7028 0.74 0.6968 0.7286 0.697 L 0.6851 0.697 L 0.6643 0.6564 L 0.6633 0.6544 L 0.6623 0.6514 L 0.6128 0.4752 L 0.6336 0.4752 C 0.6491 0.4756 0.6627 0.4648 0.6655 0.4496 C 0.6685 0.4344 0.66 0.4193 0.6455 0.4138 L 0.7197 0.3396 L 0.7286 0.3297 L 0.7286 0.2762 C 0.7476 0.2652 0.7603 0.2449 0.7603 0.2218 C 0.7603 0.1871 0.7316 0.1584 0.697 0.1584 C 0.6623 0.1584 0.6336 0.1871 0.6336 0.2218 C 0.6336 0.2429 0.6441 0.2617 0.6603 0.2732 C 0.6553 0.2804 0.6465 0.2851 0.6366 0.2851 L 0.5623 0.2851 C 0.5488 0.2851 0.5386 0.2748 0.5386 0.2614 L 0.5386 0.2129 C 0.5575 0.2018 0.5702 0.1815 0.5702 0.1584 C 0.5702 0.1238 0.5415 0.095 0.5069 0.095 Z M 0.5069 0.3277 C 0.5221 0.3404 0.5412 0.3485 0.5623 0.3485 L 0.6197 0.3485 L 0.5564 0.4118 L 0.4574 0.4118 L 0.394 0.3485 L 0.4514 0.3485 C 0.4726 0.3485 0.4917 0.3404 0.5069 0.3277 Z M 0.4673 0.4752 L 0.5465 0.4752 L 0.6029 0.6742 L 0.6039 0.6772 L 0.6138 0.697 L 0.4 0.697 L 0.4099 0.6772 L 0.4108 0.6742 Z M 0.3643 0.7603 L 0.6494 0.7603 L 0.7207 0.8554 L 0.293 0.8554 Z\"/>");
        pw.println("</defs>");
        pw.println("</svg>");
    }

    private void path()
    {
        pw.printf("<svg width=\"%d\" height=\"%d\" viewBox=\"0 0 %d %d\">\n", 400, 400, N, N);
        pw.println("<use xlink:href=\"#chessboard\"/>");
        for (int f = 0; f < N; f++){
            pw.print("<use xlink:href=\"#queen\" ");
            pw.print("x=\"" + (queens[f]) + "\" ");
            pw.print("y=\"" + (f) + "\" ");
            pw.println("fill=\"red\"/>");
        }
        pw.println("</svg>");
    }
}