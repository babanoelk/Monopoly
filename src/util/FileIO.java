package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Player;

public class FileIO {
    File file;
    Scanner scan;

    public ArrayList<String> readGameData(String path) {

        file = new File(path);
        ArrayList<String> data = new ArrayList<>();


        try {
            scan = new Scanner(file);

            scan.nextLine(); // ignore header in csv

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                data.add(line);
            }
        } catch (FileNotFoundException e) {
             System.out.println("The file was not found");

        }

        return data;
    }


    public void saveData(String path, ArrayList<Player> players){
        FileWriter writer = null;
        try {
            writer = new FileWriter(path);
            writer.write("name, balance \n");
            for (Player c: players) {
                writer.write(c.getName()+","+c.getBalance()+"\n");
            }
            writer.close();

        }catch(IOException e){


        }
    }
}
