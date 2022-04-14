
package Game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet2 {
    private static final int Y = 15;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 10;
    int x = 220;
    int xa = 0;
    private Game game;
    
    public Racquet2(Game game){
        this.game = game;
    }
    
    public void move(){
        if(x + xa > 0 && x + xa < game.getWidth() - WIDTH)
            x = x + xa;
    }
    
    public void paint(Graphics2D g){
        g.fillRect(x, Y, WIDTH, HEIGHT);
        g.setColor(Color.blue);
    }
    
    public void keyReleased(KeyEvent e){
        xa = 0;
    }
    
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_A)
            xa = -game.speed;
        if(e.getKeyCode() == KeyEvent.VK_D)
            xa = game.speed;
    }
    
    public Rectangle getBounds(){
        
        return new Rectangle(x, Y, WIDTH, HEIGHT);
    }
    
    
}
