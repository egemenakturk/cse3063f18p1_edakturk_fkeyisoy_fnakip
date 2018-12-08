package squares;

import tools.Player;

public class IncomeTaxSquare extends Square {
    public IncomeTaxSquare(String name) {
        super(name);
    }

    @Override
    public void action(Player player) {
        System.out.println(player.getName()+ " is paying 200 cash..");
        player.getCash().dropCash(200);

    }
}
