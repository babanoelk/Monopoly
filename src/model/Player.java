package model;


import util.ISaveable;

public class Player implements ISaveable {
    private Account account;
    private String name;
    private int id;
    private static int counter = 1;

    public Player(String name) {
        this.name = name;
        this.id = counter;
        this.account = new Account();
        counter++;
    }

    public static void resetCounter() {
        counter = 1;
    }

    public Account geAccount(){
        return account;
    }

    public int receiveAmount(int i) {
        this.account.updateBalance(i);
        return this.account.getBalance();
    }


    public String getName() {
        return this.name;
    }

    public String toString() {
        return getName() + ": " + this.account.getBalance();
    }

    public int getBalance() {

        return getAccount().getBalance();
    }


}
