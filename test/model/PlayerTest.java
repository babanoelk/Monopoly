package model;

import static org.junit.jupiter.api.Assertions.*;

import model.Player;
import org.junit.jupiter.api.Assertions;

class PlayerTest {
    @org.junit.jupiter.api.BeforeEach
    void setup() {
        p1 = new Player("spiler1");
        p2 = new Player("spiler2");


    }

    Player p1;
    Player p2;


    @org.junit.jupiter.api.Test
    void receiveAmount() {


        int pb;
        pb = p1.getBalance();
        pb += 10;
        Assertions.assertEquals(pb, p1.receiveAmount(10));

        pb += 100;
        Assertions.assertEquals(pb, p1.receiveAmount(100));


    }

}