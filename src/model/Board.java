package model;

import javax.swing.undo.UndoableEdit;
import java.lang.reflect.Field;

public class Board {

    private Field[] fields = new Field[40];
    private CardDeck cardDeck;

    public Board(String[] fields,String[]cards){
        createFields(fields);
        this.cardDeck = new CardDeck(cards);

    }

    private void createFields(String[]data){
        int counter =0;
        for(String s : data){
            String[] line = s.split(",");
            Field f = new Field(line[0],line[1],line[2],line[3],line[4]);
            fields[counter] = f;
            counter++;
        }

    }

    public Field getFields(int id) {
        return fields[id];
    }
}
