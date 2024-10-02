import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cleaner {
    private String inputFilename;

    public Cleaner(String inputFilename) {
        this.inputFilename = inputFilename;
        List MyList = new List();

        try (Scanner scanner = new Scanner(new File(inputFilename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.indexOf(' ') >= 0) {
                    String[] words = line.split(" ");
                    for (String word : words) {
                        MyList.insert(word);
                    }
                } else {
                    String minus = line.substring(1).toLowerCase();
                    MyList.insert(line.substring(0, 1).toUpperCase() + minus);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        MyList.show();
    }
}
