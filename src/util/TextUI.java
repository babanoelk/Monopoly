package util;

import java.util.Scanner;

public class TextUI {
     private Scanner scan = new Scanner(System.in);

    public String getInput(String msg){
         displayMessage(msg);
         String input = scan.nextLine();
         return input;
    }

    public void displayMessage(String msg){
        System.out.println(msg);
    }


}
