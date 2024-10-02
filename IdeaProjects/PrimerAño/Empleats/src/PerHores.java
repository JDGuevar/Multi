public class PerHores extends Empleat{
    private int horesTrabajades;
    private int preuHora = 35;

    public PerHores(String ID, String name, String dataNaixement, int horesTrabajades) {
        super(ID, name, dataNaixement);
        this.horesTrabajades = horesTrabajades;
    }

    @Override
    public int getSou(){
        return horesTrabajades * preuHora;
    }
}
