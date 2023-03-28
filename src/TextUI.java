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
}
