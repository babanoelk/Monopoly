package model;

import model.Account;

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

    public int receiveAmount(int i){
        this.account.updateBalance(i);
        return this.account.getBalance();
    }

    public int getId() {
        return id;
    }

    public String getName(){
        return this.name;
    }
    public String toString(){
        return getName()+ ": "+ this.account.getBalance();
    }

    public int getBalance(){
        return account.getBalance();
    }

}
