package squares;

import org.junit.Test;
import tools.Board;
import tools.Cash;
import tools.Piece;
import tools.Player;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GoToJailSquareTest {

    long amount = 200;
    GoToJailSquare cs = new GoToJailSquare("gtj");
    Piece piece = new Piece(1, "unicorn");
    Cash c = new Cash(amount);
    Board b = new Board();
    Player p = new Player("hackerman",piece,4,c,false,false,b);

    @Test
    public void action() {
        cs.action(p);
        long newCash = p.getCash().getAmount();
        assertNotEquals(amount,newCash);

    }
}