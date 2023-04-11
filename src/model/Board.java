package model;

import javax.swing.undo.UndoableEdit;
//import java.lang.reflect.Field;

public class Board {

    private Field[] fields = new Field[40];
    private CardDeck cardDeck;

    public Board(String[] fields,String[]cards){
        createFields(fields);
        this.cardDeck = new CardDeck(cards);

    }
public String getNextCard(){

      return cardDeck.getNext();
}
    private void createFields(String[]data){
        int counter =0;
        for(String s : data){
            String[] line = s.split(",");
            int id = Integer.parseInt(line[0].trim());
            String type = line[1];
            String label = line[2];
            int cost = Integer.parseInt(line[3].trim());
            int income =Integer.parseInt(line[4].trim());
            int seriesID =Integer.parseInt(line[5].trim());


            Field f;
           // Field f = new Field(line[0],line[1],line[2],line[3],line[4]);

            switch(type){
                case "Plot": f = new Plot(id, label, cost, income, seriesID);
                break;
                case "Brewery": f = new Field(id, label, cost, income);
                break;
               case "ShippingLine": f = new Field(id, label, cost, income);
                    break;
                case "Tax": f = new Field(id, label, cost, income);
                    break;
                default: f = new Field(id, label, cost, income);


            }

            fields[counter] = f;
            counter++;
        }

    }

    public Field getFields(int id) {
        return fields[id];
    }
}
