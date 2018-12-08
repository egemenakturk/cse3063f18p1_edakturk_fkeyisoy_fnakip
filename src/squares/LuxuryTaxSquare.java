package squares;

import tools.Player;

public class LuxuryTaxSquare extends Square {
    public LuxuryTaxSquare(String name) {
        super(name);
    }

    @Override
    public void action(Player player) {
        System.out.println(player.getName()+ " is paying 100 cash");
        player.getCash().dropCash(100);

    }
}
