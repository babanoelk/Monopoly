package model;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    void setup() {
    }
        @org.junit.jupiter.api.Test
        void getAccount () {
        }

        @org.junit.jupiter.api.Test
        void receiveAmount () {
            Player p1 = new Player("Frodo");
            p1.receiveAmount(30000);
            assertEquals(30000,p1.getAccount().getBalance());
        }

}