public class Fixe extends Empleat{
    private int souFixe;

    public Fixe(String ID, String name, String dataNaixement, int souFixe) {
        super(ID, name, dataNaixement);
        this.souFixe = souFixe;
    }

    public int getSou(){
        return souFixe;
    }
}
