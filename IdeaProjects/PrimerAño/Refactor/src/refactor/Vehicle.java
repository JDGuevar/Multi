package refactor;

/**
 * Clase Vehicle
 * @author Jose Y Albert
 */
public class Vehicle {
    private String model;
    private String marca;
    private static String categoria;

    /**
     * Enumerado CATEGORIA, únicamente puede ser "básico", "general" o "lujo"
     * @see Vehicle#getCategoria()
     */
    public enum CATEGORIA {
        /**
         * Categoría básica
         */
        BASIC,
        /**
         * Categoría general
         */
        GENERAL,
        /**
         * Categoría de lujo
         */
        LUXE};

    /**
     * Constructor de la clase Vehicle
     * @param model String
     * @param marca String
     * @param categoria String únicamente puede ser "basico", "general" o "lujo"
     */
    public Vehicle(String model, String marca, String categoria) {
        this.model = model;
        this.marca = marca;
        this.categoria = categoria;
    }

    /**
     * Getter que devuelve la marca del vehículo
     * @return marca String
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Getter que devuelve el modelo del vehículo
     * @return model String
     */
    public String getModel() {
        return model;
    }

    /**
     * Getter que devuelve la categoría del vehículo
     * @return categoria CATEGORIA
     */
    public CATEGORIA getCategoria() {
        switch (categoria) { // switch para devolver la categoría del vehículo según el string introducido en el constructor
            case "basico":
                return CATEGORIA.BASIC;
            case "general":
                return CATEGORIA.GENERAL;
            case "lujo":
                return CATEGORIA.LUXE;
            default:
                return null;
        }
    }
}
