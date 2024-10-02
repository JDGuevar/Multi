public class StringQuartet
{
    public static void main(String[] args)
    {

        if (args.length != 3)
        {
            System.out.println("Debes de introducir una fecha en formato: dd mm yyyy");
            System.exit(4);
        }

        int dia = Integer.parseInt(args[0]);
        int mes = Integer.parseInt(args[1]);
        int any = Integer.parseInt(args[2]);

        String[] nomDies = {"Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenge"};

        int[] diesMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (any < 1 || (mes < 1 || mes > 12) || (dia < 1 || dia > diesMes[mes - 1]))
        {
            System.out.println("Data incorrecta");
            System.exit(3);
        }

        if ( ((any % 4 == 0) && (any % 100 != 0)) || (any % 400 == 0) )
        {
            diesMes[1] = 29;
        }

        int a = (14 - mes) / 12;
        int y = any - a;
        int m = mes + 12 * a - 2;
        int d = (dia + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12) % 7;

        System.out.println(nomDies[(d + 6) % 7]);



        /*
        for (String nomDia : nomDies) {

            System.out.println(nomDia);
        }
        for (int i = nomDies.length - 1; i >= 0; i--)
        {
            System.out.println(nomDies[i]);
        }
        for (int i = 0; i < nomDies.length; i++)
        {
            System.out.println(nomDies[nomDies.length - i - 1]);
        }

        int [] reverso = {6, 5, 4, 3, 2, 1, 0};
        for (int i : reverso)
        {
            System.out.println(nomDies[i]);
        }
        */


    }
}
