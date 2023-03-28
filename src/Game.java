import model.*;
import util.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private int maxPlayers;
    private TextUI ui;
    private FileIO io;

    public Game(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void registerPLayer(String name,int amount){

    }
    public void setup(){

    }
    private void endGame(){

    }
    /*public Player displayPlayers(){

        return Player;
    }*/
    public ArrayList<Player> getPlayers(){
        return players;
    }

}
