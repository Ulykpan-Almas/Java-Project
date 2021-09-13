package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDb extends JPanel {
    AdminGUI parent;

    public AddDb(AdminGUI parent) {
        this.parent = parent;
        setSize(1200,700);
        setLayout(null);

        JButton addAir= new JButton("ADD aircraft");
        addAir.setBounds(100,100,300,40);
        add(addAir);
        addAir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getAddDb().setVisible(false);
                parent.getAircraftAdd().setVisible(true);

            }
        });

        JButton addCity= new JButton("ADD city");
        addCity.setBounds(100,150,300,40);
        add(addCity);
        addCity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getAddDb().setVisible(false);
                parent.getCityAdd().setVisible(true);

            }
        });

        JButton addFlight= new JButton("ADD flight");
        addFlight.setBounds(100,200,300,40);
        add(addFlight);
        addFlight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getAddDb().setVisible(false);
                parent.getFlightAdd().setVisible(true);

            }
        });


        JButton back=new JButton("BACK");
        back.setBounds(100,250,300,40);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getAddDb().setVisible(false);
                parent.getMainPage().setVisible(true);

            }
        });

    }

}
