package de.dhbw.java.probeklausur;

public class Message {
    private String message;
    private Account sender;


    public Message(String message, Account sender) {
        this.message = message;
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public Account getSender() {
        return sender;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }
}
