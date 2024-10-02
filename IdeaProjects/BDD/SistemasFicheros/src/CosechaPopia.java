import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.*;

public class CosechaPopia {
    public CosechaPopia(){
        System.out.println("Cosecha popia");
        String path = "C:\\Users\\Alumne\\Documents\\Mashi.jpg";
        ParaQue(Luego(Muitos(DiganQue(AquiNoSe(Treballa(path))))));
    }

    public Path AquiNoSe(Path p1){
        System.out.println("Es un archivo: " + Files.isRegularFile(p1));
        System.out.println("Es leible: "+Files.isReadable(p1));
        System.out.println("Es editable: "+Files.isWritable(p1));
        System.out.println("Es ejecutable: "+Files.isExecutable(p1));
        System.out.println("Es un directorio: "+Files.isDirectory(p1));
        return p1;
    }

    public Path Treballa(String path){
        Path p1 = Paths.get(path);
        System.out.println(p1);
        System.out.println(p1.getFileName());
        System.out.println(p1.getName(1));
        System.out.println(p1.getNameCount());
        System.out.println(p1.subpath(0, 2));
        return p1;
    }

    public Path DiganQue(Path p1){
        Path p2 = Paths.get("C:\\Users\\Alumne\\Desktop\\Mashi.jgg");
        try {
            Files.copy(p1, p2, REPLACE_EXISTING);
        }catch (Exception e){
            System.out.println("Error: "+e);
        }
        return p2;
    }

    public Path Muitos(Path p1){
        Path p2 = Paths.get("C:\\Users\\Alumne\\Desktop\\Trasteo\\Mashi.jpg");
        try {
            Files.move(p1, p2, REPLACE_EXISTING);
        }catch (Exception e){
            System.out.println("Error: "+e);
        }
        return Paths.get("C:\\Users\\Alumne\\Desktop\\Trasteo");
    }

    public Path Luego(Path p1){
        Path p2 = null;
        try {
            p2 = Paths.get("C:\\Users\\Alumne\\Documents\\Trasteo");
            if (!Files.exists(p2)) Files.createDirectory(p2);
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(p1)) {
                for (Path file: stream) {
                    System.out.println(file.toString());
                    Files.copy(file, p2.resolve(file.getFileName()), REPLACE_EXISTING);
                }
            }
        }catch (Exception e){
            System.out.println("Error: "+e);
        }
        return Paths.get("C:\\Users\\Alumne\\Documents");
    }

    public static void ParaQue(Path dir) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {

            for (Path element : stream) {
                if (Files.isDirectory(element)) {
                    System.out.println(element.toAbsolutePath());
                    ParaQue(element);
                } else {
                    System.out.println(element.getFileName());
                }
            }
        }
        catch (IOException ioe) {
            System.err.println("a tomar por culo la cartera");
        }
    }

    public static void main(String[] args) {
        new CosechaPopia();
    }
}
