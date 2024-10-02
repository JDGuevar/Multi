import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Boton extends JFrame implements ActionListener {

    JButton boton;
    JLabel texto;

    public Boton(){
        setLayout(null);
        boton=new JButton("Exit");
        boton.setBounds(100,150,100,30);
        boton.addActionListener(this);
        add(boton);
        texto=new JLabel("Exit this window.");
        texto.setBounds(50,50,220,40);
        add(texto);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton) {
            setTitle("Saldrá en 3 segundos");
            try{
                Thread.sleep(3000);
                System.exit(0);
            } catch(Exception excep) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        Boton b = new Boton();
        b.setBounds(0,0,300,300);
        b.setVisible(true);
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
