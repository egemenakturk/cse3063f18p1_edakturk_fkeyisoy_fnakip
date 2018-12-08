package squares;

import tools.Player;

import java.util.Random;

public class ChanceSquare extends Square {
    public ChanceSquare(String name) {
        super(name);
    }

    @Override
    public void action(Player player) {
        System.out.println(player.getName()+ " is picking a chance card:");
        Random random = new Random();
        int card=random.nextInt(4);
        switch (card){
            //player won 100 cash
            case 0:
                player.getCash().addCash(100);
                System.out.println("Player won 100 cash..");
                break;
            //player lose 50 cash
            case 1:
                System.out.println("Player lost 50 cash..");
                player.getCash().dropCash(50);
                break;
            case 2:
                System.out.println("Player is going to starting point..");
                player.setSquareIndex(0);
                player.getBoard().getSquare(player.getSquareIndex()).action(player);
                break;
            //Player pay tax for properties
            case 3:
                System.out.println("Player is paying tax for the number of properties :" + (player.getProperties().size()*25) + " cash");
                player.getCash().dropCash(player.getProperties().size()*25);
                break;
        }

    }
}
