import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        //todo: change to instantiation of Game class
        Game game = new Game(3);
        //todo:  call game.setup() - a method you will add to the Game class that
        // a. loads or prompts for gamedata,
        // b. creates the Player objects
        // (reuse the code beneath)





        //Testcode
        Player c = game.getPlayer(0);
        game.displayPlayers();
        c.receiveAmount(100000);
        //todo: add this line to the endGame method in class Game
        //fileIO.saveData("src/data.csv", game.getPlayers());

    }
}