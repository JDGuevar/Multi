import java.util.Random;

public class Arrays
{
    public static void main(String[] args)
    {
        Random rnd= new Random(666);
        int[] matriculas = new int[10];

        for (int i = 0; i < matriculas.length ; i++)
        {
            matriculas[i] = rnd.nextInt(5,12);

            System.out.println(matriculas[i] + "");
        }

        for (int i = 0 ; i < matriculas.length - 1 ; i++)
        {
            for (int j = i + 1; j < matriculas.length ; j++)
            {
                if (matriculas[i] > matriculas[j])
                {
                    int t = matriculas[i];
                    matriculas[i] = matriculas[j];
                    matriculas[j] = t;
                }

            }
        }

        System.out.println();

        for (int i = 0; i < matriculas.length ; i++)
        {
            System.out.println(matriculas[i] + "");
        }

    }
}
