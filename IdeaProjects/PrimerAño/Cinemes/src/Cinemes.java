import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Cinemes{

    public static void main(String[] args) {
        final int NUM_SALES = 8;
        final int AFORAMENT = 400;
        final int PREU_MAJOR_EDAT = 16;
        final int PREU_MINOR_EDAT = 8;

        try {
            FileWriter fitxer = new FileWriter("Cinemes.txt");
            PrintWriter escriptorFitxer = new PrintWriter(fitxer);

            // Simulació per a cada dia del mes
            for (int dia = 1; dia <= 30; dia++) {
                escriptorFitxer.println("Dia " + dia + ":");

                // Simulació per a cada sala
                for (int sala = 1; sala <= NUM_SALES; sala++) {
                    int assistenciaSala = 0;
                    int assitenciaMayorSala = 0;
                    int assitenciaMenorSala = 0;
                    int recaptacioSala = 0;
                    int recaptacioMayorSala = 0;
                    int recaptacioMenorSala = 0;

                    // Determinar si és cap de setmana o no
                    boolean capDeSetmana = (dia % 7 == 0 || dia % 7 == 6);
                    int sesion = 3;
                    if (capDeSetmana) sesion=5;
                    // Simulació de les sessions diàries i els caps de setmana
                    for (int sessio = 1 ; sessio <= sesion; sessio++) {
                        int assistenciaSessio = 0;
                        int assistenciaMayorSessio = 0;
                        int assistenciaMenorSessio = 0;
                        int recaptacioSessio = 0;
                        int recaptacioMayorSessio = 0;
                        int recaptacioMenorSessio = 0;

                        // Simulació de l'assistència a la sessió
                        assistenciaSessio = (int) (Math.random() * (AFORAMENT * 0.2)) + (int) (AFORAMENT * 0.8);

                        int contado = 0;
                        while (contado < assistenciaSessio){
                            List MyList = new List();
                            for(int i = 0; i < Math.random() * 10; i++){
                                int edat = (int) (Math.random() * 100); // edat aleatòria entre 0 i 99
                                if (edat >= 18) {
                                    recaptacioSessio += PREU_MAJOR_EDAT;
                                    recaptacioMayorSessio += PREU_MAJOR_EDAT;
                                    assistenciaMayorSessio++;
                                } else if (edat >= 8) {
                                    recaptacioSessio += PREU_MINOR_EDAT;
                                    recaptacioMenorSessio += PREU_MINOR_EDAT;
                                    assistenciaMenorSessio++;
                                }
                                MyList.insert(edat);
                            }
                            if (MyList.mayorInList(18)) contado+= MyList.getLength();
                        }

                        // Actualitzar els totals de la sala
                        assistenciaSala += assistenciaSessio;
                        assitenciaMayorSala += assistenciaMayorSessio;
                        assitenciaMenorSala += assistenciaMenorSessio;
                        recaptacioSala += recaptacioSessio;
                        recaptacioMayorSala += recaptacioMayorSessio;
                        recaptacioMenorSala += recaptacioMenorSessio;

                        double porcentajeMayorASessio = 100 * ((double) assistenciaMayorSessio / assistenciaSessio);
                        double porcentajeMenorASessio = 100 * ((double) assistenciaMenorSessio / assistenciaSessio);
                        double porcentajeMinorde8Sessio = 100 * ((double) (assistenciaSessio - assistenciaMayorSessio - assistenciaMenorSessio) / assistenciaSessio);

                        double porcentajeMayorSessio = 100 * ((double) recaptacioMayorSessio / recaptacioSessio);
                        double porcentajeMenorSessio = 100 * ((double) recaptacioMenorSessio / recaptacioSessio);


                        // Escriure les dades de la sessió al fitxer
                        escriptorFitxer.println("Sala " + sala + ", Sessió " + sessio + ":");
                        escriptorFitxer.printf("  Assistència:%d persones. Major:%.2f%c Minor:%.2f%c Minor de 8:%.2f%c\n", assistenciaSessio, porcentajeMayorASessio, '%', porcentajeMenorASessio, '%', porcentajeMinorde8Sessio, '%');
                        escriptorFitxer.printf("  Recaptació:%d euros. Major:%.2f%c Minor:%.2f%c\n", recaptacioSessio, porcentajeMayorSessio, '%', porcentajeMenorSessio, '%');
                    }

                    double porcentajeMayorASala = 100 * ((double) assitenciaMayorSala / assistenciaSala);
                    double porcentajeMenorASala = 100 * ((double) assitenciaMenorSala / assistenciaSala);
                    double porcentajeMinorde8Sala = 100 * ((double) (assistenciaSala - assitenciaMayorSala - assitenciaMenorSala) / assistenciaSala);

                    double porcentajeMayorSala = 100 * ((double) recaptacioMayorSala / recaptacioSala);
                    double porcentajeMenorSala = 100 * ((double) recaptacioMenorSala / recaptacioSala);

                    // Escriure els totals de la sala al fitxer
                    escriptorFitxer.println("Total Sala " + sala + ":");
                    escriptorFitxer.printf("  Assistència total:%d persones. Major:%.2f%c Minor:%.2f%c Minor de 8:%.2f%c\n",assistenciaSala, porcentajeMayorASala, '%', porcentajeMenorASala, '%', porcentajeMinorde8Sala, '%');
                    escriptorFitxer.printf("  Recaptació total:%d euros. Major:%.2f%c Minor:%.2f%c\n", recaptacioSala, porcentajeMayorSala, '%', porcentajeMenorSala, '%');
                    escriptorFitxer.println();
                }
            }

            escriptorFitxer.close();
            fitxer.close();
        } catch (IOException e) {
            System.out.println("Error en escriure el fitxer: " + e.getMessage());
        }
    }
}
