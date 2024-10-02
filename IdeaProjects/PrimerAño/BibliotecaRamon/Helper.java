package BibliotecaRamon;

public class Helper {

    static int A = 0; //es static porque se actualiza en cada instancia que creas sin perder el valor
    static int L = 0;
    static int C = 0;

    public static String genId(char letra) {
        switch (letra) {
            case 'A':
                return String.format("%c-%04d", letra, ++A);
            case 'L':
                return String.format("%c-%04d", letra, ++L);
            case 'C':
                return String.format("%c-%04d", letra, ++C);
            default:
                return "Error";
        }
    }
}
