import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestioCeller {
    private final List<String> pList = new ArrayList<>() ;
    private final List<String> cList = new ArrayList<>();
    private final List<String> fList = new ArrayList<>();
    public GestioCeller() {
        /* he optado por leer los archivos en el constructor para no tener que hacerlo cada vez que se llama a un método, ya que los datos no cambian durante la ejecución del programa*/
        readPList();
        readCList();
        readFList();

        Menu principal = new Menu("MENÚ PRINCIPAL", "Facturas de un cliente", "Productos vendidos"); //este menú es el que hemos hecho en clases anteriores, lo he reutilizado descaradamente, ya que es bastante sencillo y útil pero tedioso de hacer durante tiempo de examen
        int option = -1;
        while (option != 0) {
            option = principal.getOption();

            switch (option) {
                case 0 -> pass();
                case 1 -> {
                    System.out.println("Introduce el código del cliente");
                    Scanner get = new Scanner(System.in);

                    //no continua si no es un número entero y está dentro del rango de clientes
                    int codi = -1;
                    while (codi <= 0 || codi > cList.size()){ //he optado por hacer un control de entrada dentro del while y aprovechar el catch de la excepción para mostrar el mensaje de error
                        try {
                            System.out.println("Debe ser un número entre 0 y " + cList.size() + " (0 no incluido)");
                            codi = get.nextInt();
                        } catch (Exception e){
                            System.out.println("Introduce un código dentro del rango de clientes, actualmente hay " + cList.size() + " clientes");
                            get.nextLine();
                        }
                    }
                    String client = Integer.toString(codi); //convierto el número a string para poder compararlo con el código del cliente en las facturas, escribí todo el metodo clientFactures para que acepte un string y no un int
                    clientFactures(client);
                }
                case 2 -> ventas();
                default -> System.out.println("Opción inválida");
            }
        }
    }

    private void clientFactures(String codi){
        System.out.println("Facturas del cliente: " + codi);
        double total = 0;
        for (String f : fList){
            String[] parts = f.split(",");
            String codiFactura = parts[1].substring(parts[1].length() - codi.length()); // obtengo los últimos dígitos del código de la factura para compararlos con el código del cliente, ya que el entero entregado en la variable codi tiene menos dígitos
            if (codiFactura.equals(codi)){
                total += calcularFactura(f); //calculo el total de la factura y lo sumo al total de todas las facturas, pues el método calcularFactura devuelve el total de la factura actual
            }
        }
        System.out.printf("Importe total: %.02f\n", total);
    }

    private double calcularFactura(String factura){
        String[] parts = factura.split(",");
        double total = 0;
        for (int i = 2 ; i < parts.length; i+=2){
            for (String p : pList){
                String[] partsPList = p.split(",");
                if (partsPList[0].equals(parts[i])){
                    total += Double.parseDouble(partsPList[1]) * Double.parseDouble(parts[i+1]); //precio del producto * unidades vendidas, se suma al total de la factura
                }
            }
        }
        System.out.printf("Factura: %s - Total: %.02f\n", parts[0], total);
        return total;
    }

    private void ventas(){
        System.out.println("Ventas de productos");
        for (String p : pList){
            String[] parts = p.split(",");
            double total = 0;
            int unidades = 0;
            for (String f : fList){
                String[] partsF = f.split(",");
                for (int i = 2; i < partsF.length; i+=2){
                    if (partsF[i].equals(parts[0])){
                        total += Double.parseDouble(parts[1]) * Double.parseDouble(partsF[i+1]); //precio del producto * unidades vendidas, se suma al total de las ventas del producto, un poco la inversa de lo que he hecho en el anterior método.
                        unidades += Integer.parseInt(partsF[i+1]);
                    }
                }
            }
            System.out.printf("Producto: %s %s - UnidadesVendidas: %d - ImporteTotal: %.02f\n", parts[2], parts[3], unidades, total);
        }
    }

    private void pass() {
    }

    // a partir de aquí solamente se leen los archivos de una manera corriente, no hay nada interesante, solo es la parte de la carga de archivos a la memoria tal como lo hemos hecho en clases anteriores

    private void readPList(){
        try (Scanner reader = new Scanner(new File("productes.csv"))){
            while (reader.hasNextLine()){
                pList.add(reader.nextLine());
            }
        } catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }
    }

    private void readCList(){
        try (Scanner reader = new Scanner(new File("clients.csv"))){
            while (reader.hasNextLine()){
                cList.add(reader.nextLine());
            }
        } catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }
    }

    private void readFList(){
        try (Scanner reader = new Scanner(new File("factures.csv"))){
            while (reader.hasNextLine()){
                fList.add(reader.nextLine());
            }
        } catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new GestioCeller();
    }
}
