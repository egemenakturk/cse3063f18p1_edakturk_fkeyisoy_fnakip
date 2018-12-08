package squares;

import tools.Player;

import java.util.Random;

public class ChanceSquare extends Square {
    public ChanceSquare(String name) {
        super(name);
    }

    @Override
    public void action(Player player) {
        Random random = new Random();
        int card=random.nextInt(3);
        switch (card){
            case 0:
                player.getCash().addCash(100);
                System.out.println(player.getName()+" won 100 cash..");
                break;
            case 1:
                System.out.println(player.getName()+ " lost 50 cash..");
                player.getCash().dropCash(50);
                break;
            case 2:
                System.out.println(player.getName()+" is going to starting point..");
                player.setSquareIndex(0);
                player.getBoard().getSquare(player.getSquareIndex()).action(player);
                break;
        }

    }
}
