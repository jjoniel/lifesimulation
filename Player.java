import java.awt.*;
import javax.swing.*;

public class Player
{
   private int myX;
   private int myY;
   private String name;
   private int age;
   private int health;
   private int hunger;
   private int sleep;
   private int money;   
   private int direction;
   private ImageIcon i;
   private int room;
   private int day;
   private int time;
   private int[] food;
   private int mult = 1;
   private int[] dv = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
   public boolean dead = false;
   
   public Player()
   {
      myX = 101;
      myY = 250;
      name = "Kai";
      age = 22;
      hunger = 75;
      sleep = 75;
      health = (hunger+sleep)/2;
      money = 100;
      room = 0;
      direction=1;
      day = 1;
      time = 480;
      food = new int[10];
      i = new ImageIcon("person1.png");
   }
   public Player(String n)
   {
      myX = 101;
      myY = 250;
      name = n;
      age = 22;
      hunger = 75;
      sleep = 75;
      health = (hunger+sleep)/2;
      money = 100;
      room = 0;
      day = 1;
      time = 480;
      i = new ImageIcon("person1.png");
   }
   public Player(String n, int x, int y, int age, int hunger, int sleep, int money, int room, int day, int time, int direction)
   {
      myX = x;
      myY = y;
      name = n;
      age = age;
      hunger = hunger;
      sleep = sleep;
      health = (hunger+sleep)/2;
      money = money;
      room = room;
      day = day;
      time = time;
      direction = direction;
      i = new ImageIcon("person1.png");
   }
   public String getName()
   {
      return name;
   }
   public int getAge()
   {
      return age;
   }
   public int getRoom()
   {
      return room;
   }
   public int getHealth()
   {
      return health;
   }
   public int getHunger()
   {
      return hunger;
   }
   public int getMoney()
   {
      return money;
   }
   public int getX()
   {
      return myX;
   }
   public int getY()
   {
      return myY;
   }
   public int getDirection()
   {
      return direction;
   }
   public int getDay()
   {
      return day;
   }
   public int getTime()
   {
      return time;
   }
   public void setName(String n)
   {
      name = n;
   }
   public void setAge(int a)
   {
      age = a;
   }
   public void setRoom(int r)
   {
      room = r;
   }
   public void setHealth(int h)
   {
      health = h;
   }
   public void setHunger(int h)
   {
      hunger = h;
   }
   public void setMoney(int m)
   {
      money = m;
   }
   public void setX(int x)
   {
      myX = x;
   }
   public void setY(int y)
   {
      myY = y;
   }
   public void setDirection(int d)
   {
      direction = d;
   }
   public int nightDay()
   {
      if(time>360&&time<1080)
         return 0;
      else
         return 1;
   }   
   public void move(int dir, int pic)
   {
      direction = dir;
      mult *= -1;
      i = new ImageIcon("walk"+pic%2*mult+""+dir+".png");
      myX+=dir*100;
      if(pic%10==0)
      {
         hunger--;
         sleep--;
      }      
   }
   public int time(int steps)
   {
      if(steps%10==0)
         time++;
      if(time>=1440)
      {
         time=0;
         day++; 
      }
      return time;
   }
   public void sleepTime(int hrs)
   {
      time+=hrs*60;
      if(time>=1440)
      {
         day+=time/1440; 
         time=time%1440;
      }
   }   
   public void nextRoom()
   {
      room++;
   }
   public void previousRoom()
   {
      room--;
   }
   public void stop()
   {
      i = new ImageIcon("person"+direction+".png");         
   }   
   public void draw(Graphics myBuffer) 
   {
      myBuffer.drawImage(i.getImage(), myX, myY, 280, 450, null);
   }
   public void sleep(int hrs)
   {
      sleep+=hrs*10;
      hunger-=hrs*3;
      sleepTime(hrs);  
      health();
   }
   public void health()
   {
      if(sleep>100)
         sleep=100;
      if(hunger>100)
         hunger=100;
      health = (sleep+hunger)/2;
      if(health>100)
         health=100;
      if(health<=0)
      {
         dead = true;  
      }
   }
   public void eat()
   {
      int type = Integer.parseInt(JOptionPane.showInputDialog("What would you like to eat?\n[0] Bread ("+food[0]+")\n[1] Fruit ("+food[1]+")\n[2] Burger("+food[2]+")"));
      //System.out.println(type);
   }
}