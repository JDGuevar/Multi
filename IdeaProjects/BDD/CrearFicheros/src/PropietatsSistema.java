import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.util.Properties;

public class PropietatsSistema {
    private PrintWriter pw = null;
    public PropietatsSistema(){
        try {
            pw = new PrintWriter( new FileWriter("propietats_del_sistema.json"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        escriuPropietats();
        escriuPropietatsConfig();
    }

    public void escriuPropietats(){
        pw.println("{\n" +
                " \"jre.dir\": \"" + System.getProperty("java.home") + "\",\n" +
                " \"jre.version\": \"" + System.getProperty("java.version") + "\",\n" +
                " \"os.name\": \"" + System.getProperty("os.name") + "\",\n" +
                " \"os.version\": \"" + System.getProperty("os.version") + "\",\n" +
                " \"user.name\": \"" + System.getProperty("user.name") + "\",\n" +
                " \"file.separator\": \"" + FileSystems.getDefault().getSeparator() + "\"\n" +
                "}\n");
        pw.close();
    }

    public void escriuPropietatsConfig(){
        Properties prop = System.getProperties();
        prop.getProperty("jre.dir", System.getProperty("java.home"));
        prop.getProperty("jre.version", System.getProperty("java.version"));
        prop.getProperty("os.name", System.getProperty("os.name"));
        prop.getProperty("os.version", System.getProperty("os.version"));
        prop.getProperty("user.name", System.getProperty("user.name"));
        prop.getProperty("file.separator", FileSystems.getDefault().getSeparator());
        try {
            prop.store(new FileOutputStream("propietats_del_sistema.props"), "Propietats del sistema");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new PropietatsSistema();
    }
}