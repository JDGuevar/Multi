package Pract2;

public abstract class Persona {
    private String nom;
    private String dni;
    private int edat;

    public Persona(String nom, String dni, int edat) {
        this.nom = nom;
        this.dni = dni;
        this.edat = edat;
    }

    public String getNom() {
        return nom;
    }

    public String getDni() {
        return dni;
    }

    public int getEdat() {
        return edat;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }
}
