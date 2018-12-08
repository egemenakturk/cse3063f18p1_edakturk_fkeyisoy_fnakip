package tools;

import org.junit.Test;

import static org.junit.Assert.*;

public class CashTest  {

    private Cash cash = new Cash(200);

    @Test
    public void getAmount() throws Exception {
        assertEquals(200,cash.getAmount());

    }

    @Test
    public void setAmount() throws Exception {
        cash.setAmount(400);
        assertEquals(400, cash.getAmount());
    }

    @Test
    public void addCash() throws Exception {
        cash.addCash(100);
        assertEquals(300, cash.getAmount());
    }

    @Test
    public void dropCash() throws Exception {
        cash.dropCash(100);
        assertEquals(100, cash.getAmount());
    }
}