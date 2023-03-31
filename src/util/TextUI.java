package util;

import java.util.Scanner;
import javax.swing.JOptionPane;

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
         JOptionPane.showMessageDialog(null, msg);
     }
}

