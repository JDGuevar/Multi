package BibliotecaRamon;

public class Cliente extends Persona{
    private String idCliente;
    private String telefono;

    public Cliente(){
        super();
        this.idCliente = Helper.genId('C');
    }

    public void mostrar(){
        System.out.printf("Cliente: %s%n", idCliente);
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}