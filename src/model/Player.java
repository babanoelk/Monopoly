package model;

public class Player {
    private Account account;
    private String name;
    private int id;
    private static int counter = 1;

    public Player(String name){
        this.name = name;
        this.id  = counter;
        this.account = new Account();
        counter++;
    }

    public Account getAccount(){
        return this.account;
    }

    public void receiveAmount(int i){
        this.account.updateBalance(i);
    }


    public int getId() {
        return id;
    }
    public int getBalance(){
        return this.account.getBalance();
    }

    public String getName(){
        return this.name;
    }
    public String toString(){
        return getName()+ ": "+ this.account.getBalance();
    }


}
