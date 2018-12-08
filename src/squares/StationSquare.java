package squares;

import tools.Player;

public class StationSquare extends PropertySquare {
    public StationSquare(String name) {
        super(name);
    }

    @Override
    public void action(Player player) {
        System.out.println(player.getName()+ " is paying "+ this.getPrice()+" to buy " + this.getName()+ "..");
        player.getCash().dropCash(this.getPrice());

    }
}
