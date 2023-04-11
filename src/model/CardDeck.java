package model;

public class CardDeck {
    private String[] carddata = new String[100];
    int counter = 0;
    public CardDeck(String[] carddata) {
        this.carddata = carddata;
        this.carddata[0] = "Tillykke!";
        this.carddata[1] = "Betal 100 kr.!";
        this.carddata[2] = "Gå i fængsel";

    }
    public String getNext(){
        String output = carddata[counter];
        counter++;
        if(counter > carddata.length){
            counter = 0;
        }
        return output;
    }
}
