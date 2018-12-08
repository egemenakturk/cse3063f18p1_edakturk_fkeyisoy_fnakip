package squares;

import org.junit.Test;
import tools.Board;
import tools.Cash;
import tools.Piece;
import tools.Player;

import static org.junit.Assert.*;

public class FreeParkingSquareTest {

    long amount = 200;
    FreeParkingSquare cs = new FreeParkingSquare("FreeParkingSquare");
    Piece piece = new Piece(1, "unicorn");
    Cash c = new Cash(amount);
    Board b = new Board();
    Player p = new Player("hackerman",piece,4,c,false,false,b);


    @Test
    public void action() {
        cs.action(p);
        int location=p.getSquareIndex();
        assertEquals(location,4);
    }
}