package squares;

import tools.Die;
import tools.Player;

import java.util.Random;

public class JailSquare extends Square {
    public JailSquare(String name) {
        super(name);
    }

    @Override
    public void action(Player player) {
        System.out.println(player.getName() + " is in the jail..");

    }
}
