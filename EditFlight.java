package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditFlight extends JPanel {
    AdminGUI parent;
    JTextField tfaircraft_id;
    JTextField tfdeparture_city_id;
    JTextField tfarrival_city_id;
    JTextField tfdeparture_time;
    JTextField tfbusiness_place_price;
    JTextField tfeconom_place_price;
    JTextField tfid;



    public EditFlight(AdminGUI parent) {
        this.parent = parent;
        setSize(1200,700);
        setLayout(null);

        tfid=new JTextField();
        tfid.setBounds(100,50,200,50);


        tfaircraft_id= new JTextField();
        tfaircraft_id.setBounds(100,100,200,50);
        add(tfaircraft_id);

        tfdeparture_city_id = new JTextField();
        tfdeparture_city_id.setBounds(100,200,200,50);
        add(tfdeparture_city_id);

        tfarrival_city_id = new JTextField();
        tfarrival_city_id.setBounds(100,300,200,50);
        add(tfarrival_city_id);

        tfdeparture_time = new JTextField();
        tfdeparture_time.setBounds(100,400,200,50);
        add(tfdeparture_time);

        tfbusiness_place_price = new JTextField();
        tfbusiness_place_price.setBounds(100,500,200,50);
        add(tfbusiness_place_price);

        tfeconom_place_price = new JTextField();
        tfeconom_place_price.setBounds(100,600,200,50);
        add(tfeconom_place_price);

        JButton btn= new JButton("EDIT");
        btn.setBounds(600,500,100,50);
        add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Long id =Long.parseLong(tfid.getText());
                tfid.setText("");
                Long aircraft_id= Long.parseLong(tfaircraft_id.getText());
                tfaircraft_id.setText("");
                Long departure_city_id= Long.parseLong(tfdeparture_city_id.getText());
                tfdeparture_city_id.setText("");
                Long arrival_city_id= Long.parseLong(tfarrival_city_id.getText());
                tfarrival_city_id.setText("");
                String departure_time= tfdeparture_time.getText();
                tfdeparture_time.setText("");
                int business_place_price= Integer.parseInt(tfbusiness_place_price.getText());
                tfbusiness_place_price.setText("");
                int econom_place_price= Integer.parseInt(tfeconom_place_price.getText());
                tfeconom_place_price.setText("");
                flights a1= new flights(id,aircraft_id,departure_city_id,arrival_city_id,departure_time,business_place_price,econom_place_price);
                parent.updateflight(a1);


            }
        });

        JButton btn2 = new JButton("BACK");
        btn2.setBounds(400,500,100,50);
        add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getEditFlight().setVisible(false);
                parent.getUpdateDb().setVisible(true);
            }
        });


    }
}

