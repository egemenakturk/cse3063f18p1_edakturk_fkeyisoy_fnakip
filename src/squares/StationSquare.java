package squares;

import tools.Player;

public class StationSquare extends PropertySquare {
    public StationSquare(String name) {
        super(name);
    }

    @Override
    public void action(Player player) {
        //if the square has no owner the square can be bought
        if(!this.isHasOwner()){
            if((player.getCash().getAmount()-this.getPrice()) < 0){
                System.out.println(player.getName() + " cannot afford to buy this place.");
                return;
            }
            System.out.println(player.getName()+ " is paying "+ this.getPrice()+" to buy " + this.getName()+ "..");
            player.getCash().dropCash(this.getPrice());
            player.getStations().add(this);
            player.getProperties().add(this);
            this.setHasOwner(true);
            this.setOwner(player);
            this.setRent((player.getStations().size()+1)*50);
            System.out.println(player.getName()+"s new balance is " + player.getCash().getAmount() + " cash..");
        }
        //if square has another owner, player pay rent to its owner
        else if(!player.equals(this.getOwner())){
            System.out.println(this.getName()+ " has an owner. " + player.getName()+" is paying " + this.getRent()+ " to its owner " + this.getOwner().getName());

            //sell properties until player gets enough money
            while((player.getCash().getAmount()-this.getRent()) < 0 && player.getProperties().size()>0){
                System.out.println(player.getName() + " cannot afford to pay this rent..");
                if(player.getProperties().size()>0){
                    PropertySquare square = player.getProperties().get(player.getProperties().size()-1);
                    player.getCash().addCash(square.getPrice()/2);
                    System.out.println(square.getName()+ " is sold to "+ (square.getPrice()/2) +"..");
                    player.getProperties().remove(square);
                    square.setOwner(null);
                    square.setHasOwner(false);
                }
            }
            //if no property left and players money is ran out, player went bankrupt
            if((player.getCash().getAmount()-this.getRent())<0){
                System.out.println(player.getName()+ " is bankrupt. Player is getting out of the game..");
                player.setBankrupt(true);
            }
            player.getCash().dropCash(this.getRent());
            this.getOwner().getCash().addCash(this.getRent());
            System.out.println(player.getName()+"s new balance is " + player.getCash().getAmount() + " cash..");
        }
        else {
            System.out.println(player.getName()+ " is the owner..");
        }

    }
}
