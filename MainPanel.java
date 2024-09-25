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

public class MainPanel extends JPanel
{
   private Player player;
   private StatPanel s;
   private GamePanel g;
   private SleepPanel p;
   private Timer t;
   private JButton action, submit;
   private JTextField val;
   private JPanel question;
   private JLabel word;
   public MainPanel()
   {
      player = new Player();
      setLayout(new BorderLayout());
      setBackground(new Color(0, 0,0));
      s = new StatPanel(player);
      add(s, BorderLayout.NORTH);
      action = new JButton("SLEEP");
      action.setHorizontalAlignment(JButton.CENTER);
      action.setBackground(new Color(153, 255, 153));
      action.setFocusable(false);
      g=new GamePanel(player, s, action);
      add(g, BorderLayout.CENTER);
      this.t = new Timer(50, new Listener());
      p=new SleepPanel(player, t, g);
      p.setVisible(false);
      question = new JPanel();
      word = new JLabel("How many hours do you want to sleep for?");
      val = new JTextField("", 5);
      submit = new JButton("SUBMIT");
      submit.addActionListener(new sleepListener());
      submit.setFocusable(false);
      question.add(word);
      question.add(val);
      question.add(submit);
      question.setFocusable(false);
      add(question, BorderLayout.SOUTH);
      question.setVisible(false);  
      t.start();
   }
   private class Listener implements ActionListener
    {
        public void actionPerformed(final ActionEvent e)
        {
               if(g.isSleeping())
               {
                  action.setVisible(false); 
                  question.setVisible(true);  
                  question.add(word);
                  question.add(val);
                  question.add(submit);
                  val.setFocusable(true);
                  repaint();
                  g.repaint();
                  t.stop();                          
               }   
               else
               { 
                  val.setFocusable(false);
                  g.setFocusable(true);
                  repaint();
                  g.repaint();
                  p.setVisible(false);
                  g.setVisible(true);
                  s.setVisible(true);
                  action.setVisible(true);       
               } 
        }
    }
    private class sleepListener implements ActionListener
    {
      public void actionPerformed(final ActionEvent e)
      { 
               int hrs = Integer.parseInt(val.getText());
               player.sleep(hrs);
               p = new SleepPanel(player, t, g);
               p.setVisible(false);
               g.setVisible(false);
               s.setVisible(false);
               question.remove(val);
               question.remove(submit);
               question.setVisible(false);
               remove(question);
               action.setVisible(false);
               p.setVisible(true);
               add(p, BorderLayout.CENTER);
               repaint(); 
               g.wakeUp();    
               g.setFocusable(true);  
               p.setFocusable(false);      
               g.repaint();
               repaint();
      }
    }
}