package model;

public class Property extends Field {
    private final int seriesID;

    public Property(int ID, String label, int cost, int income, int seriesID) {
        super(ID, label, cost, income);
        this.seriesID = seriesID;
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