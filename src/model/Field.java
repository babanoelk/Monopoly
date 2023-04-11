package model;

public class Field {

    protected String label;
    protected int ID;
    protected int cost;
    protected int income;
    protected String option;


    public Field(int ID, String label, int cost, int income){

        this.ID = ID;
        this.label = label;
        this.cost = cost;
        this.income = income;

    }
    @Override
    public String toString(){

        return ID + label;
    }

    public String onLand(Player p){

        return "";
    }

    public String processResponse(Player p){
        return "";
    }

    protected String onAccept(Player p){

        return "";
    }

    protected String onReject(Player p){

        return "";
    }



}
