package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CityAdd extends JPanel {
    public AdminGUI parent;

    public CityAdd(AdminGUI parent ) {
        this.parent = parent;
        setSize(1200,700);
        setLayout(null);

        JLabel nameLbl =new JLabel("City Name:");
        nameLbl.setBounds(100,100,100,40);
        add( nameLbl);

        JTextField nameField=new JTextField();
        nameField.setBounds(100,150,300,40);
        add( nameField);

        JLabel countryLbl =new JLabel("Country:");
        countryLbl.setBounds(100,200,100,40);
        add( countryLbl);

        JTextField countryField=new JTextField();
        countryField.setBounds(100,250,300,40);
        add( countryField);

        JLabel short_nameLbl =new JLabel("short_name:");
        short_nameLbl.setBounds(100,300,100,40);
        add( short_nameLbl);

        JTextField short_nameField=new JTextField();
        short_nameField.setBounds(100,350,300,40);
        add( short_nameField);


        JButton addBtn= new JButton("ADD");
        addBtn.setBounds(100,490,100,40);
        add(addBtn);
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String country= countryField.getText();
                String short_name= short_nameField.getText();
                cities c1= new cities(null,name,country,short_name);
                citiesDate cd= new citiesDate("ADD CITY",null,c1);
                parent.addcities(cd);

            }
        });

        JButton backBtn= new JButton("Back");
        backBtn.setBounds(210,490,100,40);
        add(backBtn);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getCityAdd().setVisible(false);
                parent.getAddDb().setVisible(true);
            }
        });






    }
}
