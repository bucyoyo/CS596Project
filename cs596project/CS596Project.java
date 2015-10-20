package cs596project;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static Constants.Constants.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CS596Project extends JFrame {
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    BufferedImage bi;
    Player[] players;
    
    public CS596Project() {
        super("Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, d.width, d.height);       
        players = new Player[MAXPLAYERS];
        for (int x = 0; x < players.length; x++)
            players[x] = new Player(x);
        
        bi = new BufferedImage(500, 500, BufferedImage.TYPE_3BYTE_BGR);
        
        Graphics2D g = bi.createGraphics();
        g.setBackground(Color.black);
        for (int x = 0; x < players.length; x++) {
            players[x].drawPlayer(g);            
        }
        final CS596Project ref = this;
        add(new JLabel(new ImageIcon(bi)));                
        setVisible(true);    
    }
    
    public static void main(String[] args) {
        new CS596Project();
    }
    
}
