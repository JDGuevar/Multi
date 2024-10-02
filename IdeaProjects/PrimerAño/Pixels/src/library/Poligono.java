package library;

public class Poligono extends FileFormatPNG {
    double radio = 1.0, cx = 0.0, cy = 0.0;
    double[] vx, vy;
    int sides = 3;
    public Poligono(int width, int height) {
        super(width, height);
        crearVeritices();
        Print();
    }

    public Poligono(int width, int height, double radio, int sides) {
        super(width, height);
        if (radio > 0.0) this.radio = radio;
        if (sides > 2) this.sides = sides;
        crearVeritices();
        Print();
    }

    public int[] color(int w, int h) {
        if (inside(xMap[w], yMap[h])) return new int[] {0xff, 0x00, 0x80};
        return new int[]{0x00, 0x00, 0x00};
    }

    private void crearVeritices(){
        vx = new double[sides];
        vy = new double[sides];
        double alfa = Math.PI / 2.0;
        double beta = 2.0 * Math.PI / sides;

        for (int i = 0; i < sides; i++){
            vx[i]= radio * Math.cos(alfa);
            vy[i]= radio * Math.sin(alfa);
            alfa+=beta;
        }
    }

    public boolean inside(double x, double y)
    {
        int pos = 0;
        int neg = 0;

        for (int i = 0; i < sides; i++)
        {
            double x1 = vx[i];
            double y1 = vy[i];

            int j = (i + 1) % sides;

            double x2 = vx[j];
            double y2 = vy[j];

            double d = (x - x1) * (y2 - y1) - (y - y1) * (x2 - x1);

            if (d > 0) pos++;
            if (d < 0) neg++;

            if (pos > 0 && neg > 0) return false;
        }
        return true;
    }
}
