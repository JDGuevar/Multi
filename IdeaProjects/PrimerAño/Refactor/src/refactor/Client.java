package refactor;

import java.text.SimpleDateFormat;
import java.util.Vector;

/**
 * Clase Client
 * @author Jose Y Albert
 */
public class Client {
    private String nif;
    private String nom;
    private String telefon;
    private Vector<Lloguer> lloguers;
    private final int EUROS_PER_UNITAT_DE_COST = 30;

    /**
     * Constructor de la clase Client
     * @param nif String
     * @param nom String
     * @param telefon String
     */
    public Client(String nif, String nom, String telefon) {
        this.nif = nif;
        this.nom = nom;
        this.telefon = telefon;
        this.lloguers = new Vector<Lloguer>();
    }

    /**
     * Getter del NIF
     * @return nif String
     */
    public String getNif() { return nif; }

    /**
     * Getter del nombre
     * @return nom String
     */
    public String getNom() { return nom; }

    /**
     * Getter del teléfono
     * @return telefon String
     */
    public String getTelefon() { return telefon; }

    /**
     * Setter del NIF
     * @param nif String
     */
    public void setNif(String nif) { this.nif = nif; }

    /**
     * Setter del nombre
     * @param nom String
     */
    public void setNom(String nom) { this.nom = nom; }

    /**
     * Setter del teléfono
     * @param telefon String
     */
    public void setTelefon(String telefon) { this.telefon = telefon;}

    /**
     * Comprueba si un alquiler ya está en la lista de alquileres
     * @param lloguer del tipo refactor.Lloguer
     * @return boolean
     */
    public boolean conte(Lloguer lloguer) {
        return lloguers.contains(lloguer);
    }

    /**
     * Añade un alquiler a la lista de alquileres si no lo tiene ya, si no, muestra un mensaje de error
     * @param lloguer del tipo refactor.Lloguer
     */
    public void afegeix(Lloguer lloguer) {
        if (!conte(lloguer) ) { // si no contiene el alquiler, lo añade
            lloguers.add(lloguer);
            System.out.println("refactor.Lloguer afegit correctament");
            return;
        }
        System.out.print("refactor.Lloguer ja existent");
    }

    /**
     * Elimina un alquiler de la lista de alquileres si lo tiene, si no, muestra un mensaje de error
     * @param lloguer del tipo refactor.Lloguer
     */
    public void elimina(Lloguer lloguer) {
        if (conte(lloguer) ) {
            lloguers.remove(lloguer);
            System.out.println("refactor.Lloguer eliminat correctament");
            return;
        }
        System.out.print("refactor.Lloguer no existent");
    }

    /**
     * Devuelve el número de alquileres almacenados
     * @return int
     */
    public int NLloguers(){
        return lloguers.toArray().length;
    }

    /**
     * Muestra en la consola los alquileres almacenados, contiene un formato específico para la fecha, para que sea más legible
     */
    public void mostrarLloguers(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");// formato de fecha
        int cont = 0;
        for (Lloguer lloguer: lloguers){ // recorre la lista de alquileres y muestra la información de cada uno
            cont++;
            System.out.println(cont + ". vehicle: " + lloguer.getVehicle().getMarca()+ " " + lloguer.getVehicle().getModel());
            System.out.println("data d'inici: " + dateFormat.format(lloguer.getData()));
            System.out.println("dies llogats: " + lloguer.getDies());
        }
    }

    /**
     * Genera un informe con los alquileres almacenados
     * @return String
     * @see Client#cabezaInforme()
     * @see Client#detalleInforme()
     * @see Client#pieInforme()
     */
    public String informe() {
        return cabezaInforme() + detalleInforme() + pieInforme();
    }

    /**
     * Genera la cabecera del informe, solo contiene el nombre y el NIF del cliente
     * @return String
     */
    public String cabezaInforme() {
        return "Informe de lloguers del client " + getNom() + " (" + getNif() + ")\n";
    }

    /**
     * Genera el detalle del informe, contiene la información de cada alquiler almacenado con datos como la marca y modelo del vehículo y el coste del alquiler
     * @return String
     */
    public String detalleInforme() {
        String resultado = "";
        for (Lloguer lloguer: lloguers) {
            double costo = lloguer.costo();
            resultado += "\t" +
                    lloguer.getVehicle().getMarca() +
                    " " +
                    lloguer.getVehicle().getModel() + ": " +
                    (costo * EUROS_PER_UNITAT_DE_COST) + "€" + "\n";

        }
        return resultado;
    }

    /**
     * Genera el pie del informe, contiene el importe total a pagar y los puntos obtenidos por los alquileres
     * @return String
     */
    public String pieInforme() {
        return "Import a pagar: " + importTotal() + "€\n" +
                "Punts guanyats: " + bonificacionsTotals() + "\n";
    }

    /**
     * Calcula los puntos de bonificación obtenidos por los alquileres almacenados
     * @return int
     */
    public int bonificacionsTotals() {
        int bonificacions = 0; // inicializa la variable bonificacions a 0
        for (Lloguer lloguer: lloguers) { // recorre la lista de alquileres y suma las bonificaciones de cada uno
            bonificacions += lloguer.bonificacions();
        }
        return bonificacions;
    }

    /**
     * Calcula el importe total a pagar por los alquileres almacenados
     * @return double
     */
    public double importTotal() {
        double total = 0;
        for (Lloguer lloguer: lloguers) { // recorre la lista de alquileres y suma el coste de cada uno multiplicado por el valor de la unidad del coste
            total += lloguer.costo() * EUROS_PER_UNITAT_DE_COST;
        }
        return total;
    }
}