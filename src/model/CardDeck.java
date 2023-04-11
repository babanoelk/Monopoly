package model;

public class CardDeck {
    private int count;

    private String[] cardData = new String[100];


    public CardDeck(String[] carddata){

        carddata = carddata;

        cardData[0] = "Hej";
        cardData[1] = "Med";
        cardData[2] = "Dig!";

    }

    public String getNext(){
        String outPut = this.cardData[count];
        count++;
        if(count >= cardData.length){
            count = 0;
        }
        return outPut;
    }

}
