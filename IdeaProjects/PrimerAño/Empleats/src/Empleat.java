public abstract class Empleat {
    private String ID;
    private String name;
    private String dataNaixement;

    public Empleat(String ID, String name, String dataNaixement) {
        this.ID = ID;
        this.name = name;
        this.dataNaixement = dataNaixement;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getDataNaixement() {
        return dataNaixement;
    }

    public abstract int getSou();
}
