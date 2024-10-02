public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        new FibArrayOOP(500,false);
        long stop = System.currentTimeMillis();
        System.out.println(stop - start);
        System.out.println();
        new Stringonacci2(500);
        System.out.println(System.currentTimeMillis()- stop);
    }
}
