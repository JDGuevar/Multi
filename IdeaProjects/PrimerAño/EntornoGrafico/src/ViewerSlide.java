import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewerSlide extends JFrame {
    private Panel panel;
    private final SlideShow slideshow;
    Dimension screen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public ViewerSlide(String file, SlideShow slideshow) {
        this.slideshow = slideshow;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        panel = new Panel(file);
        refreshPanel(panel);
        addKeyListener(createKeyListener());
        addWindowListener(createWindowListener());
        pack();
        setLocationRelativeTo(null);
    }

    // Crea un KeyListener para manejar la tecla Escape y navegar entre imágenes
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
                    case "Right" -> slideshow.showNextViewer();
                    case "Left" -> slideshow.showPreviousViewer();

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

    public void refreshPanel(Panel panel) {
        if (this.panel != null)
            remove(this.panel);
        this.panel = panel;
        add(this.panel);
    }

    // Crea un WindowListener para notificar a SlideShow sobre el cierre de la ventana
    WindowListener createWindowListener() {
        return new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        };
    }
}