import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LlistaEmpleats {
    String patternID= "[0-9]{3}[a-z]{3}";
    String patternDataNaixment ="[0-9]{4}[-][0-9]{2}[-][0-9]{2}";

    String ID;
    String name;
    String dataNaixement;
    String tipus;
    public LlistaEmpleats(File file) {
        try (Scanner sc = new Scanner(file);
             PrintWriter pw = new PrintWriter("LlistaEmpleats.txt");){

            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                String[] dades = line.split("/");

                if (dades.length > 4){
                    if (dades[0].matches(patternID)) {
                        ID = dades[0];
                    }

                    if (!dades[1].isEmpty()) {
                        name = dades[1];
                    }

                    if (dades[2].matches(patternDataNaixment)) {
                        dataNaixement = dades[2];
                    }

                    if (dades[3].equals("f") || dades[3].equals("h")) {
                        tipus = dades[3];
                    }
                }

                if (dades.length == 4) {


                    Fixe fixe = new Fixe(ID, name, dataNaixement, 1800);
                    pw.printf("ID: %s \n" +
                            "Nom: %s \n" +
                            "Nascut al: %s \n" +
                            "%d\n" +
                            "****\n",fixe.getID(),fixe.getName(),fixe.getDataNaixement(),fixe.getSou());
                }

                if (dades.length == 5) {
                    int horesTrabajades = Integer.parseInt(dades[4]);
                    PerHores perHores = new PerHores(ID, name, dataNaixement, horesTrabajades);
                    pw.printf("ID: %s \n" +
                            "Nom: %s \n" +
                            "Nascut al: %s \n" +
                            "%d\n" +
                            "****\n",perHores.getID(),perHores.getName(),perHores.getDataNaixement(),perHores.getSou());
                }

            }
        }catch (FileNotFoundException e){
            System.out.println("No s'ha trobat el fitxer");
        }
    }
}
