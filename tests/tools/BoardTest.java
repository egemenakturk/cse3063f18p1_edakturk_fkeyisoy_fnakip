package tools;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    private Board board = new Board();

    @Test
    public void getSquare() throws Exception {
        for(int i=0; i<40; i++){
            if(i==0)
                assertEquals("Start",board.getSquare(i).getName());
            else if (i == 2 || i == 17 || i == 33)
                assertEquals("Chest",board.getSquare(i).getName());
            else if (i == 7 || i == 22 || i == 36)
                assertEquals("Chance",board.getSquare(i).getName());
            else if (i == 4)
                assertEquals("IncomeTaxSquare",board.getSquare(i).getName());
            else if (i == 10)
                assertEquals("JailSquare",board.getSquare(i).getName());
            else if (i == 20)
                assertEquals("FreeParkingSquare",board.getSquare(i).getName());
            else if (i == 30)
                assertEquals("GoToJailSquare",board.getSquare(i).getName());
            else if (i == 38)
                assertEquals("LuxuryTaxSquare",board.getSquare(i).getName());
        }
    }
}