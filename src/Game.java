import model.Player;
import util.FileIO;
import util.TextUI;

import java.util.ArrayList;
//Todo: - Rename class to Game,
//      - Change fields and methodnames so that it reflects precisely the Game class in the class diagram
//      - Add the setup method:
//      a. loads or prompts for gamedata,
//      b. creates the model.Player objects
//      (reuse the code from the main method)

public class Game {
    private int maxPlayers;
    private ArrayList<Player> players = new ArrayList<>();
    private TextUI ui = new TextUI();
    private FileIO io = new FileIO();

    public Game(int maxPlayers) {

        this.maxPlayers = maxPlayers;
    }

    public Player registerPlayer(String name) {
        Player p = new Player(name);
        players.add(p);
        return p;
    }

    public void displayPlayers() {
        for (Player p : players) {
            System.out.println(p);
        }
    }

    public Player getPlayer(int i) {

        return players.get(i);
    }

    public ArrayList<Player> getPlayers() {

        return players;
    }
    //todo: add endGame method

    public void setup() {

        int count = 0;
        ArrayList<String> data = io.readGameData("src/_data.csv");

        if(data.size()>0) {

// OVERSÆT FIL INPUT DATA TIL OBJEKTER

            for (String s : data) {
                String[] line = s.split(",");
                String name = line[0];
                int balance = Integer.parseInt(line[1].trim());
                Player p = this.registerPlayer(name);
                p.receiveAmount(balance);
            }

// OVERSÆT BRUGER INPUT DATA TIL OBJEKTER

        }else {

            while (count < this.maxPlayers) {
                String name = ui.getInput("Skriv spillernavn navn: ");
                Player p = this.registerPlayer(name);
                p.receiveAmount(30000);
                count++;
            }
        }

        displayPlayers();
        endGame();

    }

    private void endGame() {

        //Testcode
        //todo: add this line to the endGame method in class Game
        io.saveData("src/data.csv", this.getPlayers());
    }
}
