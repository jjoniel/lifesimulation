import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class sleepListener implements ActionListener
{
    private Player player;
    public sleepListener(Player p)
    {
        player = p;
    }
    public void actionPerformed(final ActionEvent e)
    {
        player.sleep();
    }
}