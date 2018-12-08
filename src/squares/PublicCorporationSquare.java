package squares;

import tools.Player;

import java.util.Random;

public class PublicCorporationSquare extends PropertySquare {
    public PublicCorporationSquare(String name) {
        super(name);
    }

    @Override
    public void action(Player player) {
        if(!this.isHasOwner() && !player.equals(this.getOwner())){
            if((player.getCash().getAmount()-this.getPrice()) < 0){
                System.out.println(player.getName() + " cannot afford to buy this place.");
                return;
            }
            System.out.println(player.getName()+ " is paying "+ this.getPrice()+" to buy " + this.getName()+ "..");
            player.getCash().dropCash(this.getPrice());
            player.getProperties().add(this);
            this.setHasOwner(true);
            this.setOwner(player);
        }
        else {
            Random random = new Random();
            int fv = random.nextInt(11)+2;
            System.out.println(this.getName()+ " has an owner. " + player.getName()+" is paying " + this.getRent()+ " to its owner " + this.getOwner().getName());
            this.setRent(fv*10);
            while((player.getCash().getAmount()-this.getRent()) < 0 && player.getProperties().size()>0){
                System.out.println(player.getName() + " cannot afford to pay this rent...");
                if(player.getProperties().size()>0){
                    PropertySquare square = player.getProperties().get(player.getProperties().size()-1);
                    player.getCash().addCash(square.getPrice()/2);
                    System.out.println(square.getName()+ " is sold to "+ (square.getPrice()/2) +" cash..");
                    player.getProperties().remove(square);
                    square.setOwner(null);
                    square.setHasOwner(false);
                }
            }
            if((player.getCash().getAmount()-this.getRent())<0){
                System.out.println(player.getName()+ " is bankrupt. Player is getting out of the game..");
                player.setBankrupt(true);
            }
            player.getCash().dropCash(this.getRent());
            this.getOwner().getCash().addCash(this.getRent());
            System.out.println(player.getName()+"s new balance is " + player.getCash().getAmount() + " cash..");
        }

    }

}
