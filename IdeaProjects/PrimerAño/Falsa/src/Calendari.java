public class Calendari
{
    static String[] nomDies = {"Lun", "Mar", "Mie", "Jue", "Vie", "Sab", "Dom"};

    static String[] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};

    static int mes, any;

    static int[] diesMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args)
    {
        if (args.length != 2)
        {
            System.out.println("Debes de introducir una fecha en formato: mm yyyy");
            System.exit(4);
        }

        mes = Integer.parseInt(args[0]);
        any = Integer.parseInt(args[1]);


        if (!dataCorrecta(mes,any)) System.exit(3);

        if ( ((any % 4 == 0) && (any % 100 != 0)) || (any % 400 == 0) ) diesMes[1] = 29;

        html();
    }

    static void html(){
        System.out.println("<!DOCTYPE html>");
        System.out.println("<html lang=\"es\">");
        head();
        body();
        System.out.println("</html>");
    }

    static void head(){
        System.out.println("<head>");
        System.out.println("<meta charset=\"UTF-8\">");
        System.out.printf("<title>%s %d</title>\n",meses[mes-1], any);
        System.out.println("<style>");
        System.out.print("td{\n" +
                "border: solid 2pt black;\n" +
                "font-size: 20pt;\n" +
                "height: 30px;\n" +
                "width: 60px;\n" +
                "text-align: center;\n" +
                "}\n\n" +
                "table{\n" +
                "border-collapse: collapse;\n" +
                "}\n" +
                "body {\n" +
                "display: flex;\n" +
                "justify-content: center;\n" +
                "align-items: center;\n" +
                "height: 100vh;\n" +
                "}\n");
        System.out.println("</style>");
        System.out.println("</head>");
    }

    static void body(){
        System.out.println("<body>");
        table();
        System.out.println("</body>");
    }

    static void table(){
        int contdia = diasemana(mes,any);
        System.out.println("<table>");
        System.out.println("<tr>");
        System.out.println("<td colspan = \"7\">");
        System.out.printf("%s %d",meses[mes-1], any);
        System.out.println("</td>");
        System.out.println("</tr>");

        System.out.println("<tr>");
        for (String nomdia:nomDies){
            System.out.print("<td>");
            System.out.format("%s",nomdia);
            System.out.print("</td>");
        }
        System.out.println("</tr>");

        System.out.println("<tr>");
        for (int i = 0; i<diasemana(mes,any);i++){
            System.out.print("<td>&nbsp;</td>");
        }

        for (int i = 1; i<= diesMes[mes-1]; i++) {
            System.out.print("<td>");
            System.out.printf("%d", i);
            System.out.print("</td>");
            if (++contdia % 7 == 0) System.out.print("</tr>\n<tr>");
        }
        System.out.println("</tr>");

        System.out.println("</table>");
    }

    static boolean dataCorrecta(int mes, int any){
        if (any < 1 || (mes < 1 || mes > 12)){
            System.err.println("Data incorrecta");
            return false;
        }
        return true;
    }

    static int diasemana(int mes, int any){
        int a = (14 - mes) / 12;
        int y = any - a;
        int m = mes + 12 * a - 2;
        int d = (1 + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12) % 7;

        return (d + 6) % 7;
    }
}