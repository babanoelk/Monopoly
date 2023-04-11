package model;

public class CardDeck {

    private String[] carddata = new String[100];


    public CardDeck(String[] carddata){

        carddata[0] = "Hej";
        carddata[1] = "Med";
        carddata[2] = "Dig!";

    }

    public String getNext(){
        int count = 0;
        String outPut = this.carddata[count];
        count++;
        return outPut;
    }

}
