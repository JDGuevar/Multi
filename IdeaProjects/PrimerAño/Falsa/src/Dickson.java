public class Dickson {
    public Dickson(int limit){
        for (int i = 1; i<=limit; i++){
            tripletes(i+i);
        }
    }

    private void tripletes(int r){
        int factor = r * r / 2;
        System.out.printf("%d -> %d -> ", r, factor);
        int root= (int) Math.sqrt(factor);
        for (int s = 1; s<=root; s++){
            if (factor % s == 0){
                int t = factor /  s;
                if (coprime(s, t)){
                    System.out.printf("(%d, %d, %d) ", r+s , r+t, r+s+t);
                }
            }
        }
        System.out.println();
    }
    private boolean coprime (int a, int b){
        while (b !=0){
            int c = a;
            a = b;
            b = c % b;
        }
        return (a == 1);
    }

    public static void main(String[] args) {
        new Dickson(25);
    }
}
