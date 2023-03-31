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
    private Player currentPlayer;

    public Game(int maxPlayers) {

        this.maxPlayers = maxPlayers;
    }

    public Player registerPlayer(String name) {
        Player p = new Player(name);
        players.add(p);
        return p;
    }

    public void displayPlayers() {
        String output = "";
        for (Player p : players) {
            output = p+"\n";
            ui.displayMessage(output);
        }
    }

    public Player getPlayer(int i) {

        return players.get(i);
    }

    public ArrayList<Player> getPlayers() {

        return players;
    }

    public void runGameLoop() {
        String input = "Y";
        int counter = 0;
        while(!ui.getInput("").equalsIgnoreCase(input)){
            currentPlayer = players.get(counter);
            ui.displayMessage("Det er " + currentPlayer + " tur");
            throwAndMove();
            ui.displayMessage("Vil du forsætte?");
            counter += 1;
        }
        counter = 0;
    }
    public void throwAndMove() {

    }
    public void landAndAct() {
        
    }


    //todo: add endGame method

    public void setup() {

        int count = 0;
        ArrayList<String> data = io.readGameData("src/data.csv");

        if(data.size()>0) {

// OVERSÆT FIL INPUT DATA TIL OBJEKTER

            ui.displayMessage("Gemt spil fundet");
            if(ui.getInput("Fortsæt gemt spil= Y/N").equalsIgnoreCase("Y")){
                ui.displayMessage("Henter gemt spil...");
                for (String s : data) {
                    String[] line = s.split(",");
                    String name = line[0];
                    int balance = Integer.parseInt(line[1].trim());
                    Player p = this.registerPlayer(name);
                    p.receiveAmount(balance);
                }
                ui.displayMessage("Gemt spil fundet med disse spillere:");
            } else {
                runPlayerSetupDialog();
            }



// OVERSÆT BRUGER INPUT DATA TIL OBJEKTER

        } else {

          runPlayerSetupDialog();

        }

        displayPlayers();
        endGame();

    }

    private void runPlayerSetupDialog() {
        int count = 0;
        while (count < this.maxPlayers) {
            String name = ui.getInput("Skriv spillernavn navn: (Tryk 'Q' for at afbryde) ");
            if(name.equalsIgnoreCase("Q") && players.size() > 1){
                break;
            }else if(name.equalsIgnoreCase("Q")) {
                ui.displayMessage("Der kræves mindst 2 spillere for, at starte spillet! Der var kun tilføjet: " + players.size());
                displayPlayers();
                continue;
            }
            Player p = this.registerPlayer(name);
            p.receiveAmount(30000);
            count++;
        }
        Collections.shuffle(players);
    }

    private void endGame() {

        //Testcode
        //todo: add this line to the endGame method in class Game
        io.saveData("src/data.csv", this.getPlayers());
    }
}
