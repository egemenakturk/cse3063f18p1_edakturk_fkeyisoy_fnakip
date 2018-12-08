package tools;

import org.junit.Test;

import static org.junit.Assert.*;

public class PieceTest {

    Piece p = new Piece(1,"shoe");

    @Test
    public void getName() throws Exception {
        assertEquals("shoe",p.getName());
    }

    @Test
    public void setName() throws Exception {
        p.setName("unicorn");
        assertEquals("unicorn",p.getName());
    }

    @Test
    public void getShape() throws Exception {
        assertEquals(1,p.getShape());
    }

    @Test
    public void setShape() throws Exception {
        p.setShape(2);
        assertEquals(2,p.getShape());
    }
}