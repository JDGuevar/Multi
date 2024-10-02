import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Viewer extends JFrame{

    Panel image;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    public Viewer(String imageName){
        setTitle("Duraso");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // sale del programa cuando cierras de la ventana.
        setResizable(false); // hace que no puedas maximizar la ventana.
        addKeyListener(thisKeyListener());

        image = new Panel(imageName);

        add(image);
        pack(); // hace que la ventana se adapte al panel, pero el contenido será el tamaño fijo.
        setVisible(false); // hace que la ventana sea visible.
        setLocationRelativeTo(null); // la ventana aparece en centrado de la pantalla.
    }

    /*MouseListener thisMouseListener(){
        return new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                remove(images[galleryIndex]);
                galleryIndex = (galleryIndex + 1) % images.length;
                add(images[galleryIndex]);
                revalidate();
                pack();
                colocarBoton();
                setLocationRelativeTo(null);
            }
        };
    }
*/
    /*private void colocarBoton() {
        boton.setBounds((getWidth()/2) - 50,getHeight() - 100,100,30);
    }*/

    private KeyListener thisKeyListener(){
        return new KeyAdapter(){

            @Override
            public void keyPressed(KeyEvent e){
                String key = KeyEvent.getKeyText(e.getKeyCode());
                switch (key) {
                    /*case "Right" -> {
                        remove(images[galleryIndex]);
                        galleryIndex = (galleryIndex + 1) % images.length;
                        add(images[galleryIndex]);
                        revalidate();
                        pack();
                        //colocarBoton();
                        setLocationRelativeTo(null);
                    }
                    case "Left" -> {
                        remove(images[galleryIndex]);
                        galleryIndex = (galleryIndex + images.length - 1) % images.length;
                        add(images[galleryIndex]);
                        revalidate();
                        pack();
                        //colocarBoton();
                        setLocationRelativeTo(null);
                    }*/

                    case "Escape" ->{
                        setVisible(false);
                        dispose();
                        //System.exit(0);
                    }

                    case "W" -> {
                        setLocationRelativeTo(null); // Centra la ventana
                        int newY = 0; // Ajusta la posición de la ventana para justificarla hacia arriba
                        setLocation(getLocation().x, newY);
                    }
                    case "A" -> {
                        setLocationRelativeTo(null);
                        int newX = 0; // Ajusta la posición de la ventana para justificarla a la izquierda
                        setLocation(newX, getLocation().y);
                    }
                    case "S" -> {
                        setLocationRelativeTo(null); // Centra la ventana
                        setLocation(getLocation().x,screen.height - getHeight());
                    }
                    case "D" -> {
                        setLocationRelativeTo(null); // Centra la ventana
                        setLocation(screen.width - getWidth(), getLocation().y);
                    }

                    default ->
                        System.out.println("\"" + key + "\"");

                }
            }
        };
    }

    public static void main(String[] args) {
        Viewer q = new Viewer("images/1.jpeg");
        q.setVisible(true);
    }
}