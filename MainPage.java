package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JPanel {
    AdminGUI parent;

    public MainPage(AdminGUI parent) {
        this.parent = parent;

        setSize(1200,700);
        setLayout(null);

        JButton addbtn=new JButton("ADD");
        addbtn.setBounds(100,100,300,40);
        add(addbtn);
        addbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.addDb.setVisible(true);
                parent.mainPage.setVisible(false);
            }
        });

        JButton updatebtn=new JButton("UPDATE");
        updatebtn.setBounds(100,150,300,40);
        add(updatebtn);
        updatebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.updateDb.setVisible(true);
                parent.mainPage.setVisible(false);
            }
        });

        JButton deletebtn=new JButton("Exit");
        deletebtn.setBounds(100,200,300,40);
        add(deletebtn);
        deletebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

}
