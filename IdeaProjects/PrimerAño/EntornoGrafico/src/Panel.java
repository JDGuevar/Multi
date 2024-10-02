import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Panel extends JPanel {
    private BufferedImage image;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public Panel(String imageName) {
        try {
            image = ImageIO.read(new File(imageName));

            resizeIt();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Panel(BufferedImage image) {
        this.image = image;
        resizeIt();
    }

    private void resizeIt(){
        int panelwidth = image.getWidth();
        int panelheight = image.getHeight();

        double aspectRatio = (double) panelwidth / panelheight;

        if (panelheight > screenSize.height) {
            panelheight = (int) (screenSize.height * 0.9);
            panelwidth = (int) (panelheight * aspectRatio);
        }
        if (panelwidth > screenSize.width) {
            panelwidth = (int) (screenSize.width * 0.9);
            panelheight = (int) (panelwidth / aspectRatio);
        }

        setPreferredSize(new Dimension(panelwidth, panelheight));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }
}
