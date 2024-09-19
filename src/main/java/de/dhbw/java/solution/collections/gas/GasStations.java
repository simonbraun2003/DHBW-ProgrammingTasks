package de.dhbw.java.solution.collections.gas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@SuppressWarnings("serial")
public class GasStations extends JFrame implements ActionListener {
    private JTextField txtName = new JTextField();
    private JTextField txtDiesel = new JTextField();
    private JTextField txtSuperE5 = new JTextField();
    private JTextField txtSuperE10 = new JTextField();
    private final Map<String, GasPrices> stations = new HashMap<>();
    public GasStations() {
        super("Gas Stations");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// inputs
        JPanel panInput = new JPanel(new GridLayout(4,2,5,5));
        panInput.add( new JLabel("Station Name") );
        panInput.add( this.txtName );
        panInput.add( new JLabel("Diesel") );
        panInput.add( this.txtDiesel );
        panInput.add( new JLabel("Super E5") );
        panInput.add( this.txtSuperE5 );
        panInput.add( new JLabel("Super E10") );
        panInput.add( this.txtSuperE10 );
// save button
        JPanel panButtons = new JPanel();
        JButton btnSave = new JButton("Save");
        JButton btnShow = new JButton("Show all");
// example with single action listener and action commands
        btnSave.addActionListener(this);
        btnShow.addActionListener(this);
        btnSave.setActionCommand("save");
        btnShow.setActionCommand("show");
        panButtons.add(btnSave);
        panButtons.add(btnShow);
        this.add(panInput); // implicit: BorderLayout.CENTER
        this.add(panButtons, BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new GasStations();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "save":
                this.saveCurrentInput();
                break;
            case "show":
                this.showAllStations();
                break;
            default:
                break;
        }
    }
    private void saveCurrentInput() {
        String station = this.txtName.getText();
        if ( station.isEmpty() ) {
            JOptionPane.showMessageDialog(this,
                    "Please provide a station name");
            return;
        }
        GasPrices gp = new GasPrices();
        gp.setDiesel(this.getValue(this.txtDiesel));
        gp.setSuperE5(this.getValue(this.txtSuperE5));
        gp.setSuperE10(this.getValue(this.txtSuperE10));
        this.txtName.setText("");
        this.txtDiesel.setText("");
        this.txtSuperE5.setText("");
        this.txtSuperE10.setText("");
        this.stations.put(station, gp);
        JOptionPane.showMessageDialog(this, "Saved: " + station
                + " (" + gp + ")");
    }
    private double getValue(JTextField txt) {
        String txtVal = txt.getText();
        if ( !txtVal.isEmpty() ) {
            txtVal = txtVal.replace(',', '.'); // optional comma support
        }
        try {
            return Double.parseDouble(txtVal);
        } catch (Exception e) {
            return -1;
        }
    }
    private void showAllStations() {
        StringBuilder sb = new StringBuilder();
        for( Entry<String, GasPrices> e : this.stations.entrySet() ) {
            sb.append(e.getKey() + ": " + e.getValue() + "\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString().trim());
    }
}