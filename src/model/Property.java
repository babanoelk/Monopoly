package model;

public class Property extends Field {


    public Property(int ID, String label, int cost, int income) {
        super(ID, label, cost, income);
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public String onLand(Player p) {
        return "";

    }

    @Override
    public String onAccept(Player p) {
        return "";
    }

    @Override
    public String onReject(Player p) {
        return "";
    }

}