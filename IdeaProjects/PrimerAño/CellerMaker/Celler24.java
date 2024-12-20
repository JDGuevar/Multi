import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Celler24
{
    List<String> aList, hList, mList;
    PrintWriter writer;
    Random rnd = new Random(59);

    private final int numClientes;
    private final int numFactures;

    public Celler24(int numClientes, int numFactures)
    {
        this.numClientes = numClientes;
        this.numFactures = numFactures;

        try
        {
            aList = readData("apellidos.txt");
            hList = readData("hombres.txt");
            mList = readData("mujeres.txt");
            writer = new PrintWriter("celler.xml");
            writeData();
            writer.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println(e.getMessage());
        }
    }

    private List<String> readData(String filename) throws FileNotFoundException
    {
        List<String> list = new ArrayList<>();
        Scanner reader = new Scanner(new File(filename));

        while (reader.hasNextLine()) list.add(reader.nextLine());
        return list;
    }

    private void writeData()
    {
        writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
//        writer.println("<?xml-stylesheet type=\"text/xsl\" href=\"celler.xsl\"?>");
        writer.println("<?xml-stylesheet type=\"text/css\" href=\"celler.css\"?>");
        writer.println("<celler xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"celler.xsd\">");
//       writer.println("<celler>");
        crearProductes();
        crearClients();
        crearFactures();
        writer.println("</celler>");
    }

    private void crearProductes()
    {
        String[] vins = {"blanc", "negre", "rosat"};
        int[] mides = {1, 2, 3, 5};
        double[] preus = {1.5, 2.5, 3.5, 5.5};

        writer.println("<productes>");
        for (String vi : vins)
            for (int m = 0; m < mides.length; m++)
            {
                StringBuilder producte = new StringBuilder("<producte ");

                producte.append(String.format("codi=\"%s%d\" ", vi.substring(0,1).toUpperCase(Locale.ROOT), mides[m]));
                producte.append(String.format("preu=\"%.2f\">", preus[m]));
                producte.append(String.format("Vi %s %s ", vi, (mides[m] < 3) ? "botella" : "garrafa"));
                producte.append(String.format("%s", (mides[m] < 2) ? "d'" + mides[m] + " litre" : "de " + mides[m] + " litres"));
                producte.append("</producte>");
                writer.println(producte);
            }
        writer.println("</productes>");
    }

    private void crearClients()
    {
        int quin;

        writer.println("<clients>");
        for (int c = 1; c <= numClientes; c++)
        {
            writer.format("<client codi=\"C%05d\">%n", c);
            writer.print("<nom>");

            quin = rnd.nextInt(aList.size());
            writer.print(aList.get(quin));

            if (rnd.nextInt(9) != 4)
            {
                quin = rnd.nextInt(aList.size());
                writer.print(" " + aList.get(quin));
            }

            if (rnd.nextBoolean())
            {
                quin = rnd.nextInt(mList.size());
                writer.print(", " + mList.get(quin));

                if (rnd.nextInt(5) != 2)
                {
                    quin = rnd.nextInt(mList.size());
                    writer.print(" " + mList.get(quin));
                }
            }
            else
            {
                quin = rnd.nextInt(hList.size());
                writer.print(", " + hList.get(quin));

                if (rnd.nextInt(5) != 2)
                {
                    quin = rnd.nextInt(hList.size());
                    writer.print(" " + hList.get(quin));
                }
            }

            writer.println("</nom>");
            writer.format("<telefon>%d%02d %03d %03d</telefon>%n", 6 + rnd.nextInt(2), rnd.nextInt(100), rnd.nextInt(1000), rnd.nextInt(1000));
            if (rnd.nextBoolean())
                writer.format("<telefon>%d%02d %03d %03d</telefon>%n", 6 + rnd.nextInt(4), rnd.nextInt(100), rnd.nextInt(1000), rnd.nextInt(1000));
            writer.println("</client>");
        }
        writer.println("</clients>");
    }

    private void crearFactures()
    {
        String vins = "BNR";
        String mides = "1235";

        writer.println("<factures>");
        for (int f = 1; f <= numFactures; f++)
        {
            writer.format("<factura codi=\"F%06d\">%n", f);
            writer.format("<comprador codi=\"C%05d\"/>%n", 1 + rnd.nextInt(numClientes));

            int compra = 1 + rnd.nextInt(4096 - 1);
            int mascara = 1;

            for (int p = 0; p < 12; p++)
            {
                if ((compra & mascara) != 0)
                {
                    int vi = p / mides.length();
                    int mida = p % mides.length();
                    writer.format("<unitats codi=\"%c%c\">%d</unitats>%n", vins.charAt(vi), mides.charAt(mida), 1 + rnd.nextInt(5));
                }
                mascara <<= 1;
            }
            writer.println("</factura>");
        }
        writer.println("</factures>");
    }

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ROOT);
        new Celler24(10, 10);
    }
}
