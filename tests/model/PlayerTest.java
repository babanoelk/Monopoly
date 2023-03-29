package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    ArrayList<Player> players = new ArrayList<>();
    @BeforeEach
    void setUp() {
        players.add(new Player("Egon"));
        players.get(0).receiveAmount(30000);
        players.add(new Player("Benny"));
        players.get(1).receiveAmount(30000);
        players.add(new Player("Kjeld"));
        players.get(2).receiveAmount(30000);
        players.add(new Player("Søren"));
        players.get(3).receiveAmount(30000);
    }

    @Test
    void getBalance() {
        assertEquals(30000, players.get(0).getBalance());
    }

    @Test
    void receiveAmount() {
        int b = players.get(0).getBalance();
        int addAmount = 1000;
        assertEquals(b+addAmount, players.get(0).receiveAmount(addAmount));
    }

    @Test
    void getId() {
        assertEquals(1, players.get(0).getId());
    }

    @Test
    void getName() {
        assertTrue("Egon".equals(players.get(0).getName()));
    }

    @Test
    void testToString() {
        Player p = players.get(0);
        String test = p.getName()+": "+ p.getBalance();

        assertEquals(test, p.toString());


    }
    //return getName()+ ": "+ this.account.getBalance();
}