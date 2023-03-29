import model.*;
import util.*;

import util.FileIO;

import java.util.ArrayList;
//Todo: - Rename class to Game,
//      - Change fields and methodnames so that it reflects precisely the Game class in the class diagram
//      - Add the setup method:
//      a. loads or prompts for gamedata,
//      b. creates the Player objects
//      (reuse the code from the main method)

public class Game {
    private ArrayList<Player> players = new ArrayList<>();
    private int maxPlayers;
    private TextUI ui = new TextUI();
    private FileIO io = new FileIO();

    public Game(int maxPlayers){

        this.maxPlayers = maxPlayers;
    }

    public void registerPlayer(String name, int amount){
        Player c = new Player(name);
        players.add(c);
        c.getAccount().setBalance(amount);
    }
    public void setup() {

        int count = 0;

        FileIO fileIO = new FileIO();
        ArrayList<String> data = fileIO.readGameData("src/data.csv");

        if(data.size()>0) {

// OVERSÆT FIL INPUT DATA TIL OBJEKTER

            for (String s : data) {
                String[] line = s.split(",");
                String name = line[0];
                int balance = Integer.parseInt(line[1].trim());
                /*Player c = */registerPlayer(name,30000);
                //c.receiveAmount(balance);
            }

// OVERSÆT BRUGER INPUT DATA TIL OBJEKTER

        }else {

            while (count < maxPlayers) {
                String name = ui.getInput("Skriv kundens navn: ");
                /*Player c = */registerPlayer(name,30000);
                //c.receiveAmount(30000);
                count++;
            }
        }
    }
    private void endGame(){
        io.saveData("src/data.csv", getPlayers());

    }
    public void displayPlayers(){
        for (Player c: players) {
            System.out.println(c);
        }
    }
    public Player getPlayer(int i){
       return players.get(i);
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }
}
