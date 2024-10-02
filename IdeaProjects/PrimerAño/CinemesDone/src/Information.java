public class Information {
    int adults;
    int children;
    int teen;
    Information next;

    public Information(int adults, int children, int teen) {
        this.adults = adults;
        this.children = children;
        this.teen = teen;
        next = null;
    }
}
