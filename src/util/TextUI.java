package util;

import javax.swing.*;
import java.util.Scanner;

public class TextUI {
     Scanner scan;


     public TextUI (){

        scan = new Scanner(System.in);
     }
    public String getInput(String msg){
         System.out.println(msg);
         String input = scan.nextLine();
         return input;
     }

     public void showMessage(String msg){
         System.out.println("**********************");
         System.out.println(msg);
         System.out.println("**********************");
     }
}

