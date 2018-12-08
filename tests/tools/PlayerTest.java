package tools;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;

public class PlayerTest {

    List list = new ArrayList();
    Piece piece = new Piece(1, "unicorn");
    Cash c = new Cash(200);
    Board b = new Board();
    Player p = new Player("hackerman",piece,0,c,false,false,b);


    @Test
    public void getProperties() {
        assertEquals(list,p.getProperties());
    }

    @Test
    public void isInJail() {
        assertEquals(false,p.isInJail());
    }

    @Test
    public void setInJail() {
        p.setInJail(true);
        assertEquals(true,p.isInJail());
    }

    @Test
    public void getBoard() {
        assertEquals(b,p.getBoard());
    }

    @Test
    public void setBoard() {
        Board b2 = new Board();
        p.setBoard(b2);
        assertEquals(b2,p.getBoard());
    }

    @Test
    public void getSquareIndex() {
        assertEquals(0,p.getSquareIndex());
    }

    @Test
    public void setSquareIndex() {
        p.setSquareIndex(2);
        assertEquals(2,p.getSquareIndex());
    }

    @Test
    public void getName() {
        assertEquals("hackerman",p.getName());
    }
    @Test
    public void setName() {
        p.setName("donatello");
        assertEquals("donatello",p.getName());
    }

    @Test
    public void getPiece() {
        assertEquals(piece,p.getPiece());
    }

    @Test
    public void setPiece() {
        Piece piece2 = new Piece(1, "50kurus");
        p.setPiece(piece2);
        assertEquals(piece2,p.getPiece());

    }

    @Test
    public void getCash() {
        assertEquals(c,p.getCash());
    }

    @Test
    public void setCash() {
        Cash c2 = new Cash(200);
        p.setCash(c2);
        assertEquals(c2,p.getCash());
    }

    @Test
    public void isBankrupt() {
        assertEquals(false,p.isBankrupt());
    }

    @Test
    public void setBankrupt() {
        p.setBankrupt(true);
        assertEquals(true,p.isBankrupt());
    }
}