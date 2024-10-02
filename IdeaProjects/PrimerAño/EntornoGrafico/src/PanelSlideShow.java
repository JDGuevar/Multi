import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class PanelSlideShow extends JFrame {
    ArrayList<Panel> images = new ArrayList<>();
    int currentIndex = 0;
    String[] files;

    public PanelSlideShow() {
        File dir = new File("images/.");
        FilenameFilter filter = (dir1, name) -> name.toLowerCase().endsWith(".jpeg");
        files = dir.list(filter);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        if (files != null) {
            try {
                for (String file : files) {
                    BufferedImage image = ImageIO.read(new File(dir.getPath() + File.separator + file));
                    Panel panel = new Panel(image);
                    images.add(panel);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            if (!images.isEmpty()) {
                add(images.get(currentIndex));
                pack();
                setTitle("SlideShow " + (currentIndex + 1));
                setLocationRelativeTo(null);
            } else {
                System.out.println("No images found in the directory");
            }
        }
        addKeyListener(createKeyListener());
        addWindowListener(createWindowListener());
    }

    WindowListener createWindowListener() {
        return new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        };
    }

    KeyListener createKeyListener() {
        return new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String keyText = KeyEvent.getKeyText(e.getKeyCode());

                switch (keyText) {
                    case "Escape" -> {
                        dispose();
                        System.exit(0);
                    }
                    case "Right" ->{
                        remove(images.get(currentIndex));
                        currentIndex = (currentIndex + 1) % images.size();
                        add(images.get(currentIndex));
                        pack();
                        setTitle("SlideShow " + (currentIndex + 1));
                        setLocationRelativeTo(null);
                    }
                    case "Left" -> {
                        remove(images.get(currentIndex));
                        currentIndex = (currentIndex - 1 + images.size()) % images.size();
                        add(images.get(currentIndex));
                        pack();
                        setTitle("SlideShow " + (currentIndex + 1));
                        setLocationRelativeTo(null);
                    }

                    case "W" -> setLocation(getLocation().x, getLocation().y - 20);
                    case "A" -> setLocation(getLocation().x-20, getLocation().y);
                    case "S" -> setLocation(getLocation().x,getLocation().y + 20);
                    case "D" -> setLocation(getLocation().x + 20, getLocation().y);

                    case "X" -> setLocationRelativeTo(null); // Centra la ventana


                    default -> System.out.println("\"" + keyText + "\"");
                }
            }
        };
    }

    public static void main(String[] args) {
        new PanelSlideShow();
    }
}

