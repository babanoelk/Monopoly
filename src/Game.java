import model.Player;
import util.FileIO;
import util.TextUI;

import java.util.ArrayList;
import java.util.Collections;

public class Game {
    private int maxPlayers;
    private ArrayList<Player> players = new ArrayList<>();
    private TextUI ui = new TextUI();
   // private UI ui = new TextUI();
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
        String output = "";

        for (Player p : players) {
            //System.out.println(p);
            output += p+"\n";
        }

        ui.showMessage(output);
    }

    public Player getPlayer(int i) {

        return players.get(i);
    }

    public ArrayList<Player> getPlayers() {

        return players;
    }


    public void setup() {

        ArrayList<String> data = io.readGameData("src/data.csv");

        if(data.size()>0) {

// OVERSÆT FIL INPUT DATA TIL OBJEKTER
            if (ui.getInput("Fortsætte gemt spil? Y/N").equalsIgnoreCase("Y"))   {

                for (String s : data) {
                    String[] line = s.split(",");
                    String name = line[0];
                    int balance = Integer.parseInt(line[1].trim());
                    Player p = this.registerPlayer(name);
                    p.receiveAmount(balance);
                }
            }else{
                    runPlayerSetupDialog();
        }

// OVERSÆT BRUGER INPUT DATA TIL OBJEKTER

        }else {
                     runPlayerSetupDialog();
        }

        displayPlayers();
        endGame();

    }

    private void endGame() {

        io.saveData("src/data.csv", this.getPlayers());
    }

    private void runPlayerSetupDialog() {
        int count = 0;
        while (count < this.maxPlayers) {
            String name = ui.getInput("Skriv spillernavn eller q for at slutte tilføjelse af spillere.");
            //// Check if q, to quit initialisation
            if (name.equalsIgnoreCase("q")) {
                if (count > 1) {
                    break;
                }else{
                    ui.showMessage("It take two to monopolize.\n Current player is:");
                    displayPlayers();


                }
            } else {
                Player p = this.registerPlayer(name);
                p.receiveAmount(30000);
                count++;
            }
        }
        Collections.shuffle(players);
    }
}
