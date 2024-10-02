import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        List MyList = new List();
        try (Scanner scanner = new Scanner(new File("hombres.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.indexOf(' ') >= 0) {
                    String[] words = line.split(" ");
                    for (String word : words) {
                        MyList.insertUnique(capitalize(word));
                        if (MyList.getLength() >= 500) break;
                    }
                } else {
                    MyList.insertUnique(capitalize(line));
                    if (MyList.getLength() >= 500) break;
                }

            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        MyList.sort();
        MyList.show();

        try (PrintWriter printer = new PrintWriter("hombres500.txt")) {
            Node work = MyList.getFirst();
            while (work != null) {
                printer.println(work.getInformation());
                work = work.getNext();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(System.currentTimeMillis() - s + " ms");
    }

    public static String capitalize(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }
}