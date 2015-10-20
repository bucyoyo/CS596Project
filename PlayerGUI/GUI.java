package PlayerGUI;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class GUI extends JFrame {
    BufferedImage screen;
    JButton start;
    GameWindow window;
    
    public GUI() {
        super("Player GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 800, 800);
        screen = new BufferedImage(800, 800, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g = screen.createGraphics();
        g.drawString("New Game", 100, 100);
        window = new GameWindow();
        
        add(window);
        start = new JButton("Start");
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.rotate();
            }
        });
        add(start, BorderLayout.SOUTH);
        setVisible(true);
    }
    
    
    
    public static void main (String[] args) {
        GUI g = new GUI();
        for (int x = 0; x < 300; x++) {
            g.window.rotate();
            try {
                Thread.sleep(333);
            } catch (InterruptedException i) {
                
            } 
        }
            
    }
}
