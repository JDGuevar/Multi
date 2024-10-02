public class MajorTres
{

    public static void main(String[] args)
    {
        double x, y, z, t;

        if (args.length != 3)
        {
            System.err.println("Escribe tres números tarado");
            System.exit(-1);
        }
        try
        {
            x = Double.parseDouble(args[0]);
            y = Double.parseDouble(args[1]);
            z = Double.parseDouble(args[2]);

            if (x>y)
            {
               t=x;
               x=y;
               y=t;
            }
            if (x>z)
            {
                t=x;
                x=z;
                z=t;
            }
            if (y>z)
            {
                t=y;
                y=z;
                z=t;
            }

        }
        catch (NumberFormatException e)
        {
            System.err.println("pon números animal");
            System.exit(-2);
        }
    }
}
