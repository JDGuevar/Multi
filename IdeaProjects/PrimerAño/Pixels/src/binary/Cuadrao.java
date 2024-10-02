package binary;

public class Cuadrao extends PixMap{
    double base = 1.0, altura = 1.0, cx = 0.0, cy = 0.0;
    public Cuadrao(int width, int height, String filename, double base, double altura) {
        super(width, height, filename);
        if ((base > 0.0) & (altura > 0.0)){
            this.base = base;
            this.altura = altura;
        }
        Print();
    }

    public Cuadrao(int width, int height, String filename, double lado) {
        super(width, height, filename);
        if (lado > 0.0){
            this.base = lado;
            this.altura = lado;
        }
        Print();
    }

    public Cuadrao(int width, int height, String filename, double base, double altura, double cx, double cy) {
        super(width, height, filename);
        this.cx = cx;
        this.cy = cy;
        if ((base > 0.0) & (altura > 0.0)){
            this.base = base;
            this.altura = altura;
        }
        Print();
    }

    public int[] color(int w, int h) {
        double y = yMap[h] - cy;
        double x = xMap[w] - cx;

        if (Math.abs(x) < base/2 & Math.abs(y) < altura/2) return new int[]{0x33, 0x66, 0x99};
        return new int[] {0xff, 0xff, 0x00};
    }
}
