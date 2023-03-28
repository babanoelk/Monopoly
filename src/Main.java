import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        //todo: change to instantiation of Game class
        Game game = new Game(3);
        //todo:  call game.setup() - a method you will add to the Game class that
        // a. loads or prompts for gamedata,
        // b. creates the Player objects
        // (reuse the code beneath)



        TextUI ui = new TextUI();
        int count = 0;

        FileIO fileIO = new FileIO();
        ArrayList<String> data = fileIO.readGameData("src/data.csv");

        if(data.size()>0) {

// OVERSÆT FIL INPUT DATA TIL OBJEKTER

            for (String s : data) {
                String[] line = s.split(",");
                String name = line[0];
                int balance = Integer.parseInt(line[1].trim());
                Player c = game.registerPlayer(name);
                c.receiveAmount(balance);
            }

// OVERSÆT BRUGER INPUT DATA TIL OBJEKTER

        }else {

            while (count < game.customerLimit) {
                String name = ui.getInput("Skriv kundens navn: ");
                Player c = game.registerPlayer(name);
                c.receiveAmount(30000);
                count++;
            }
        }


        //Testcode
        Player c = game.getPlayer(0);
        game.displayPlayers();
        c.receiveAmount(100000);
        //todo: add this line to the endGame method in class Game
        fileIO.saveData("src/data.csv", game.getPlayers());

    }
}