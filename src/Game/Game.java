package Game;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel{
    
       Ball ball = new Ball(this);
       Racquet1 racquet1 = new Racquet1(this); //bottom
       Racquet2 racquet2 = new Racquet2(this); //top
       
       int speed = 1;
       int player1 = 0;
       int player2 = 0;
       
      
       public Game(){
           addKeyListener(new KeyListener(){
               
               @Override
               public void keyTyped(KeyEvent e){
                   
               }
               
               @Override
               public void keyReleased(KeyEvent e){
                   racquet1.keyReleased(e);
                   racquet2.keyReleased(e);
               }
               
               @Override
               public void keyPressed(KeyEvent e){
                   racquet1.keyPressed(e);
                   racquet2.keyPressed(e);
               }
           });
           setFocusable(true);
       }
       
       private void move(){
           ball.move();
           racquet1.move();
           racquet2.move();
       }
        
        @Override
        public void paint(Graphics g){
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                    RenderingHints.VALUE_ANTIALIAS_ON);
            ball.paint(g2d);
            racquet1.paint(g2d);
            racquet2.paint(g2d);
            
            g2d.setColor(Color.GRAY);
            g2d.setFont(new Font("Verdana", Font.CENTER_BASELINE, 10));
            g2d.drawString("Player 2", 7, 15);
            g2d.drawString("Player 1", 230, 350);
        }
        
        //gameOverDialog
        public void gameOver(){
            Sound.play("gameOver.wav");
            if(player1 > player2){
                JOptionPane.showMessageDialog(this, "Congratulations Player 1! You win :)", "Game Over",
                    JOptionPane.YES_NO_OPTION);
            }else{
                JOptionPane.showMessageDialog(this, "Congratulations Player 2! You win :)", "Game Over",
                    JOptionPane.YES_NO_OPTION);
            }
            System.exit(0);
            
        }
    
    
        //main
	public static void main(String[] args) {
		JFrame frame = new JFrame("Mini Tennis");
                Game game = new Game();
                frame.add(game);
		frame.setSize(300, 400);
                frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                while(true){
                    game.move();
                    game.repaint();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
	}

    
}