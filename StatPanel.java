import javax.swing.*;
import java.awt.*;

public class StatPanel extends JPanel
{
   private Player player;
   private JLabel dLabel, tLabel, nLabel, aLabel, hLabel, mLabel;
   public StatPanel(Player p)
   {
      player = p;
      
      setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
      setBackground(new Color(153, 255, 153));
      setLayout(new GridLayout(1, 5));
      
      dLabel = new JLabel("Day: "+player.getDay());
      dLabel.setFont(new Font("Andale Mono", Font.BOLD, 25));
      dLabel.setForeground(Color.BLACK);
      dLabel.setHorizontalAlignment(JLabel.CENTER);
      add(dLabel);
      
      tLabel = new JLabel("Day: "+player.getDay()); 
      tLabel.setFont(new Font("Andale Mono", Font.BOLD, 25));
      tLabel.setForeground(Color.BLACK);
      tLabel.setHorizontalAlignment(JLabel.CENTER);
      add(tLabel);
      
      nLabel = new JLabel("Name: "+player.getName());
      nLabel.setFont(new Font("Andale Mono", Font.BOLD, 25));
      nLabel.setForeground(Color.BLACK);
      nLabel.setHorizontalAlignment(JLabel.CENTER);
      add(nLabel);
      
      aLabel = new JLabel("Age: "+player.getAge());
      aLabel.setFont(new Font("Andale Mono", Font.BOLD, 25));
      aLabel.setForeground(Color.BLACK);
      aLabel.setHorizontalAlignment(JLabel.CENTER);
      add(aLabel);
      
      hLabel = new JLabel("Health: "+player.getHealth()+"%");
      hLabel.setFont(new Font("Andale Mono", Font.BOLD, 25));
      hLabel.setForeground(Color.BLACK);
      hLabel.setHorizontalAlignment(JLabel.CENTER);
      add(hLabel);
      
      mLabel = new JLabel("Money: "+player.getMoney());
      mLabel.setFont(new Font("Andale Mono", Font.BOLD, 25));
      mLabel.setForeground(Color.BLACK);
      mLabel.setHorizontalAlignment(JLabel.CENTER);
      add(mLabel);
   }
   public void update()
   {
      dLabel.setText("Day: "+player.getDay()); 
      
      if(player.getTime()%60<10)
      {
         tLabel.setText(player.getTime()/60+":0"+player.getTime()%60);
      }
      else
      {
         tLabel.setText(player.getTime()/60+":"+player.getTime()%60);
      }     
      nLabel.setText("Name: "+player.getName());
      
      aLabel.setText("Age: "+player.getAge());
      
      hLabel.setText("Health: "+player.getHealth()+"%");
      
      mLabel.setText("Money: $"+player.getMoney());

   }
}