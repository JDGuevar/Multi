package binary;

public class Circle extends PixMap{
    double radio, cx = 0.0, cy = 0.0;
    public Circle(int width, int height, String filename, double radio) {
        super(width, height, filename);
        this.radio = radio;
        Print();
    }

    public Circle(int width, int height, String filename, double radio, double cx, double cy) {
        super(width, height, filename);
        this.cx = cx;
        this.cy = cy;
        this.radio = radio;
        Print();
    }

    public int[] color(int w, int h) {
        double y = yMap[h] - cy;
        double x = xMap[w] - cx;

        if (Math.sqrt(x*x + y*y) < radio) return new int[]{0x33, 0x66, 0x99};
        return new int[] {0xff, 0xff, 0x00};
    }
}
