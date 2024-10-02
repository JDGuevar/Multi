package cat.spaad.iniciacio;

import cat.spaad.auxiliar.MetodesByteStreams;

public class IniciacioStreams {

    public void provesByte(){
        new MetodesByteStreams().llegeixBytes("src/cat/spaad/auxiliar/MetodesByteStreams.java");
    }

    public static void main(String[] args) {
        new IniciacioStreams().provesByte();
    }
}
