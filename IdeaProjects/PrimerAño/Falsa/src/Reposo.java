public class Reposo {
    public static void main(String[] args) {

        int[] input= new int[args.length];

        for (int i = 0; i < args.length; i++)
        {
            input[i] = Integer.parseInt(args[i]);
            System.out.println(input[i]);
        }

    }
}
