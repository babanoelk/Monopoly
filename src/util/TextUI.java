package util;

import java.util.Scanner;

public class TextUI {
     private Scanner scan = new Scanner(System.in);

    public String getInput(String msg){
         System.out.println(msg);
         String input = scan.nextLine();
         return input;
    }
}
