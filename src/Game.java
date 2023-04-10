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
    private int minPlayers;
    private ArrayList<Player> players = new ArrayList<>();
    private TextUI ui = new TextUI();
    private FileIO io = new FileIO();
    private Player currentPlayer;


    public Game(int maxPlayers, int minPlayers) {
        this.maxPlayers = maxPlayers;
    }


//    OVERSÆTTER INPUT DATA TIL OBJEKTER
    private Player registerPlayer(String name) {
        Player p = new Player(name);
        players.add(p);
        return p;
    }

    private void displayPlayers() {
        String s = "";
        for (Player p : players) {
            s += p + "\n";
        }
        ui.displayMessage(s);
    }

    private Player getPlayer(int i) {
        return players.get(i);
    }

    private ArrayList<Player> getPlayers() {
        return players;
    }

    public void setup() {

        ArrayList<String> data = io.readGameData("src/data.csv");

        if (data.size() > 0) {
// THERE IS DATA
            if (ui.getInput("Fortsætte gemt spil? Y/N").equalsIgnoreCase("Y")) {

        // USE SAVED DATA TO CREATE PLAYER OBJECTS

                for (String s : data) {
                    String[] line = s.split(",");
                    String name = line[0];
                    int balance = Integer.parseInt(line[1].trim());
                    Player p = this.registerPlayer(name);
                    p.receiveAmount(balance);
                }
                displayPlayers();
                runGameLoop();


            } else {
                runPlayerSetupDialog();
            }


// NO SAVED GAME DATA - RUN DIALOG AND CREATE PLAYER OBJECTS

        } else {
            runPlayerSetupDialog();
        }


        endGame();

    }

    private void runPlayerSetupDialog() {
        int count = 0;
        while (count < this.maxPlayers) {
            String name = ui.getInput("Skriv spillernavn navn eller Q for at afslutte dialog: ");
            //
            if (name.equalsIgnoreCase("q")) {
                if (players.size() > minPlayers) {
                    break;
                } else {
                    ui.displayMessage("It takes two to monopolize");
                    players = new ArrayList<>();
                    this.runPlayerSetupDialog();
                }
            }

            Player p = this.registerPlayer(name);
            p.receiveAmount(30000);
            count++;
        }
    }
    public void runGameLoop(){

        String input = "Y";
        int count = 0;

        while(input.equalsIgnoreCase("Y")) {

            currentPlayer = players.get(count);
            count++;
            ui.displayMessage("Det er "+currentPlayer.getName()+"'s tur");
            throwAndMove();
            input = ui.getInput("Fortsæt ? Y/N");
            if(count == players.size()){
                count = 0;
            }
        }
        endGame();

    }

    private void throwAndMove() {
    }

    private void endGame() {
        io.saveData("src/data.csv", this.getPlayers());
    }
}
