package Pract2;

public class Estudiant extends Persona {
    private int assignaturesMatriculades;

    public Estudiant(String nom, String dni, int edat, int assignaturesMatriculades) {
        super(nom, dni, edat);
        this.assignaturesMatriculades = assignaturesMatriculades;
    }

    public int getAssignaturesMatriculades() {
        return assignaturesMatriculades;
    }

    public void setAssignaturesMatriculades(int assignaturesMatriculades) {
        this.assignaturesMatriculades = assignaturesMatriculades;
    }
}
