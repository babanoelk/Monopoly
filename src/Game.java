import java.util.ArrayList;
//Todo: - Rename class to Game,
//      - Change fields and methodnames so that it reflects precisely the Game class in the class diagram
//      - Add the setup method:
//      a. loads or prompts for gamedata,
//      b. creates the Player objects
//      (reuse the code from the main method)

public class Game {
    private int maxPlayers;
    private TextUI ui;
    private FileIO io;
    private ArrayList<Player> Players = new ArrayList<>();
    public Game(int maxPlayers){
        this.maxPlayers = maxPlayers;
    }


    //todo: this method is no longer needed. Remove

    public Player registerPlayer(String name, int amount){
        Player c = new Player(name);
        Players.add(c);
        return c;
    }

    public void setup() {

    }

    private void endGame() {

    }

    public void displayPlayers(){
        for (Player c: Players) {
            System.out.println(c);
        }
    }
    public Player getPlayer(int i){
       return Players.get(i);
    }
    public ArrayList<Player> getPlayers(){
        return Players;
    }
    //todo: add endGame method
}
