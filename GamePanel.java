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

public class GamePanel extends JPanel {
    private static final int FRAME = 400;
    private BufferedImage myImage;
    private Graphics myBuffer;
    private Player player;
    private Timer z;
    private int count = 1;
    private long start;
    private StatPanel stats;
    private JButton action;
    private ImageIcon i;
    private boolean sleeping;
    private boolean eating;

    public GamePanel(Player p, StatPanel s, JButton a) {
        setLayout(new BorderLayout());
        player = p;
        stats = s;
        this.myImage = new BufferedImage(400, 400, 1);
        (this.myBuffer = this.myImage.getGraphics()).setColor(Color.RED);
        this.myBuffer.fillRect(0, 0, 400, 400);
        (this.z = new Timer(50, new Listener())).start();
        this.addKeyListener(new Key());
        this.setFocusable(true);
        action = a;
        action.addActionListener(new actionsListener(z));
        add(action, BorderLayout.SOUTH);
    }

    public void paintComponent(final Graphics g) {
        i = new ImageIcon(player.getRoom() + "" + player.nightDay() + ".png");
        g.drawImage(i.getImage(), 0, 0, getWidth(), getHeight(), null);
        player.draw(g);
        function();
    }

    public void function() {
        switch (player.getRoom()) {
            case 0:
                if (player.getX() <= 550) {
                    action.setText("SLEEP");
                    action.setVisible(true);
                } else {
                    action.setVisible(false);
                }
                break;
            case 1:
                if ((player.getX() >= 800 && player.getX() <= 1200) || (player.getX() >= 300 && player.getX() <= 500)) {
                    action.setText("EAT");
                    action.setVisible(true);
                } else {
                    action.setVisible(false);
                }
                break;
            case 2:
                if (player.getX() >= 200 && player.getX() <= 600) {
                    action.setText("SLEEP");
                    action.setVisible(true);
                } else {
                    action.setVisible(false);
                }

        }
    }

    public boolean bound() {
        if (player.getX() <= 0 && player.getRoom() <= 0) {
            player.setX(1);
            player.setRoom(0);
            return false;
        } else
            return true;
    }

    public void time() {
        int curr = player.getTime();
        int aft = player.time(count);
        if (curr > aft)
            count = 1;
    }

    public class Key extends KeyAdapter {
        @Override
        public void keyPressed(final KeyEvent e) {
            time();
            repaint();
            if (e.getKeyCode() == 37 && bound()) {
                player.move(-1, count);
                count++;
                System.out.println(player.getX());
                if ((player.getX() + 280) < 0) {
                    player.previousRoom();
                    player.setX(1300);
                }
                bound();
            } else if (e.getKeyCode() == 39 && bound()) {
                player.move(1, count);
                count++;
                System.out.println(player.getX());
                if (player.getX() > 1500) {
                    player.nextRoom();
                    player.setX(0);
                }
                bound();
            }
            repaint();
        }

        public void keyReleased(final KeyEvent e) {
            repaint();
            if (e.getKeyCode() == 37) {
                player.stop();
            } else if (e.getKeyCode() == 39) {
                player.stop();
            }
            repaint();
        }
    }

    private class Listener implements ActionListener {
        public void actionPerformed(final ActionEvent e) {
            i = new ImageIcon(player.getRoom() + player.nightDay() + ".png");
            player.draw(GamePanel.this.myBuffer);
            repaint();
            stats.update();
        }
    }

    private class actionsListener implements ActionListener {
        private Timer z;

        public actionsListener(Timer zet) {
            z = zet;
        }

        public void actionPerformed(final ActionEvent e) {
            switch (player.getRoom()) {
                case 0:
                    if (player.getX() <= 550) {
                        sleeping = true;
                    }
                    break;
                case 1:
                    if ((player.getX() >= 800 && player.getX() <= 1200)
                            || (player.getX() >= 300 && player.getX() <= 500)) {
                        eating = true;
                    }
                    break;
                case 2:
                    if (player.getX() >= 200 && player.getX() <= 600) {
                        sleeping = true;
                    }
                    break;
            }
            z.stop();
        }
    }

    public class eatListener implements ActionListener {
        public void actionPerformed(final ActionEvent e) {
            player.eat();
            eating = true;
        }
    }

    public void wakeUp() {
        sleeping = false;
        z.start();
        repaint();
    }

    public void finishEat() {
        eating = false;
        z.start();
        repaint();
    }

    public boolean isSleeping() {
        return sleeping;
    }

    public boolean isEating() {
        return eating;
    }
}