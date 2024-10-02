package library;


public class Circle extends FileFormatPNG {
    double radio, cx = 0.0, cy = 0.0;
    public Circle(int width, int height, double radio) {
        super(width, height);
        this.radio = radio;
        Print();
    }

    public Circle(int width, int height, double radio, double cx, double cy) {
        super(width, height);
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
