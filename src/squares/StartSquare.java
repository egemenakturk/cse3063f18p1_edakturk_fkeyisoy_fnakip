package squares;

import tools.Player;

public class StartSquare extends Square {
    public StartSquare(String name) {
        super(name);
    }

    @Override
    public void action(Player player) {
        player.getCash().addCash(200);
    }
}
