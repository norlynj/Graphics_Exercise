
package Game;

import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Ball {
    private static final int DIAMETER = 25;
    int x = 0;
    int y = 0;
    int xa = 1; //speed in which ball is moving
    int ya = 1;
    private Game game;
    
    
    public Ball(Game game){
        this.game = game;
    }
    
    void move(){
        boolean changeDirection = true;
        if(x + xa < 0)
            xa = game.speed; //ball moves right
        else if(x + xa > game.getWidth() - DIAMETER)
            xa = -game.speed; //ball moves to the left
        
        else if (y + ya < 0){
            game.player1++;
            game.gameOver();
        }
        else if (y + ya > game.getHeight() - DIAMETER){
            game.player2++;
            game.gameOver();
        }
        
        else if (collision1()){
            ya = -game.speed; //ball moves up
            y = game.racquet1.getTopY() - DIAMETER;
        }
        else if (collision2()){
            ya = game.speed; //ball moves down
            y = DIAMETER;
            game.speed++;
        } else
            changeDirection = false;
        
       if(changeDirection)
           Sound.play("hit.wav");
        
        x = x + xa;
        y = y + ya;
    }
    
    private boolean collision1(){//ball collides with p1 rect
        return game.racquet1.getBounds().intersects(getBounds());
    }
    
    private boolean collision2(){//ball collides with p2 rect
        return game.racquet2.getBounds().intersects(getBounds());
    }
    
    public void paint(Graphics2D g){
        g.fillOval(x, y, 25, 25);
        
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}
