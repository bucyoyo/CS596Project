package cs596project;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Player {
    Point location;
    Color color;
    int id;
    boolean orientedUp;
    double orientation = 90;
    
    public Player(int id) {
        this.id = id;
        int[] colors = new int[3];
        for (int x = 0; x < colors.length; x++)
            colors[x] = (int) (Math.random() * 256);
        color = new Color(colors[0], colors[1], colors[2]);   
        location = new Point();
        switch (id) {
            case 0: 
                location.x = 30; location.y = 30; orientedUp = false;
                break;
            case 1:
                location.x = 130; location.y = 130; orientedUp = true;
                break;
            case 2:
                location.x = 30; location.y = 130; orientedUp = true;
                break;
            case 3:
                location.x = 130; location.y = 30; orientedUp = false;
                break;
            default:
                break;
        }
        
    }
    
    public void drawPlayer(Graphics2D g) {
        g.setColor(color);
        if (orientedUp) {
            g.drawLine(//(int) (location.x * Math.cos(orientation-90)), 
                    //(int) (location.y * Math.sin(orientation))
                    location.x, location.y, location.x - 5, location.y + 5);
            g.drawLine(location.x, location.y, location.x + 5, location.y + 5);
        } else {
            g.drawLine(location.x, location.y, location.x - 5, location.y - 5);
            g.drawLine(location.x, location.y, location.x + 5, location.y - 5);
        }
    }
}
