import java.util.Arrays;
import java.io.*;

public class Queens
{
    private final int[] x;
    private final boolean[] a, b, c;
    private final int queens;
    private PrintWriter pw;

    public Queens(int queens)
    {
        this.queens = queens;
        x = new int[queens];
        a = new boolean[queens];
        b = new boolean[(queens << 1) - 1];
        c = new boolean[(queens << 1) - 1];
        Arrays.fill(a, true);
        Arrays.fill(b, true);
        Arrays.fill(c, true);
        try
        {
            pw = new PrintWriter(String.format("Queens%02d.html", queens));
            html();
            pw.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
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
        test(0);
        pw.println("</body>");
    }

    private void style()
    {
        pw.println("<style>");
        pw.println("svg { stroke: none; }");
        pw.println("</style>");
    }

    private void test(int i)
    {
        for (int j = 0; j < queens; j++)
            if (a[j] && b[i + j] && c[i - j + queens - 1])
            {
                x[i] = j;
                a[j] = b[i + j] = c[i - j + queens - 1] = false;
                if (i < queens - 1)
                    test(i + 1);
                else
                    svg();
                a[j] = b[i + j] = c[i - j + queens - 1] = true;
            }
    }

    private void svg()
    {
        pw.format("<svg width=\"%d\" height=\"%d\" viewBox=\"0 0 %d %d\">\n", 400, 400, queens, queens);
        path();
        pw.println("</svg>");
    }

    private void path()
    {
        int f, c;

        for (f = 0; f < queens; f++)
            for (c = 0; c < queens; c++)
            {
                pw.print("<path d=\"M " + c + " " + f + " ");
                pw.print("h 1 v 1 h -1 z\" fill=\"");
                pw.print(((f + c) % 2 == 0) ? "#000" : "#AAA");
                pw.println("\"/>");
            }
        for (f = 0; f < queens; f++)
        {
            pw.print("<circle ");
            pw.print("cx=\"" + (x[f] + 0.5) + "\" ");
            pw.print("cy=\"" + (f + 0.5) + "\" ");
            pw.print("r=\"" + 0.45 + "\" ");
            pw.println("fill=\"red\"/>");
        }
    }

    public static void main(String[] args)
    {
        new Queens(8);
    }
}
