package squares;

import tools.Player;

import java.util.Random;

public class ChestSquare extends Square{
    public ChestSquare(String name) {
        super(name);
    }

    @Override
    public void action(Player player) {
        System.out.println(player.getName()+ " is picking a chest card:");
        Random random = new Random();
        int card=random.nextInt(3);
        switch (card){
            case 0:
                player.getCash().addCash(150);
                System.out.println("Player won 150 cash..");
                break;
            case 1:
                System.out.println("Player lost 120 cash..");
                player.getCash().dropCash(120);
                break;
            case 2:
                System.out.println("Player is going to starting point..");
                player.setSquareIndex(0);
                player.getBoard().getSquare(player.getSquareIndex()).action(player);
                break;
        }

    }
}
