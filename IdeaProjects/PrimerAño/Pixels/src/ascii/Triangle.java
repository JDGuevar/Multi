package ascii;

public class Triangle extends PixMap{
    int lados;
    double mw, mh, radius = 0.5;
    public Triangle(int width, int height, String filename, int lados, double radius){
        super(width, height, filename);
        this.lados = lados;
        this.radius = radius;
        Print();
    }
    public String color(int w, int h){

        mw = (double) (width - 1) / 2.0;
        mh = (double) (height - 1) / 2.0;

        double mm = Math.sqrt(mw * mw + mh * mh);

        double nn = Math.max(mw,mh);

        double th = (double) mh - h;
        double tw = (double) w - mw;

        double t = Math.sqrt(tw*tw + th*th) / mm;

        tw /= nn;

        th /= nn;

        if (inside(tw,th)) return "0 0 0";

        double[] origen = {255.0, 0.0, 0.0};
        double[] destino = {255.0, 255.0, 0.0};

        double[] color = new double[3];

        for (int i = 0; i < 3; i++){
                color[i] = origen[i] + t * (destino[i] - origen[i]);
        }

        return String.format("%d %d %d",(int)color[0], (int)color[1], (int)color[2]);
    }

    public boolean inside(double x, double y)
    {
        int pos = 0;
        int neg = 0;

        double alfa = Math.PI / 2.0;
        double beta = 2.0 * Math.PI / lados;

        for (int i = 0; i < lados; i++)
        {
            double x1 = radius * Math.cos(alfa);
            double y1 = radius * Math.sin(alfa);

            alfa += beta;

            double x2 = radius * Math.cos(alfa);
            double y2 = radius * Math.sin(alfa);

            double d = (x - x1) * (y2 - y1) - (y - y1) * (x2 - x1);

            if (d > 0) pos++;
            if (d < 0) neg++;

            if (pos > 0 && neg > 0) return false;
        }
        return true;
    }
}
