import model.Account;
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

    private TextUI ui;

    private FileIO io;

    public Game(int maxPlayers){

        this.maxPlayers = maxPlayers;
    }

    public void registerPlayer(String name, int amount){
        Player player = new Player(name);
        players.add(player);
        player.receiveAmount(amount);

    }

    public void setup(){
        ui = new TextUI();
        int count = 0;
        while (count < maxPlayers  ) {
            String name = ui.getInput("Skriv spillerens navn: ");
            registerPlayer(name,30000);
            count++;
        }
        endGame();
    }

    private void endGame(){

        io = new FileIO();

        io.saveData("src/data.csv", players);

        /*try {
        FileWriter filewriter = new FileWriter("src/data.csv");

            for (model.Player p : players) {
                filewriter.write(p.getName() + "," + p.getAccount().getBalance() + "\n");
            }
            filewriter.close();
        }
        catch (IOException e){
            System.out.println("not found");
        }*/


    }

    public void displayPlayers(){
        for (Player c: players) {
            System.out.println(c);
        }
    }
    public Player getPlayer(int i){

        return players.get(i);
    }
    public ArrayList<Player> getPlayers(){

        return players;
    }


}
