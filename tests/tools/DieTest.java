package tools;

import org.junit.Test;

import static org.junit.Assert.*;

public class DieTest {

    public Die die = new Die();



    @Test
    public void getFaceValue() throws Exception {
        int value = die.rollDie();
        assertEquals(value,die.getFaceValue());
    }

    @Test
    public void setFaceValue() throws Exception {
        die.setFaceValue(3);
        assertEquals(3,die.getFaceValue());
    }
}