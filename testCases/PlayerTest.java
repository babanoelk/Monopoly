import model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {



    Player p;

    @BeforeEach
    void setup(){
        p = new Player("test");
        //p.getAccount().setBalance(100);

    }


    @Test
    void receiveAmount() {

        assertEquals(100, p.receiveAmount(100));



    }
}