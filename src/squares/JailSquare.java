package squares;

import tools.Die;
import tools.Player;

import java.util.Random;

public class JailSquare extends Square {
    public JailSquare(String name) {
        super(name);
    }

    @Override
    public void action(Player player) {
        if(!player.isInJail())
            player.setInJail(true);
        else{
            Random random = new Random();
            int choice= random.nextInt(2);
            switch (choice){
                case 0:
                    System.out.println(player.getName()+" is trying to throw doubles..");
                    Die die= new Die();
                    int die1= die.rollDie();
                    int die2 = die.rollDie();
                    System.out.println("Rolled dice: "+ die1 +" and " +die2);
                    if(die1==die2) {
                        player.setInJail(false);
                        System.out.println(player.getName() + " is getting out of the jail..");
                    }
                    else
                        System.out.println(player.getName() + " is  not getting out of the jail..");
                    break;
                case 1:
                    System.out.println(player.getName()+" is paying 50 cash to get out of jail..");
                    player.getCash().dropCash(50);
                    player.setInJail(false);
                    break;
            }
        }

    }
}
