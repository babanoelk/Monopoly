import model.Player;

import java.util.ArrayList;
//Todo: - Rename class to Game,
//      - Change fields and methodnames so that it reflects precisely the Game class in the class diagram
//      - Add the setup method:
//      a. loads or prompts for gamedata,
//      b. creates the Player objects
//      (reuse the code from the main method)

public class Bank {
    public int customerLimit ;
    private ArrayList<Player> players = new ArrayList<>();
    public Bank(int customerLimit){
        this.customerLimit = customerLimit;
    }


    //todo: this method is no longer needed. Remove
    public static int getTotalBanks(){
        return 1;
    }
    public Player registerCustomer(String name){
        Player c = new Player(name);
        players.add(c);
        return c;
    }

    public void displayCustomers(){
        for (Player c: players) {
            System.out.println(c);
        }
    }
    public Player getCustomer(int i){
       return players.get(i);
    }
    public ArrayList<Player> getCustomers(){
        return players;
    }
    //todo: add endGame method
}
