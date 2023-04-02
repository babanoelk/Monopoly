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

    private void runGameLoop(){

        String input = "Y";
        int count = 0;



        while (input.equalsIgnoreCase("Y")) {
            currentPlayer = players.get(count);
            ui.displayMessage("Det er " + currentPlayer.getName() + "'s tur");
            throwAndMove();
            count++;
            input = ui.getInput("Vil du gerne forsætte? Y/N");
            if (count > players.size()-1) {
                count = 0;
            }
        }

    }

    private void throwAndMove() {

    }

    private void landAndAct(){

    }

    public Player registerPlayer(String name) {
        Player p = new Player(name);
        players.add(p);
        return p;
    }

    public void displayPlayers() {
        String msg = "";
        for (Player p : players) {
            msg += p + "\n";
        }
        ui.displayMessage(msg);
    }

    public Player getPlayer(int i) {

        return players.get(i);
    }

    public ArrayList<Player> getPlayers() {

        return players;
    }
    //todo: add endGame method

    public void setup() {


        ArrayList<String> data = io.readGameData("src/data.csv");


        if(data.size() > 0 && ui.getInput("Forsætte gemt spil? Y/N").equalsIgnoreCase("Y")) {

// OVERSÆT FIL INPUT DATA TIL OBJEKTER

            for (String s : data) {
                String[] line = s.split(",");
                String name = line[0];
                int balance = Integer.parseInt(line[1].trim());
                Player p = this.registerPlayer(name);
                p.receiveAmount(balance);
            }

// OVERSÆT BRUGER INPUT DATA TIL OBJEKTER

        }else {

            /*while (count < this.maxPlayers) {
                String name = ui.getInput("Skriv spillernavn navn eller skriv \"Q\" for at fortsætte: ");
                if (name.equalsIgnoreCase("q")) {

                    if(players.size() >= 2) {
                        break;
                    }
                    else{
                        System.out.println("Der skal registreres mindst 2 spillere før I kan spille");
                        players.clear();

                        setup();
                        return;
                    }


                }
                Player p = this.registerPlayer(name);
                p.receiveAmount(30000);
                count++;
            }

             */
            runPlayerSetupDialog();
            Collections.shuffle(players);
        }
        displayPlayers();
        runGameLoop();
        endGame();

    }

    private void runPlayerSetupDialog() {

        int count = 0;

        while (count < this.maxPlayers) {
            String name = ui.getInput("Skriv spillernavn navn eller skriv \"Q\" for at fortsætte: ");
            if (name.equalsIgnoreCase("q")) {

                if(players.size() >= 2) {
                    break;
                }
                else{
                    System.out.println("Der skal registreres mindst 2 spillere før I kan spille");
                    players.clear();

                    setup();
                    return;
                }


            }
            Player p = this.registerPlayer(name);
            p.receiveAmount(30000);
            count++;
        }


    }
    private void endGame() {

        //Testcode
        //todo: add this line to the endGame method in class Game
        io.saveData("src/data.csv", this.getPlayers());
    }
}
