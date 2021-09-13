package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deleteflight extends JPanel {
    AdminGUI parent;
    JButton deleteButton;
    JButton back;

    public deleteflight(AdminGUI parent) {
        this.parent = parent;
        setSize(1200,700);
        setLayout(null);

        JLabel nameLabel = new JLabel("ID");
        nameLabel.setSize(100, 40);
        nameLabel.setLocation(150, 150);
        add(nameLabel);

        JTextField nameLong = new JTextField();
        nameLong.setBounds(200, 150, 200, 40);
        add(nameLong);

        deleteButton = new JButton("DELETE");
        deleteButton.setBounds(100, 200, 300, 40);
        add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    flights flights = new flights(Long.parseLong(nameLong.getText()), null, null, null, null, 0, 0);
                parent.DeleteFlight(flights);
                nameLong.setText("");
            }
        });
        back = new JButton("BACK");
        back.setBounds(100,250,300,40);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.deleteflight.setVisible(false);
                parent.updateDb.setVisible(true);
            }
        });
        JButton exit = new JButton("EXIT");
        exit.setBounds(100,300,300,40);
        add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}


