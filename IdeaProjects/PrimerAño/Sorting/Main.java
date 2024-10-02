public class Main
{
    public static void main(String[] args)
    {
        Testing t = new Testing(50000);
        t.test(new Bubble());
        t.test(new Selection());
        t.test(new Insertion());
        t.test(new Merge());
        t.test(new Shell());
        t.test(new Radix());
        t.test(new Quick());
        t.test(new Tunned());
        t.test(new Heap());
    }
}
