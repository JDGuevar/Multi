public class Pitagoras1 {

    public static void main(String[] args) {

        int cantidad = 10;
        boolean found;

        for (int j = 2; cantidad >= 0; j++){
            found = false;
            for (int i = 1 ; i<j && !found; i++){

                double hypot = Math.hypot(i, j);

                if ((hypot > -1)&&(hypot % 1 ==0)){
                    System.out.println("[ a="+i+" , b="+j+" , c="+(int)hypot+" ]");
                    cantidad--;
                    found = true;
                }
            }
        }
    }
}
