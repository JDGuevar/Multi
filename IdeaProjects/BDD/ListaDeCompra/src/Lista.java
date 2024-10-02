import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Lista {

    String[] options = {"Add <todo>", "Print <n>", "PrintAll", "Done <todo number>", "ReOrder <item> <d position>", "Quit"};

    public Lista(){
        boolean option = true;
        List<String> Listas;
        Listas = new ArrayList<String>();
        while (option) {

            show();
            Scanner get = new Scanner(System.in);
            try {
                String op = get.nextLine().toLowerCase();

                String[] piece = op.split(" ");

                switch (piece[0]){

                    case "add":
                        try {
                            Listas.add(op.substring(4));
                        } catch (IndexOutOfBoundsException e){
                            System.out.println("no has introducido nada");
                        }
                        break;

                    case "print":
                        int n;
                         try {
                             if (piece.length < 2) {
                                 System.out.println("no ha indicado el numero de elementos a imprimir");
                                 break;
                             }
                             n = Integer.parseInt(piece[1]);
                         }catch (InputMismatchException e){
                             System.out.println("no ha indicado el numero de elementos a imprimir");
                             break;
                         }
                        for (int i = 0; i < n; i++) System.out.println(Listas.get(i));
                        break;

                    case "printall":
                        for (String s : Listas) System.out.println(s); break;

                    case "done":
                        int m;
                        try {
                            m = Integer.parseInt(piece[1]);
                        } catch (InputMismatchException e){
                        System.out.println("no ha indicado el numero del elemento");
                        break;
                        }
                        Listas.remove(m);
                        break;

                    case "reorder":
                        int l, s;
                        try {
                            if (piece.length < 3) {
                                System.out.println("no ha indicado correctamente los index");
                                break;
                            }

                            l = Integer.parseInt(piece[1]) - 1;
                            s = Integer.parseInt(piece[2]) - 1;

                            if (l < 0 || l >= Listas.size() || s < 0 || s >= Listas.size()) {
                                System.out.println("no ha indicado correctamente los index");
                                break;
                            }
                        } catch (InputMismatchException e){
                            System.out.println("no ha indicado el numero del elemento");
                            break;
                        }

                        String temp = Listas.get(l);
                        Listas.remove(l);
                        Listas.add(s, temp);
                        break;

                    case "quit": option = false ; break;
                    default:
                        System.out.println("no se han introducido datos correctos");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("no has introducido datos correctos");
            }
        }
    }
    public void show() {

        for (String option : options) {

            System.out.println(option);
        }
    }
}