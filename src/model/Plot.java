package model;

public class Plot extends Property{
    public Plot(int ID, String label, int cost, int income) {
        super(ID, label, cost, income);
    }

    public String onLand(Player p){
        return "";
    }
}
