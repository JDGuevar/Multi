import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Quadrat2
{
    private int mida = 3;
    private final int[][] quadrat;
    private PrintWriter pw;

    public Quadrat2(int mida)
    {
        if (mida % 2 != 0 && mida > 0)
        {
            this.mida = mida;
        }

        this.quadrat = new int[this.mida][this.mida];

        generar();

        try
        {
            pw = new PrintWriter(String.format("Quadrat%03d.html", this.mida));
            html();
            pw.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println(e.getMessage());
        }
    }

    private void generar()
    {
/*
        int f = 0;
        int c = (mida - 1) >> 1;

        for (int q = 0; q < mida * mida; q++)
        {
            if (q % mida == 0)
                f = (f - 1 + mida) % mida;
            else
            {
                f = (f + 1) % mida;
                c = (c + 1) % mida; // c = (c - 1 + mida) % mida;
            }
            quadrat[f][c] = 1 + q;
        }
*/
        int f = mida - 1;
        int c = (mida - 1) / 2;

        for (int q = 0; q < mida * mida; q++)
        {
            if (q % mida == 0)
            {
                f = (f + 1) % mida;
            }
            else
            {
                f = (f - 1 + mida) % mida;
                c = (c + 1) % mida; // c = (c - 1 + mida) % mida;
            }
            quadrat[f][c] = q + 1;
        }
        /*
        int f = (mida - 1) / 2;
        int c = mida - 1;

        for (int q = 0; q < mida * mida; q++)
        {
            if (q % mida == 0)
            {
                c = (c + 1) % mida;
            }
            else
            {
                f = (f - 1 + mida) % mida; // f = (f + 1) % mida;
                c = (c - 1 + mida) % mida;
            }
            quadrat[f][c] = q + 1;
        }
        */
    }

    private void html()
    {
        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        head();
        body();
        pw.println("</html>");
    }

    private void head()
    {
        pw.println("<head>");
        pw.format("<title>Quadrat %dx%d</title>\n", mida, mida);
        style();
        pw.println("</head>");
    }

    private void body()
    {
        pw.println("<body>");
        table();
        pw.println("</body>");
    }

    private void table()
    {
        pw.println("<table>");
        for (int f = 0; f < mida; f++)
        {
            pw.println("<tr>");
            for (int c = 0; c < mida; c++)
                pw.format("<td>%d</td>", quadrat[f][c]);
            pw.println("</tr>");
        }
        pw.println("</table>");
    }

    private void style()
    {
        pw.println("<style>");
        pw.println("td {\nwidth: 40px;\nheight: 40px;\ntext-align: center;\nbackground-color: lightgray;\n}");
        pw.println("tr:nth-of-type(2n+1) > td:nth-of-type(2n+1),\ntr:nth-of-type(2n) > td:nth-of-type(2n) {\nbackground-color: aqua;\n}");
        pw.println("</style>");
    }
}
