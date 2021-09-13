package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deleteair extends JPanel {
    AdminGUI parent;
    JButton delete;

    public deleteair(AdminGUI parent) {
        this.parent = parent;
        setSize(1200, 700);
        setLayout(null);

        JLabel nameLabel = new JLabel("ID");
        nameLabel.setBounds(150, 150, 100, 40);
        add(nameLabel);

        JTextField id = new JTextField();
        id.setBounds(200, 150, 200, 40);
        add(id);

        delete = new JButton("DELETE");
        delete.setBounds(100, 200, 300, 40);
        add(delete);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    aircrafts aircraft = new aircrafts(Long.parseLong(id.getText()), null, null, 0, 0);
                    parent.DeleteAircraft(aircraft);
                    id.setText("");
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        });

        JButton back = new JButton("BACK");
        back.setBounds(100, 250, 300, 40);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getUpdateDb().setVisible(true);
                parent.getDeleteair().setVisible(false);
            }
        });

        JButton exit = new JButton("EXIT");
        exit.setBounds(100, 300, 300, 40);
        add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}


