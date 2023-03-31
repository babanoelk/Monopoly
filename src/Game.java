import model.Player;
import util.FileIO;
import util.TextUI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collection;
import java.util.Collections;

public class Game {
    private int maxPlayers;
    private ArrayList<Player> players = new ArrayList<>();

    private TextUI ui = new TextUI();

    private FileIO io;

    public Game(int maxPlayers){

        this.maxPlayers = maxPlayers;
    }

    public void registerPlayer(String name, int amount){
        Player player = new Player(name);
        players.add(player);
        player.receiveAmount(amount);

    }

    public void runPlayerSetupDialog(){
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
                String name = ui.getInput("Skriv spillerens navn:" + "\n Tryk på Q for at afslutte" );

                if (name.equalsIgnoreCase("q")) {
                    if (players.size() < 2) {
                        System.out.println("Minimum antal spillere ikke oprettet");
                        runPlayerSetupDialog();
                        return;
                    } else {
                        break;
                    }
                } else {
                    registerPlayer(name, 30000);
                    count++;
                }
                /*if(name.equalsIgnoreCase("q") && players.size()>= 2 ){
                    break;
                } else if (name.equalsIgnoreCase("q") && players.size() <= 2) {
                        System.out.print("Minimum antal spillere ikke oprettet");
                        setup();
                }
                else{
                    registerPlayer(name, 30000);
                    count++;
                }*/
            }
            Collections.shuffle(players);
            displayPlayers();
        }
        endGame();
    }

    private void endGame(){

        io = new FileIO();

        io.saveData("src/data.csv", players);

    }

    public void displayPlayers(){
        for (Player c: players) {
            ui.displayMessage(c.toString());
        }

    }
    public Player getPlayer(int i){

        return players.get(i);
    }
    public ArrayList<Player> getPlayers(){

        return players;
    }


}
