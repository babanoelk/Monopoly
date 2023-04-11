package model;

public class Plot extends Property{
    public Plot(int ID, String label, int cost, int income, int seriesID) {
        super(ID, label, cost, income, seriesID);
    }

    public String onLand(Player p){
        return "";
    }
}
