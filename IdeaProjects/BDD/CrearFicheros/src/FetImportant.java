import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FetImportant {
    private PrintWriter pw = null;

    public FetImportant(){
        escribirArchivos();
        Scanner get = new Scanner(System.in);
        System.out.println("Introdueix el nombre del fitxer on vols llegir: \n2001\n2008\n2016");
        String fitxer = get.nextLine();
        try {
            int year = Integer.parseInt(fitxer);
            if (year == 2001 || year == 2008 || year == 2016) {
                try {
                    BufferedReader br = switch (year) {
                        case 2001 -> new BufferedReader(new FileReader("2001.txt"));
                        case 2008 -> new BufferedReader(new FileReader("2008.txt"));
                        case 2016 -> new BufferedReader(new FileReader("2016.txt"));
                        default -> null;
                    };
                    while (br.ready()) {
                        System.out.println(br.readLine());
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else {
                System.out.println("Any no vàlid");
            }
        } catch (InputMismatchException e) {
            System.out.println("Any no vàlid");
        }
    }

    public void escribirArchivos(){
        try {
            escribir2001();
            escribir2008();
            escribir2016();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void escribir2001() throws Exception{
        pw = new PrintWriter( new FileWriter("2001.txt"));
        pw.println("""
                2001.txt
                
                L'11 de setembre de 2001, 19 terroristes coordinats per al-Qaeda segrestaren quatre avions comercials
                dels quals n’estavellaren intencionadament dos a les Torres Bessones del World Trade Center a Nova York,
                ocasionant un total de 2.996 morts i 25.000 ferits.
                """);
        pw.close();
    }

    public void escribir2008() throws Exception{
        pw = new PrintWriter( new FileWriter("2008.txt"));
        pw.println("""
                2008.txt
                
                15 de setembre del 2008. Aquest és el dia que el banc Lehman Brothers es va declarar en fallida,
                disparant així una crisi financera mundial de la qual molts països, especialment a Europa, encara no
                s'han recuperat.
                """);
        pw.close();
    }

    public void escribir2016() throws Exception{
        pw = new PrintWriter( new FileWriter("2016.txt"));
        pw.println("""
                2016.txt
                
                23 de juny del 2016. És el dia que els britànics van votar a favor de sortir de la Unió Europea.
                """);
        pw.close();
    }

    public static void main(String[] args) {
        new FetImportant();
    }
}