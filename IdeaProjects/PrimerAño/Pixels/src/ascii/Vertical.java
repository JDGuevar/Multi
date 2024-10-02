package ascii;

public class Vertical extends PixMap{

    public Vertical(int width, int height, String filename){
        super(width, height, filename);
    }
    public String color(int w, int h){

        double t = (double) h / (height - 1);

        double[] origen = {255.0, 0.0, 0.0};
        double[] destino = {255.0, 255.0, 0.0};

        double[] color = new double[3];
        for (int i = 0; i < 3; i++)
            color[i] = origen[i] + t * (destino[i] - origen[i]);
        return String.format("%d %d %d",(int)color[0], (int)color[1], (int)color[2]);
    }
}
