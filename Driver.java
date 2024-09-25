import java.awt.Container;
import javax.swing.JFrame;

public class Driver
{
    public static void main(final String[] args) {
        final JFrame frame = new JFrame("Game");
        frame.setSize(1500, 1000);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(3);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setFocusable(false);
        frame.setContentPane(new MainPanel());
        frame.setVisible(true);
    }
}