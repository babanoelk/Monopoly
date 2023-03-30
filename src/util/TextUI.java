package util;

import java.util.Scanner;

public class TextUI {
     Scanner scan;


     public TextUI (){

        scan = new Scanner(System.in);
     }
     public void displayMessage(String msg){
         System.out.println(msg);
     }
    public String getInput(String msg){
        displayMessage(msg);
         String input = scan.nextLine();
         return input;
    }
}
