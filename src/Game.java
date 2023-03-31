import model.Player;
import util.FileIO;
import util.TextUI;

import java.util.ArrayList;
import java.util.Collection;
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
    private Player currentPlayer ;

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
            output += p +"\n";
        }
        ui.displayMessage(output);
    }

    public Player getPlayer(int i) {

        return players.get(i);
    }

    public ArrayList<Player> getPlayers() {

        return players;
    }
    //todo: add endGame method

    public void setup() {

        int count = 0;
        ArrayList<String> data = io.readGameData("src/data.csv");

        if (data.size() > 0) {
            if(ui.getInput("Forstætte gemt spil? Y/N").equalsIgnoreCase("y")) {
// OVERSÆT FIL INPUT DATA TIL OBJEKTER

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
        }else{
            runPlayerSetupDialog();
        }
        displayPlayers();
        runGameLoop();
        endGame();
    }


    private void endGame() {

        //Testcode
        //todo: add this line to the endGame method in class Game
        io.saveData("src/data.csv", this.getPlayers());
    }
    public void runPlayerSetupDialog() {
        int count = 0;
        while (count < this.maxPlayers) {
            String name = "";
            //if (count < 2) {
            name = ui.getInput("Skriv spillernavn navn: or type q to quite");
            if (name.equals("q") && count < 2) {
                ui.displayMessage("You need atleast 2 players to play Matador");
                this.players = new ArrayList<>();
                setup();
            } else if (name.equals("q")) {
                break;
            }
            Player p = this.registerPlayer(name);
            p.receiveAmount(30000);
            count++;
            // }
               /* if (count >= 2) {
                    name = ui.getInput("You now have " + count  + " players. Enter an other name if you wish to ad more players. else type q to start ");
                    if (name.equals("q")) {
                        break;
                    }
                    Player p = this.registerPlayer(name);
                    p.receiveAmount(30000);
                    count++;
                }*/
        }
        Collections.shuffle(players);
    }

    private void runGameLoop(){
        String input = "Y";
        while(input.equalsIgnoreCase("y")){
            int count = 0;
            currentPlayer = players.get(0);
            count = currentPlayer.getId()+1;
            ui.displayMessage("its player " + currentPlayer.getName()+"'s turn");
            throwAndMove();
            input = ui.getInput("Do you want to contineue? Y/N");
            if(count > maxPlayers){
                count = 1;
            }
        }

    }
    private void throwAndMove(){

    }
    private void landAndAct(){

    }


}
