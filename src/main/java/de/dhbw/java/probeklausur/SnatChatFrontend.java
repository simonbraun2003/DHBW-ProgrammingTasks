package de.dhbw.java.probeklausur;


public interface SnatChatFrontend {

    void receiveMessage(Message msg);
    void receiveMessage(String text);
    Account getAccount();
}
