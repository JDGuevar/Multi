package ascii;

public class Square extends PixMap{

    public Square(int width, int height, String filename){
        super(width, height, filename);
    }
    public String color(int w, int h){

        double mw = (double) (width - 1) / 2.0;
        double mh = (double) (height - 1) / 2.0;

        double nn = Math.max(mw, mh);

        double mm = Math.sqrt(mw * mw + mh * mh);

        double th = (double) h - mh;
        double tw = (double) w - mw;

        double t = Math.sqrt(tw*tw + th*th) / mm;

        if (Math.abs(th/nn) < 0.5 && Math.abs(tw/nn) < 0.5) return "0 0 0";

        double[] origen = {255.0, 0.0, 0.0};
        double[] destino = {255.0, 255.0, 0.0};

        double[] color = new double[3];

        for (int i = 0; i < 3; i++){
                color[i] = origen[i] + t * (destino[i] - origen[i]);
        }



        return String.format("%d %d %d",(int)color[0], (int)color[1], (int)color[2]);
    }
}
