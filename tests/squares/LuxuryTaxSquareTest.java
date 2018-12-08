package squares;

import org.junit.Test;
import tools.Board;
import tools.Cash;
import tools.Piece;
import tools.Player;

import static org.junit.Assert.*;

public class LuxuryTaxSquareTest {

    long amount = 200;
    LuxuryTaxSquare cs = new LuxuryTaxSquare("ITS");
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