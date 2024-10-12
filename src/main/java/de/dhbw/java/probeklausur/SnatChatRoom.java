package de.dhbw.java.probeklausur;

import java.util.LinkedList;
import java.util.List;

public class SnatChatRoom {

    private List<SnatChatFrontend> frontends = new LinkedList<SnatChatFrontend>();
    private String name;

    public SnatChatRoom(String name){
        this.name=name;
    }

    public void register(SnatChatFrontend fronted) {
        this.frontends.add(fronted);
    }

    public void unregister(SnatChatFrontend fronted) {
        this.frontends.remove(fronted);
    }

    public void sendMessage(String text){
        for(SnatChatFrontend f: frontends){
                f.receiveMessage(text);
        }
    }

    public void SendMessage(Message msg){
        for (SnatChatFrontend f : frontends) {f.receiveMessage(msg);}
    }

    public List<SnatChatFrontend> getFrontends() {
        return frontends;
    }

    public void setFrontends(List<SnatChatFrontend> frontends) {
        this.frontends = frontends;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
