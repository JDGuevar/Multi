public class Horari {

    static String[] modul={
        "Programació",
        "Formació<br>i orientació<br>laboral",
        "Llenguatges<br>de marques",
        "Sistemes<br>informàtics",
        "Entorns de<br>desenvolupament",
        "Database<br>management"
    };

    static String[] clase={
            "prog",
            "fol",
            "lmm",
            "sin",
            "edd",
            "bdd"
    };

    static  String[] dies = {
            "Dilluns",
            "Dimarts",
            "Dimecres",
            "Dijous",
            "Divendres"
    };

    static  String[] hores = {
            "15:10<br>16:05",
            "16:05<br>17:00",
            "17:15<br>18:10",
            "18:10<br>19:05",
            "19:20<br>20:15",
            "20:15<br>21:10"
    };

    static String[] horari = {
        "G00D00D10D20D30D40",
        "H01M03M13M22M32M41",
        "H11            M22",
        "H21      M02M52   ",
        "H31M53M51      M33",
        "H41   M42M52M02   ",
        "H51               "
    };

    public static void main(String[] args) {
        System.out.println("<!DOCTYPE html>");
        System.out.println("<html lang = \"es\">");
        head();
        body();
        System.out.println("</html>");
    }

    static void head(){
        System.out.println("<head>");
        System.out.println("<meta charset = \"UTF-8\"/");
        System.out.println("<title>Horario</title>");
        System.out.println("<link rel = \"stylesheet\" href = \"Horari.css\"/>");
        System.out.println("</head>");
    }

    static void body(){
        System.out.println("<body>");
        horario();
        System.out.println("</body>");
    }

    static void horario(){
        System.out.println("<table>");
        for (int i = 0; i < horari.length; i++){
            System.out.println("<tr>");
            
            for (int j = 0; j < horari[i].length(); j+=3){

                char a = horari[i].charAt(j);

                int b = horari[i].charAt(j+1) - '0';
                int c = horari[i].charAt(j+2) - '0';

                if (a==' ') continue;

                System.out.print("<td");

                switch (a){
                    case 'G':
                        System.out.print(" class = \"grp\"");
                        break;
                    case 'D':
                        System.out.print(" class = \"dia\"");
                        break;
                    case 'M':
                        System.out.printf(" class = \"%s\"", clase[b]);
                        break;
                    case 'H':
                        System.out.print(" class = \"hora\"");
                        break;
                }

                if(c>1){
                    System.out.printf(" rowspan= \"%d\"", c);
                }

                System.out.print(">");
                switch (a){
                    case 'G':
                        System.out.print("S1P");
                        break;
                    case 'D':
                        System.out.print(dies[b]);
                        break;
                    case 'M':
                        System.out.print(modul[b]);
                        break;
                    case 'H':
                        System.out.print(hores[b]);
                        break;
                }
                System.out.println("</td>");
            }
            System.out.println("</tr>");
        }
        System.out.println("</table>");
    }
}
