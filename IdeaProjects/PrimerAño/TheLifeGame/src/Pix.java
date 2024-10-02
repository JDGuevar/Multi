import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class Pix extends JFrame {
    BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
    WritableRaster raster = image.getRaster();

    public Pix() {
        super("Pix");
        pixele();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        getContentPane().getGraphics().drawImage(image, 0, 0, null);
    }

    private void pixele(){
        for(int x = 0; x < image.getWidth(); x++){
            for(int y = 0; y < image.getHeight(); y++){
                int r = (int)(Math.random() * 256);
                int g = (int)(Math.random() * 256);
                int b = (int)(Math.random() * 256);
                raster.setPixel(x, y, new int[]{r, g, b});
            }
        }
    }

    public static void main(String[] args) {
        new Pix();
    }

}
