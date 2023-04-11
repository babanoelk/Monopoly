package model;

public class Field {

    String label;
    int ID;
    int cost;
    int income;
    String option;


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

    public String onLand(){

        return "";
    }

    protected String onAccept(){

        return "";
    }

    protected String onReject(){

        return "";
    }



}
