import java.text.Normalizer;

public class CuentaLetras {
    public static void main(String[] args) {
        String frase = "The spirit indeed is willing, but the flesh is weak";

        frase= Normalizer
                .normalize(frase, Normalizer.Form.NFD)
                .toLowerCase()
                .replaceAll("[^a-z]", "");

        int[] contador = new int['z' - 'a' + 1];

        for (int i = 0; i < frase.length(); i++){
            contador[frase.charAt(i) - 'a']++;
        }
        for (int i = 0; i < contador.length; i++){
            if(contador[i] != 0){
                System.out.format("%c -> %d\n", i + 'a', contador[i]);
            }
        }
    }
}
