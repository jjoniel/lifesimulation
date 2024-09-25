import java.awt.event.ActionEvent;
import java.awt.image.ImageObserver;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;
import javax.swing.JPanel;

// 
// Decompiled by Procyon v0.5.36
// 

public class Sample extends JPanel
{
    private static final int FRAME = 400;
    private static final Color BACKGROUND;
    private BufferedImage myImage;
    private Graphics myBuffer;
    private Timer t;
    private Polkadot pd;
    private Polkadot pd2;
    
    public Sample() {
        this.myImage = new BufferedImage(400, 400, 1);
        (this.myBuffer = this.myImage.getGraphics()).setColor(PolkaDotPanel.BACKGROUND);
        this.myBuffer.fillRect(0, 0, 400, 400);
        this.pd = new Polkadot();
        this.pd2 = new Polkadot(0.0, 0.0, 50.0, Color.green);
        (this.t = new Timer(1000, new Listener())).start();
    }
    
    public void paintComponent(final Graphics g) {
        g.drawImage(this.myImage, 0, 0, this.getWidth(), this.getHeight(), null);
    }
    
    static {
        BACKGROUND = new Color(204, 204, 204);
    }
    
    private class Listener implements ActionListener
    {
        public void actionPerformed(final ActionEvent e) {
            PolkaDotPanel.this.myBuffer.setColor(PolkaDotPanel.BACKGROUND);
            PolkaDotPanel.this.myBuffer.fillRect(0, 0, 400, 400);
            PolkaDotPanel.this.pd.jump(400, 400);
            PolkaDotPanel.this.pd.draw(PolkaDotPanel.this.myBuffer);
            PolkaDotPanel.this.pd2.jump(400, 400);
            PolkaDotPanel.this.pd2.draw(PolkaDotPanel.this.myBuffer);
            PolkaDotPanel.this.repaint();
        }
    }
}