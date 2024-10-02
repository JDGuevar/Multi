package ascii;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public abstract class PixMap {
    public int width= 800;
    public int height= 600;

    private String filename= "default.ppm";

    public PixMap(int width, int height, String filename){
        if (width > 80) this.width = width;
        if (height > 80) this.height = height;

        if (filename.toLowerCase().matches("[a-z]+[0-9]*([.]ppm)?")){
            if(!filename.toLowerCase().endsWith(".ppm")) filename+=".ppm";
            this.filename = filename;
        }
        Print();
    }

    void Print(){

        try (PrintWriter printer = new PrintWriter(filename)){
            printer.println("P3");
            printer.println(width + " " + height);
            printer.println("255");
            for (int h = 0; h < height; h++)
                for (int w = 0; w < width; w++)
                    printer.println(color(w,h));
        }catch (FileNotFoundException exception){
            System.err.println("Something went wrong");
        }
    }

    public abstract String color(int w, int h);
}
