package library;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.IntStream;

public abstract class FileFormatPNG {

    private int width = 160, height = 90;
    double escala = 1.0;

    double[] xMap, yMap;
    BufferedImage image;
    WritableRaster raster;
    public FileFormatPNG(int width, int height){
        setWidth(width);
        setHeight(height);
        image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        raster = image.getRaster();
        mapping();
    }

    public void setWidth(int width){
        if (width > this.width) this.width = width;
    }

    public void setHeight(int height){
        if (height > this.height) this.height = height;
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


        xMap = IntStream.range(0, width).mapToDouble(w -> xStart + w * gap).toArray();
        yMap = IntStream.range(0, height).mapToDouble(h -> yStart - h * gap).toArray();
    }

    void Print(){
        for (int h = 0; h < height; h++)
            for (int w = 0; w < width; w++)
                raster.setPixel(w, h, color(w, h));
        saveImage();
    }

    private String getFilename(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss_SSS"));
    }

    private void saveImage(){
        try{
            ImageIO.write(image,"png",new File(getFilename() + ".png"));
        }catch (IOException exception){
            System.err.println("Something went wrong");
        }
    }

    public abstract int[] color(int w, int h);
}
