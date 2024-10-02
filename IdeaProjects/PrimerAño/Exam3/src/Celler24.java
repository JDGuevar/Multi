import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Celler24
{
    List<String> aList, hList, mList;
    Random rnd = new Random(666);

    private final int numClientes;
    private final int numFactures;

    /* En esta clase no se hace la gran cosa más que los cambios que se pueden imaginar al cambiar de formato, en lugar de abrir y cerrar etiquetas separo los datos con comas y sin espacios en blanco, los saltos de línea son únicamente para separar las filas de datos tal como es el formato csv. Hago el comentario entero aquí, ya que no es para nada distinto al anterior, solo quito etiquetas y agrego comas */

    public Celler24(int numClientes, int numFactures)
    {
        this.numClientes = numClientes;
        this.numFactures = numFactures;

        try
        {
            aList = readData("apellidos.txt");
            hList = readData("hombres.txt");
            mList = readData("mujeres.txt");
            crearProductes();
            crearClients();
            crearFactures();
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

    private void crearProductes() throws FileNotFoundException {
        String[] vins = {"blanc", "negre", "rosat"};
        int[] mides = {1, 2, 3, 5};
        double[] preus = {1.5, 2.90, 4.35, 7.25};

        PrintWriter writer = new PrintWriter("productes.csv");
        for (String vi : vins)
            for (int m = 0; m < mides.length; m++)
            {
                StringBuilder producte = new StringBuilder();

                producte.append(String.format("%s%d,", vi.substring(0,1).toUpperCase(Locale.ROOT), mides[m]));
                producte.append(String.format("%.2f,", preus[m]));
                producte.append(String.format("Vi %s %s,", vi, (mides[m] < 3) ? "botella" : "garrafa"));
                producte.append(String.format("%s", mides[m] + " litres"));

                writer.println(producte);
            }
        writer.close();
    }

    private void crearClients() throws FileNotFoundException {
        int quin;
        PrintWriter writer = new PrintWriter("clients.csv");

        for (int c = 1; c <= numClientes; c++)
        {
            writer.format("C%05d,", c);
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
                writer.print(" " + mList.get(quin));

                if (rnd.nextInt(5) != 2)
                {
                    quin = rnd.nextInt(mList.size());
                    writer.print(" " + mList.get(quin));
                }
            }
            else
            {
                quin = rnd.nextInt(hList.size());
                writer.print(" " + hList.get(quin));

                if (rnd.nextInt(5) != 2)
                {
                    quin = rnd.nextInt(hList.size());
                    writer.print(" " + hList.get(quin));
                }
            }

            writer.print(",");
            writer.format("%d%02d %03d %03d,", 6 + rnd.nextInt(2), rnd.nextInt(100), rnd.nextInt(1000), rnd.nextInt(1000));
            if (rnd.nextBoolean())
                writer.format("%d%02d %03d %03d", 6 + rnd.nextInt(4), rnd.nextInt(100), rnd.nextInt(1000), rnd.nextInt(1000));
            writer.println();
        }
        writer.close();
    }

    private void crearFactures() throws FileNotFoundException {
        String vins = "BNR";
        String mides = "1235";
        PrintWriter writer = new PrintWriter("factures.csv");

        for (int f = 1; f <= numFactures; f++)
        {
            writer.format("F%06d,", f);
            writer.format("C%05d,", 1 + rnd.nextInt(numClientes));

            int compra = 1 + rnd.nextInt(4096 - 1);
            int mascara = 1;

            for (int p = 0; p < 12; p++)
            {
                if ((compra & mascara) != 0)
                {
                    int vi = p / mides.length();
                    int mida = p % mides.length();
                    writer.format("%c%c,%d,", vins.charAt(vi), mides.charAt(mida), 1 + rnd.nextInt(5));
                }
                mascara <<= 1;
            }
            writer.println();
        }
        writer.close();
    }

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ROOT);
        new Celler24(10, 100);
    }
}
