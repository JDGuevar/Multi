import java.io.*;

public class Partida {
    private Campeon[] equipoRojo = new Campeon[5];
    private Campeon[] equipoAzul = new Campeon[5];
    public Partida(){
        crearPartida();
    }

    private void crearPartida(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("campions.txt"));
            int contador = 0;
            while (contador < 10){
                String campeon = br.readLine();
                if (campeon == null || campeon.isEmpty())  br = new BufferedReader(new FileReader("campions.txt"));;
                String[] parts = campeon.split("#");

                if((int)(Math.random()*101) > 50){
                    String nom = parts[0];
                    String rol = parts[1];

                    if (contador < 5){
                        switch (rol){
                            case "Top":
                                equipoRojo[contador] = new Top(nom, rol);
                                break;
                            case "Jungla":
                                equipoRojo[contador] = new Jungla(nom, rol);
                                break;
                            case "Mid":
                                equipoRojo[contador] = new Mid(nom, rol);
                                break;
                            case "ADC":
                                equipoRojo[contador] = new ADC(nom, rol);
                                break;
                            case "Support":
                                equipoRojo[contador] = new Supp(nom, rol);
                                break;
                        }
                    } else {
                        switch (rol){
                            case "Top":
                                equipoAzul[contador-5] = new Top(nom, rol);
                                break;
                            case "Jungla":
                                equipoAzul[contador-5] = new Jungla(nom, rol);
                                break;
                            case "Mid":
                                equipoAzul[contador-5] = new Mid(nom, rol);
                                break;
                            case "ADC":
                                equipoAzul[contador-5] = new ADC(nom, rol);
                                break;
                            case "Support":
                                equipoAzul[contador-5] = new Supp(nom, rol);
                                break;
                        }
                    }
                    contador++;

                }
            }
            crearEnemistades();
            crearAliadosCercanos();

        }catch (IOException e){
            System.err.println("Algo fue mal con la generación de campeones");
        }

    }

    public void crearEnemistades(){
        for (int i = 0; i < 5; i++){
            equipoRojo[i].setEnemigo(equipoAzul[i]);
            equipoAzul[i].setEnemigo(equipoRojo[i]);
        }
    }

    public void crearAliadosCercanos(){
        for (int i = 0; i < 5; i++){
            equipoRojo[i].setAliadoCercano(equipoRojo[(i+1)%5]);
            equipoAzul[i].setAliadoCercano(equipoAzul[(i+1)%5]);
        }
    }

    public void guardarPartida(){
        try {
            PrintWriter pw = new PrintWriter("games.txt");
            pw.println("Equipo Rojo: ");
            for (int i = 0; i < 5; i++){
                pw.println(equipoRojo[i].getNombre() + " " + equipoRojo[i].getRol() + " Vida Actual: " + equipoRojo[i].getHPActual() + ", Objeto Equipado: " + equipoRojo[i].getObjeto().getNombre());
            }
            pw.println("Equipo Azul: ");
            for (int i = 0; i < 5; i++){
                pw.println(equipoAzul[i].getNombre() + " " + equipoAzul[i].getRol() + " Vida Actual;" + equipoAzul[i].getHPActual() + ", Objeto Equipado: " + equipoAzul[i].getObjeto().getNombre());
            }
            pw.close();
        } catch (FileNotFoundException e) {
            System.err.println("Algo fue mal con el guardado");;
        }

    }

}
