public class MayorCuatro
{

    public static void main(String[] args)
    {
        double x, y, z, v, t;

        if (args.length != 4)
        {
            System.err.println("Four arguments needed");
            System.exit(-1);
        }
        try
        {
            x = Double.parseDouble(args[0]);
            y = Double.parseDouble(args[1]);
            z = Double.parseDouble(args[2]);
            v = Double.parseDouble(args[3]);

            if (x > y) {
                t = x;
                x = y;
                y = t;
            }
            if (y > z) {
                t = y;
                y = z;
                z = t;
            }
            if (z > v) {
                t = z;
                z = v;
                v = t;
            }
            if (x > y) {
                t = x;
                x = y;
                y = y;
            }
            if (y > z) {
                t = y;
                y = z;
                z = t;
            }
            if (x > y) {
                t = x;
                x = y;
                y = t;
            }

            System.out.println("sorted: " + x + " < " + y + " < " + z + " < " + v);

        }
        catch (NumberFormatException e)
        {
            System.err.println("Some arguments are not numbers");
            System.exit(-2);
        }
    }
}
