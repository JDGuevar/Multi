public class NewArrays
{
    public static void main(String[] args)
    {
        int size = 10;

        if (args.length == 1)
        {
          size = Integer.parseInt(args[0]);
        }

        int[] numbers = new int[size];
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = i + 1;
            System.out.println(numbers[i]);
        }
    }
}
