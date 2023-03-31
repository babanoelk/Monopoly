package model;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @org.junit.jupiter.api.Test
    void receiveAmountTest() {
        Player play1 = new Player("Ahmad");
        Player play2 = new Player("Morten");
        play1.receiveAmount(10000);
        play2.receiveAmount(1000);

        assertEquals(10000,play1.getBalance());
        assertEquals(1000,play2.getBalance());
        play1.receiveAmount(2000);
        play2.receiveAmount(3000);
        assertEquals(12000,play1.getBalance());
        assertEquals(4000,play2.getBalance());
    }
}