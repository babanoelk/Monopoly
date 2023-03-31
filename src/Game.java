import model.*;
import util.*;
import java.util.ArrayList;
import java.util.Collections;


public class Game {
    private int maxPlayers;
    private ArrayList<Player> players = new ArrayList<>();
    private TextUI ui = new TextUI();
    private FileIO<Player> io = new FileIO();

    public Game(int maxPlayers){
        this.maxPlayers = maxPlayers;
    }

    /**
     * Register a new player with a name and amount
     * @param name name of the player
     */
    public Player registerPlayer(String name) {
        Player p = new Player(name);
        players.add(p);
        return p;
    }

    public void displayPlayers() {
        String message = "";
        for (Player p : players) {
            message+=p.toString();
        }
        ui.displayMessage(message);
    }

    public Player getPlayer(int i) {
        return players.get(i);
    }
 
    public ArrayList<Player> getPlayers(){
        return players;
    }  

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

    private void endGame(){
        //Testcode
        //todo: add this line to the endGame method in class Game
        io.saveData("src/data.csv", this.getPlayers());
    }
}
