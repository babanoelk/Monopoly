import java.util.ArrayList;
//Todo: - Rename class to Game,
//      - Change fields and methodnames so that it reflects precisely the Game class in the class diagram
//      - Add the setup method:
//      a. loads or prompts for gamedata,
//      b. creates the Player objects
//      (reuse the code from the main method)

public class Bank {
    public int customerLimit ;
    private ArrayList<Customer> customers = new ArrayList<>();
    public Bank(int customerLimit){
        this.customerLimit = customerLimit;
    }


    //todo: this method is no longer needed. Remove
    public static int getTotalBanks(){
        return 1;
    }
    public Customer registerCustomer(String name){
        Customer c = new Customer(name);
        customers.add(c);
        return c;
    }

    public void displayCustomers(){
        for (Customer c:customers  ) {
            System.out.println(c);
        }
    }
    public Customer getCustomer(int i){
       return customers.get(i);
    }
    public ArrayList<Customer> getCustomers(){
        return customers;
    }
    //todo: add endGame method
}
