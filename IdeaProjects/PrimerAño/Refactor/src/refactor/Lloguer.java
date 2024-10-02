package refactor;

import java.util.Date;
/**
 * Clase Lloguer
 * @author Jose Y Albert
 */
public class Lloguer {
    private Date data;
    private int dies;
    private Vehicle vehicle;
    private int COSTO_BASIC = 3;
    private int COSTO_GENERAL = 4;
    private int COSTO_LUXE = 6;

    /**
     * Constructor de la clase Lloguer
     * @param data del tipo Date
     * @param dies int
     * @param vehicle del tipo refactor.Vehicle
     * @see Vehicle
     */
    public Lloguer(Date data, int dies, Vehicle vehicle) {
        this.data = data;
        this.dies = dies;
        this.vehicle = vehicle;
    }

    /**
     * Getter que devuelve el vehículo del alquiler
     * @return vehicle refactor.Vehicle
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Getter que devuelve los días de alquiler
     * @return dies int
     */
    public int getDies() {
        return dies;
    }

    /**
     * Getter que devuelve la fecha de alquiler
     * @return data Date
     */
    public Date getData() {
        return data;
    }

    /**
     * Calcula el costo del alquiler en base a la categoría del vehículo y los días de alquiler
     * Los vehículos tienen distintas agregaciones adicionales al costo según la categoría y el cálculo es distinto según los días de alquiler
     * @return costo double
     * @see Vehicle
     * @see Vehicle.CATEGORIA
     * @see Vehicle#getCategoria()
     */
    public double costo() {
        double costo = 0;
        switch (vehicle.getCategoria()) { // getCategoria devuelve la categoria del vehiculo y dependiendo del caso entra a un cálculo u otro del alquiler total.
            case BASIC:
                costo += COSTO_BASIC;
                if (dies > 3) {
                    costo += (dies - 3) * 1.5;
                }
                break;
            case GENERAL:
                costo += COSTO_GENERAL;
                if (dies > 2) {
                    costo += (dies - 2) * 2.5;
                }
                break;
            case LUXE:
                costo += dies * COSTO_LUXE;
                break;
        }
        return costo;
    }

    /**
     * Calcula las bonificaciones en base a la categoría del vehículo y los días de alquiler
     * Si el vehículo es de lujo y ha sido alquilado más de un día, añade una bonificación adicional
     * @return bonificacions int
     * @see Vehicle
     * @see Vehicle.CATEGORIA
     * @see Vehicle#getCategoria()
     */
    public int bonificacions() {
        int bonificacions = 0;
        bonificacions++;
        if (vehicle.getCategoria() == Vehicle.CATEGORIA.LUXE && dies > 1) {
            bonificacions++;
        }
        return bonificacions;
    }
}
