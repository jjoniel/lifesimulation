import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class eatListener implements ActionListener
{
    private Player player;
    public eatListener(Player p)
    {
        player = p;
    }
    public void actionPerformed(final ActionEvent e)
    {
        player.eat();
    }
}