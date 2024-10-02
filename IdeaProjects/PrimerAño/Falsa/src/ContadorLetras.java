import java.text.Normalizer;

public class ContadorLetras
{
    public static void main(String[] args)
    {
        String frase = "Tres tristes tigres comen trigo en un trigal";

        frase =   Normalizer
                .normalize(frase, Normalizer.Form.NFD)
                .toLowerCase()
                .replaceAll("[^a-z]", "");

        int[] ocurrencias = new int[26];
        int maxocurrencias = 0;
        char letraRecurrente = ' ';

        for (int i = 0; i < frase.length(); i++)
        {
            char letraActual = frase.charAt(i);

            ocurrencias[letraActual - 'a']++;

            if (ocurrencias[letraActual - 'a'] > maxocurrencias){

                maxocurrencias = ocurrencias[letraActual - 'a'];
                letraRecurrente = letraActual;
            }
        }
        System.out.println("La letra que más sale es: " + letraRecurrente + " y sale " + maxocurrencias + " veces.");
    }
}