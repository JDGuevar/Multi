public class MajorSimple
{
    public static void main(String[] args)
    {
        double x, y;

        if (args.length != 2)
        {
            System.err.println("Escribe dos números tarado");
           System.exit(-1);
        }
        try
        {
            x= Double.parseDouble(args[0]);
            y= Double.parseDouble(args[1]);
            System.out.println((x<y) ? x + " < " + y : y + " < " + x);
        }
        catch (NumberFormatException e)
        {
            System.err.println("pon números animal");
            System.exit(-2);
        }
    }
}
