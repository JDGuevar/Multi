package refactor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase GestorLloguersLite
 * @author Jose Y Albert
 */
public class GestorLloguersLite {

    /**
     * Cliente, se crea un cliente con nombre, nif, y teléfono cualquiera. Luego añadiremos 3 alquileres a este cliente
     * @see Client
     */
    private Client yo = new Client("Z0882208W", "José", "644947952");;

    /**
     * Constructor de la clase GestorLloguersLite, esta clase se encarga de añadir 3 alquileres a un cliente.
     * No tiene mucho sentido, pero es un ejemplo de cómo se añaden alquileres a un cliente
     * @see Lloguer
     * @see Vehicle
     */
    public GestorLloguersLite(){
        // se hace try-catch para evitar errores de parseo de fecha
        try {
            // Formato de fecha, en un simple date format para poder pasar las fechas a un formato más legible
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            Vehicle coche1 = new Vehicle("Tata", "Vista", "basico");


            Date date1 = dateFormat.parse("2/8/2013");

            Lloguer lloguer1 = new Lloguer(date1, 2, coche1);
            yo.afegeix(lloguer1);

            Vehicle coche2 = new Vehicle("Focus", "Ford", "lujo");

            Date date2 = dateFormat.parse("2/9/2013");

            Lloguer lloguer2 = new Lloguer(date2, 4, coche2);
            yo.afegeix(lloguer2);

            Vehicle coche3 = new Vehicle("Pacifica", "Chrysler", "general");

            Date date3 = dateFormat.parse("2/10/2013");

            Lloguer lloguer3 = new Lloguer(date3, 1, coche3);
            yo.afegeix(lloguer3);

        } catch (ParseException e){ // en caso de que la fecha no esté en el formato correcto y no se pueda parsear
            System.out.println("something went wrong");
        }
    }

    /**
     * Método que muestra la información del cliente, su nombre, nif, teléfono y los alquileres que tiene
     * @see Client#mostrarLloguers()
     * @see Client#NLloguers()
     */
    public void informacion() {
        System.out.println("refactor.Client: " + yo.getNom());
        System.out.println(yo.getNif());
        System.out.println(yo.getTelefon());
        System.out.print("LLoguers: " + yo.NLloguers());
        yo.mostrarLloguers();
    }

    /**
     * Método que muestra el informe del cliente, con la cabecera, el detalle y el pie, ya que no se puede referenciar a la clase refactor.Client.
     * @see Client#informe()
     */
    public void informe(){
        System.out.println(yo.informe());
    }
}
