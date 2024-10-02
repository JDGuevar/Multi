import java.text.Normalizer;
import java.util.SortedMap;

public class Palindromo
{
    public static void main(String[] args)
    {
        String input= "";

        for (int i = 0; i < args.length; i++)
        {
            input += args[i];
        }

        System.out.println(input);

        input =   Normalizer
                        .normalize(input, Normalizer.Form.NFD)
                        .toLowerCase()
                        .replaceAll("[^a-z]", "");

        System.out.println(input);

        for (int i = 0; i < (input.length() / 2); i++ )
        {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i))
            {
                System.out.println("No es palíndromo");
                System.exit(444);
            }
        }
        System.out.println("Es palíndromo");
    }
}
