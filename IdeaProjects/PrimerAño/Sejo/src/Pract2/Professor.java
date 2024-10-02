package Pract2;

import Pract2.Persona;

public class Professor extends Persona {

    double sou;
    public Professor(String nom, String dni, int edat, double sou) {
        super(nom, dni, edat);
        this.sou = sou;
    }

    public double getSou() {
        return sou;
    }

    public void setSou(double sou) {
        this.sou = sou;
    }
}
