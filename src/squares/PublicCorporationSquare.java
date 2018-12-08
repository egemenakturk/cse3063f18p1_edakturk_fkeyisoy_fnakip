package squares;

import tools.Die;
import tools.Player;

public class PublicCorporationSquare extends PropertySquare {
    public PublicCorporationSquare(String name) {
        super(name);
    }

    @Override
    public void action(Player player) {
        //if square has no owner, player can buy it
        if(!this.isHasOwner()){
            if((player.getCash().getAmount()-this.getPrice()) < 0){
                System.out.println(player.getName() + " cannot afford "+ this.getPrice()+" cash to buy this place.");
                return;
            }
            System.out.println(player.getName()+ " is paying "+ this.getPrice()+" to buy " + this.getName()+ "..");
            player.getCash().dropCash(this.getPrice());
            player.getProperties().add(this);
            this.setHasOwner(true);
            this.setOwner(player);
            System.out.println(player.getName()+"s new balance is " + player.getCash().getAmount() + " cash..");
        }
        //if square has another owner, player rent a value that ten times of the dice value
        else if(!player.equals(this.getOwner())) {
            Die die = new Die();
            int die1=die.rollDie();
            int die2=die.rollDie();
            System.out.println(player.getName() +" is rolling dice: "+ die1 + " and " + die2 );
            this.setRent((die1+die2)*10);
            System.out.println(player.getName()+" is paying " +(die1+die2)+"*10 = "+ this.getRent()+ " to its owner " + this.getOwner().getName());

            //sell properties until player gets enough money
            while((player.getCash().getAmount()-this.getRent()) < 0 && player.getProperties().size()>0){
                System.out.println(player.getName() + " cannot afford to pay this rent...");
                if(player.getProperties().size()>0){
                    PropertySquare square = player.getProperties().get(player.getProperties().size()-1);
                    player.getCash().addCash(square.getPrice()/2);
                    System.out.println(square.getName()+ " is sold to "+ (square.getPrice()/2) +" cash..");
                    if(square instanceof StationSquare){
                        player.getStations().remove(square);
                    }
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
