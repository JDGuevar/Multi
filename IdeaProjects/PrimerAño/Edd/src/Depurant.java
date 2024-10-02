import java.text.SimpleDateFormat;
import java.util.Date;

public class Depurant {
    public static final int[] taula = {1, 61, 3, 101, 34, -57, 173, 16, 119, 4, 472, 9, 6, 14, -123};

    public static String formatar(Date dia,int tipus) {
        String cad = "";
        SimpleDateFormat data;

        switch (tipus) {
            case 1:
                data = new SimpleDateFormat("yyyy/MM");
                cad = data.format(dia);
                break;
            case 2:
                data = new SimpleDateFormat("dd/MM/yyyy");
                cad = data.format(dia);
                break;
            case 3:
                data = new SimpleDateFormat("MM/yy");
                cad = data.format(dia);
                break;
            default:
                cad = "ERROR";
        }

        return cad;

    }
    public static void main(String[] args) {
        int suma = 0;
        for (int i = 0; i < taula.length; ++i)
            suma += taula[i];
        System.out.println("La suma és "+suma);

        int max = -999;
        for (int i = 0; i < taula.length; i++) {
            if (taula[i]>max)
                max = taula[i];
        }
        System.out.println("El màxim és "+max);

        int cont = 0;
        for (int i = 0; i < taula.length; i++) {
            if (taula[i]>=0 && taula[i]<=100)
                cont++;
        }
        System.out.println("Entre 0 i 100 tenim "+cont+" números");

        int parell = 0;
        for (int i = 0; i < taula.length; i++) {
            if (taula[i]%2==0)
                ++parell;
        }
        System.out.println("Tenim "+parell+" números parells");

        System.out.println();
        Date avui = new Date();

        System.out.println("Avui és "+formatar(avui,2));
    }
}