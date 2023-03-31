import model.Player;
import util.FileIO;
import util.TextUI;

import java.util.ArrayList;
import java.util.Collections;
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
        StringBuilder message = new StringBuilder();
        for (Player p : players) {
            message.append(p.toString());  // <-- er det samme som: "message += p.toString()+"\n";"
        }
        ui.displayMessage(message.toString());
    }

    public Player getPlayer(int i) {

        return players.get(i);
    }

    public ArrayList<Player> getPlayers() {

        return players;
    }
    //todo: add endGame method

    public void setup() {
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
        } else {
            runPlayerSetupDialog();
        }

        Collections.shuffle(players);
        displayPlayers();
        endGame();

    }

    private void runPlayerSetupDialog(){

        int count = 0;

        while (count < this.maxPlayers) {
            String name = ui.getInput("Skriv spillernavn navn eller tast Q for at afslutte spillet ");
            if(name.equalsIgnoreCase("Q")){
                if(players.size() < 2){
                    ui.displayMessage("You need more than 2 players to play the game");
                    continue;
                }
                ui.displayMessage("Registration of players done");
                break;
            }
            Player p = this.registerPlayer(name);
            p.receiveAmount(30000);
            count++;
        }
    }
    private void endGame() {

        //Testcode
        //todo: add this line to the endGame method in class Game
        io.saveData("src/data.csv", this.getPlayers());
    }
}
