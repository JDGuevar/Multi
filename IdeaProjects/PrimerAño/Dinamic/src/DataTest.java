import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class DataTest {
    public DataTest(){
        try(PrintWriter printer = new PrintWriter("data.txt")){
            printer.println(new Data(5));
            printer.println(new Data(8));
        }
        catch (Exception exception){
            System.err.println("Ni flores");
        }

        try(Scanner reader = new Scanner(new File("data.txt"))){
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                System.out.println(line);
            }
        }
        catch (Exception exception){
            System.err.println("OMG");
        }
    }
}
