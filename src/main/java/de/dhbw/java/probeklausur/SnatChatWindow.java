package de.dhbw.java.probeklausur;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class SnatChatWindow extends JFrame implements SnatChatFrontend{

    private SnatChatRoom room;
    private Account account;
    private ChatMessagesComponent messages = new ChatMessagesComponent();
    private Map<State, JRadioButton> stateButtons = new HashMap<State, JRadioButton>();

    public SnatChatWindow(SnatChatRoom room, Account account) {
        super(account.getName() + " (" + room.getName() + ")");
        this.room = room;
        this.account = account;

        JLabel lblName = new JLabel(account.getName(), JLabel.CENTER);
        lblName.setForeground(account.getColor());

        this.add(lblName, BorderLayout.NORTH);
        this.add(this.messages, BorderLayout.NORTH);

        JPanel panBottom = new JPanel();
        JPanel panStateBtns = new JPanel(new FlowLayout());
        ButtonGroup bg = new ButtonGroup();
        for(State state : State.values()) {
            JRadioButton rdbtn = new JRadioButton(state.getLabel());
            this.stateButtons.put(state, rdbtn);
            panStateBtns.add(rdbtn);
            bg.add(rdbtn);
        }
        panBottom.add(panStateBtns);
        //this.add(panBottom, BorderLayout.SOUTH);

        JPanel panMsgSend = new JPanel(new BorderLayout(5,5));
        JTextField txtMsgSend = new JTextField();
        JButton btnSend = new JButton("Send");
        panMsgSend.add(txtMsgSend, BorderLayout.CENTER);
        panMsgSend.add(btnSend, BorderLayout.EAST);
        this.add(panMsgSend, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 400);
        this.setVisible(true);
    }

    @Override
    public void receiveMessage(Message msg) {

    }

    @Override
    public void receiveMessage(String text) {

    }

    @Override
    public Account getAccount() {
        return null;
    }
}
