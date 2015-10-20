package PlayerGUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;


public class GameWindow extends JPanel {
    Graphics2D g2d;
    BufferedImage bi;
    final GameWindow reference = this;
    Point p;
    int xLen = 5, yLen = 5;
    double orientation = 0;
    
    public GameWindow() {
        bi = new BufferedImage(800, 800, BufferedImage.TYPE_4BYTE_ABGR);
        //add (new JLabel(new ImageIcon(bi)));
        
        p = new Point();
        p.x = 400; p.y = 400;
    }
    
    public void paintComponent (Graphics g) {
        g2d = (Graphics2D) reference.getGraphics();
        g2d.clearRect(0, 0, 800, 800);
        g2d.drawString("test", (int) (Math.random() * 800), (int) (Math.random() * 800));        
    }
    
    public void rotate() {
        g2d = (Graphics2D) reference.getGraphics();
        int deltaX= 50, deltaY = 20;
        double offset = 80;
        g2d.clearRect(0, 0, 800, 800);
        orientation += 5;
        g2d.drawLine(p.x + (int) (deltaX * (Math.cos(Math.toRadians(orientation)))), 
                p.y + (int) (deltaY * (Math.sin(Math.toRadians(orientation)))), 
                p.x + (int) (deltaX * Math.cos(Math.toRadians(orientation + offset))), 
                p.y + (int) (deltaY * Math.sin(Math.toRadians(orientation + offset))));
        g2d.drawLine(p.x + (int) (deltaX * (Math.cos(Math.toRadians(orientation)))), 
                p.y + (int) (deltaY * (Math.sin(Math.toRadians(orientation)))), 
                p.x + (int) (deltaX * (Math.cos(Math.toRadians((orientation-offset))))), 
                p.y + (int) (deltaY * Math.sin(Math.toRadians(((orientation-offset))))));
        System.out.println(p.x + ", " + p.y);
    }
}
