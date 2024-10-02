package binary;

import java.io.*;

public abstract class PixMap {
    public int width= 80, height= 60;
    public double[] xMap, yMap;
    private double escala = 1.0;
    private String filename = "default.pbm";

    public PixMap(int width, int height, String filename){
        if (width > 80) this.width = width;
        if (height > 80) this.height = height;

        xMap= new double[width];
        yMap= new double[height];

        mapping();

        if (filename.toLowerCase().matches("[a-z]+[0-9]*([.]pbm)?")){
            if(!filename.toLowerCase().endsWith(".pbm")) filename+=".pbm";
            this.filename = filename;
        }
    }

    private void mapping(){
        double dimension = Math.min(width,height);
        double xStart, yStart, ratio = (double) width / height;

        double gap = 2.0 * escala / (dimension - 1);

        if (ratio > 1.0){
            yStart = escala;
            xStart = -escala * ratio;
        }else {
            xStart = -escala;
            yStart = escala / ratio;
        }


        for (int w = 0; w < width; w++) xMap[w]= xStart + w * gap;

        for (int h = 0; h < height; h++) yMap[h]= yStart - h * gap;
    }

    void Print(){

        try (BufferedOutputStream file = new BufferedOutputStream(new FileOutputStream(filename))){
            file.write(String.format("P6\n%d %d\n255\n", width, height).getBytes());
            for (int h = 0; h < height; h++)
                for (int w = 0; w < width; w++)
                    for(int b:color(w,h))file.write(b);

        }catch (IOException exception){
            System.err.println("Something went wrong");
        }
    }

    public abstract int[] color(int w, int h);
}
