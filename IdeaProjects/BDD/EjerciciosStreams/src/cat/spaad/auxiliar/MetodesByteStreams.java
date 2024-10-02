package cat.spaad.auxiliar;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MetodesByteStreams {

    public void llegeixBytes(String origen){
        try(FileInputStream file = new FileInputStream(origen)) {
            int c;
            while ((c = file.read()) != -1){
                System.out.print((byte)c);
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    public void escriuBytes(String desti, byte[] dades){
        try (FileOutputStream file = new FileOutputStream(desti)){
            file.write(dades);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
