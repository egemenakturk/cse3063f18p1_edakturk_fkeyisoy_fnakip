package squares;

import tools.Player;

public class StationSquare extends PropertySquare {
    public StationSquare(String name) {
        super(name);
    }

    @Override
    public void action(Player player) {
        if(!this.isHasOwner()){
            System.out.println(player.getName()+ " is paying "+ this.getPrice()+" to buy " + this.getName()+ "..");
            player.getCash().dropCash(this.getPrice());
            player.getStations().add(this);
            player.getProperties().add(this);
            this.setHasOwner(true);
            this.setOwner(player);
            this.setRent((player.getStations().size()+1)*50);
        }
        else {
            System.out.println(this.getName()+ " has an owner. " + player.getName()+" is paying " + this.getRent()+ " to its owner " + this.getOwner().getName());
            player.getCash().dropCash(this.getRent());
            this.getOwner().getCash().addCash(this.getRent());
        }

    }
}
