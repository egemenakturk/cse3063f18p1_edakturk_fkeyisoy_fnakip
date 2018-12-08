package squares;

import tools.Player;

public class GoToJailSquare extends Square {
    public GoToJailSquare(String name) {
        super(name);
    }

    @Override
    public void action(Player player) {
        System.out.println(player.getName() + " is going to jail...");
        player.setSquareIndex(10);
        player.getCash().addCash(200);
        player.setInJail(true);
    }
}
