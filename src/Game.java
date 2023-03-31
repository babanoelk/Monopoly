import model.Account;
import model.Player;
import util.FileIO;
import util.TextUI;

import java.util.ArrayList;

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

        io = new FileIO();
        ArrayList<String> data = io.readGameData("src/data.csv");

        if(data.size()>0) {

            for (String s : data) {
                String[] line = s.split(",");
                String name = line[0];
                int balance = Integer.parseInt(line[1].trim());
                this.registerPlayer(name, balance);
            }
        }else {

            while (count < maxPlayers) {
                String name = ui.getInput("Skriv spillerens navn: ");
                registerPlayer(name, 30000);
                count++;

            }
        }
        endGame();
    }

    private void endGame(){

        io = new FileIO();

        io.saveData("src/data.csv", players);

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
