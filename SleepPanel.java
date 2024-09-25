import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.image.ImageObserver;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class SleepPanel extends JPanel
{
   private static final int FRAME = 400;
   private BufferedImage myImage;
   private Graphics myBuffer;
   private Timer l,t;
   private ImageIcon i;
   private int sleepstage =0;
   private Player player;
   private GamePanel game;
   private boolean done;
    
   public SleepPanel(Player p, Timer m, GamePanel g) 
   {
      sleepstage = 0;
      player = p;
      t = m;
      game = g;
      done = false;
      this.myImage = new BufferedImage(400, 400, 1);
      (this.myBuffer = this.myImage.getGraphics()).setColor(Color.RED);
      this.myBuffer.fillRect(0, 0, 400, 400);
      this.setFocusable(false); 
      (this.l = new Timer(500, new Listener())).start();
   }
   public void paintComponent(final Graphics g) 
   {   
      i = new ImageIcon("sleep"+sleepstage+".png");
      g.drawImage(i.getImage(), 0, 0, getWidth(), getHeight(), null); 
   }
   public boolean done()
   {
      return done;
   }
   private class Listener implements ActionListener
    {
        public void actionPerformed(final ActionEvent e)
        {
            repaint();
            sleepstage++;
            if(sleepstage>=4)
            {
               if(player.dead&&(sleepstage>=4||sleepstage<-10))
               {
                     sleepstage = -100;
                     JOptionPane.showMessageDialog(null, "You slept for so long that you died. GAME OVER");
                     System.exit(0); 
               }
               done = true;
               setVisible(false);
               sleepstage = 0;
               l.stop();
               t.start(); 
               game.repaint();
            } 
        }        
    }      
}