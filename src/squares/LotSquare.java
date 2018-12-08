package squares;

import tools.Cash;
import tools.Player;

public class LotSquare extends PropertySquare {
    public LotSquare(String name) {
        super(name);
    }

    @Override
    public void action(Player player) {
        System.out.println(player.getName()+ " is paying "+ this.getPrice()+" to buy " + this.getName()+ "..");
        player.getCash().dropCash(this.getPrice());
    }
}
