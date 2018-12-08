package squares;

import tools.Die;
import tools.Player;

public class ChestSquare extends Square{
    public ChestSquare(String name) {
        super(name);
    }

    @Override
    public void action(Player player) {
        player.rollDice(new Die());

    }
}
