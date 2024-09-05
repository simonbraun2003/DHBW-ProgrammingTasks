package de.dhbw.java.exercise.classes;

public class Account {
    private int kontoNr;
    private String name;
    private double balance;
    private double limit;

    //Konstruktoren
    public Account() {
        this.kontoNr = 001;
        this.balance = 0.0;
        this.limit = 100.0;
        this.name = "Max Mustermann";

    }
    public Account(int kontoNr, String name, double balance) {
        this.kontoNr = kontoNr;
        this.name = name;
        this.balance = balance;
    }
    public Account(int kontoNr, String name, double balance, double limit) {
        this.kontoNr = kontoNr;
        this.name = name;
        this.balance = balance;
        this.limit = limit;
    }

    //informationsausgabe zum Konto
    public String toString(){
        return "Name: " + this.name + ", Konto: " + this.kontoNr + ", Balance: " + this.balance + ", Limit: " + this.limit;
    }

    //Aus- und Einzahlungen
    public void processDeposit(double balance) {
        if(this.balance + balance < this.limit){
            this.balance += balance;
        }else {
            System.out.println("Limit nicht ausreichend!");
        }
    }

    public void processPayment(double balance) {
        if(this.balance - balance < 0){
            System.err.println("Deckung nicht ausreichend");
        }else {
            this.balance -= balance;
        }
    }

    //Abfrage des kontostands
    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Account account = new Account(4711, "Donald Duck", 500, 1000);
        System.out.println(account);
        account.processDeposit(200);
        System.out.println(account);
        account.processPayment(400);
        System.out.println(account);
        account.processPayment(2000);
        System.out.println(account);
    }
}
