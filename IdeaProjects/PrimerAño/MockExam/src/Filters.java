import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;

public class Filters {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        PrintWriter html, css;

        try {
            html = new PrintWriter("filtres.html");
            css = new PrintWriter("filtres.css");

            String filter1 = "brightness";
            String filter2 = "contrast";

            double[] filter1Limits = {0.0, 2.0};
            double[] filter2Limits = {0.0, 2.0};

            int filter1Steps = 7;
            int filter2Steps = 7;

            double filter1Gap = (filter1Limits[1] - filter1Limits[0]) / (filter1Steps - 1);
            double filter2Gap = (filter2Limits[1] - filter2Limits[0]) / (filter2Steps - 1);

            for (int f1 = 0; f1 < filter1Steps; f1++){
                for (int f2 = 0; f2 < filter2Steps; f2++){
                    html.printf("<div>%s(%.2f)<br/>%s(%.2f)</div>\n", filter1, f1 * filter1Gap, filter2, f2 * filter2Gap);
                }
            }

            System.out.println("\nCSS\n");

            int contador = 0;

            for (int f1 = 0; f1 < filter1Steps; f1++){
                for (int f2 = 0; f2 < filter2Steps; f2++){
                    contador++;
                    css.printf("""
                            div > div:nth-of-type(%d):hover ~ img {
                                filter: %s(%.2f) %s(%.2f);
                            }

                            """, contador, filter1, f1 * filter1Gap, filter2, f2 * filter2Gap);
                }
            }
            html.close();
            css.close();

        }catch (FileNotFoundException e){
            System.err.println("Something went wrong");
            System.exit(1);
        }
    }
}
