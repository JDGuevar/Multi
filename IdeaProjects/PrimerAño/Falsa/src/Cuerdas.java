public class Cuerdas
{
    public static void main(String[] args)
    {
        String[] nomDies = {"Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenge"};

        for (String dia: nomDies)
        {
            for (int i = 0; i < dia.length(); i += 2)
            {
                int j = Math.min(i + 2, dia.length());

                System.out.format("%s\n",(dia.substring(i, j)));
            }

            dia.matches(".");
        }

        /*
        for (int j = 0; j < nomDies.length; j++)
        {
            System.out.println(nomDies[j]);
            for (int i = 1; i < nomDies[j].length(); i++)
            {
                System.out.println(nomDies[j].charAt(i));
            }
            System.out.println();
        }*/
    }
}
