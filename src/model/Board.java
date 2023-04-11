package model;

import java.lang.reflect.Field;

public class Board {

    private Field[] fields = new Field[40];

    public Board(String[] data){
        createFields(data);

    }

    private void createFields(String[]data){
        int counter =0;
        for(String s : data){
            String[] line = s.split(",");
            Field f = new Field(line);
            fields[counter] = f;
            counter++;
        }

    }

    public Field getFields(int id) {
        return fields[id];
    }
}
