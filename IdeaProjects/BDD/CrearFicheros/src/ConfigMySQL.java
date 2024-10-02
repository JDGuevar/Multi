import java.io.FileOutputStream;
import java.util.Properties;

public class ConfigMySQL {
    public ConfigMySQL(){
        Properties prop = new Properties();
        escriuConfig(prop);
    }

    public void escriuConfig(Properties prop){
        prop.setProperty("port", "3306");
        prop.setProperty("socket", "/var/run/mysqld/mysqld.sock");
        prop.setProperty("key_buffer_size", "16M");
        prop.setProperty("max_allowed_packet", "16M");
        try {
            prop.store(new FileOutputStream("mysql.conf"), "Configuració de MySQL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new ConfigMySQL();
    }
}
