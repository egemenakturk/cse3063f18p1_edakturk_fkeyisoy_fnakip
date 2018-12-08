package squares;

import tools.Cash;
import tools.Player;

public class LotSquare extends PropertySquare {
    public LotSquare(String name) {
        super(name);
    }

    @Override
    public void action(Player player) {
        if(!this.isHasOwner()){
            if((player.getCash().getAmount()-this.getPrice()) < 0){
                System.out.println(player.getName() + " cannot afford to buy this place.");
                return;
            }
            System.out.println(player.getName()+ " is paying "+ this.getPrice()+" to buy " + this.getName()+ "..");
            player.getCash().dropCash(this.getPrice());
            player.getProperties().add(this);
            this.setOwner(player);
            this.setHasOwner(true);
        }
        else if(this.getOwner().equals(player)){
            if((player.getCash().getAmount()-this.getPrice()) < 0){
                System.out.println(player.getName() + " cannot afford to buy this place.");
                return;
            }
            System.out.println(player.getName()+ " is paying "+ this.getPrice()+" to build a house on " + this.getName()+ "..");
            player.getCash().dropCash(this.getPrice());
            this.setPrice(this.getPrice()*2);
            this.setRent(this.getRent()*2);
        }
        else{
            System.out.println(this.getName()+ " has an owner. " + player.getName()+" is paying " + this.getRent()+ " to its owner " + this.getOwner().getName()+"..");
            while((player.getCash().getAmount()-this.getRent()) < 0 && player.getProperties().size()>0){
                System.out.println(player.getName() + " cannot afford to pay this rent");
                if(player.getProperties().size()>0){
                    PropertySquare square = player.getProperties().get(player.getProperties().size()-1);
                    player.getCash().addCash(square.getPrice()/2);
                    player.getProperties().remove(square);
                    System.out.println(square.getName()+ " is sold..");
                }
            }
            player.getCash().dropCash(this.getRent());
            this.getOwner().getCash().addCash(this.getRent());
            System.out.println("New balance is " + player.getCash().getAmount() + " cash..");
        }
    }
}