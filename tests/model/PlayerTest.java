package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    ArrayList<Player> players = new ArrayList<>();
    @BeforeEach
    void setUp() {
        players.add(new Player("A"));
        players.get(0).receiveAmount(30000);
        players.add(new Player("B"));
        players.get(1).receiveAmount(30000);
        players.add(new Player("C"));
        players.get(2).receiveAmount(30000);
        players.add(new Player("D"));
        players.get(3).receiveAmount(30000);
    }

    @Test
    void getBalance() {

        assertEquals(30000, players.get(0).getBalance());

    }

    @Test
    void receiveAmount() {
    }

    @Test
    void getId() {
    }

    @Test
    void getName() {

    }

    @Test
    void testToString() {
    }
}