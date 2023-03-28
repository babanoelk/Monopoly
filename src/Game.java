import model.*;
import util.*;
import java.util.ArrayList;


public class Game {
    public int maxPlayers;
    private ArrayList<Player> players = new ArrayList<>();
    FileIO fileIO = new FileIO();

    public Game(int maxPlayers){
        this.maxPlayers = maxPlayers;
    }

    public void registerPlayer(String name, int amount) {
        Player player = new Player(name);
        player.receiveAmount(amount);
        players.add(player);
    }

    public void displayPlayers(){
        for (Player c: players) {
            System.out.println(c);
        }
    }

    public void setup() {
        TextUI ui = new TextUI();
        ArrayList<String> data = fileIO.readGameData("src/data.csv");

        if(data.size()>0) {
        // OVERSÆT FIL INPUT DATA TIL OBJEKTER
            for (String s : data) {
                String[] line = s.split(",");
                String name = line[0];
                int startBalance = Integer.parseInt(line[1].trim());
                registerPlayer(name, startBalance);
            }
        // OVERSÆT BRUGER INPUT DATA TIL OBJEKTER
        }else {
            int count = 0;
            while (count < maxPlayers) {
                String name = ui.getInput("Skriv kundens navn: ");
                registerPlayer(name,30000);
                count++;
            }
        }
    }

    public Player getPlayer(int i) {
       return players.get(i);
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public void endGame(){
        fileIO.saveData("src/data.csv", players);
    }
}
