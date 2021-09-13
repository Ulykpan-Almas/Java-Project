package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FlightAdd extends JPanel {
    public AdminGUI parent;
    JComboBox aircraftid;
    JComboBox deperture;
    JComboBox arrive;

    public FlightAdd(AdminGUI parent ) {
        this.parent = parent;
        setSize(1200,700);
        setLayout(null);

        String [] list=new String[parent.sendlistair("aircrafts").size()];
        for(int i=0; i<parent.sendlistair("aircrafts").size();i++){
            list[i]=String.valueOf(parent.sendlistair("aircrafts").get(i).id);
        }

        String [] list1=new String[parent.sendlistcity("cities").size()];
        for(int i=0; i<parent.sendlistcity("cities").size();i++){
            list1[i]=String.valueOf(parent.sendlistcity("cities").get(i).id);
        }

        JTextField id=new JTextField("id");
        id.setBounds(200,70,100,40);
        add(id);



        JLabel 	aircraft_idLbl =new JLabel("aircraft id");
        aircraft_idLbl.setBounds(100,100,100,40);
        add( aircraft_idLbl);


        aircraftid = new JComboBox(list);
        aircraftid.setBounds(100,150,300,40);
        add(aircraftid);

        JLabel departure_cityLbl =new JLabel("departure_city:");
        departure_cityLbl.setBounds(100,200,100,40);
        add( departure_cityLbl);

        deperture=new JComboBox(list1);
        deperture.setBounds(100,250,300,40);
        add(deperture);


        JLabel 	arrival_cityLbl =new JLabel("arrival_city:");
        arrival_cityLbl.setBounds(100,300,100,40);
        add( 	arrival_cityLbl);

        arrive=new JComboBox(list1);
        arrive.setBounds(100,350,300,40);
        add(arrive);

        JTextField 	arrival_cityField=new JTextField();
        arrival_cityField.setBounds(100,350,300,40);
        add( 	arrival_cityField);

        JLabel 	departure_timeLbl =new JLabel("departure_time:");
        departure_timeLbl.setBounds(100,400,100,40);
        add( 	departure_timeLbl);

        JTextField 	departure_timeField=new JTextField();
        departure_timeField.setBounds(100,450,300,40);
        add( 	departure_timeField);

        JLabel 		econom_place_priceLbl =new JLabel("econom_place_price:");
        econom_place_priceLbl.setBounds(100,500,100,40);
        add( 		econom_place_priceLbl);

        JTextField 	econom_place_priceField=new JTextField();
        econom_place_priceField.setBounds(100,550,300,40);
        add( 		econom_place_priceField);

        JLabel 		business_place_priceLbl =new JLabel("business_place_price:");
        business_place_priceLbl.setBounds(100,600,100,40);
        add( 		business_place_priceLbl);

        JTextField business_place_priceField=new JTextField();
        business_place_priceField.setBounds(100,650,300,40);
        add( 		business_place_priceField);


        JButton addBtn= new JButton("ADD");
        addBtn.setBounds(700,200,100,40);
        add(addBtn);
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flights flights= new flights(Long.parseLong(id.getText()),
                        (parent.sendlistair("aircrafts").get((aircraftid.getSelectedIndex())).id),
                        (parent.sendlistcity("cities").get((deperture.getSelectedIndex())).id),
                        (parent.sendlistcity("cities").get((arrive.getSelectedIndex())).id),
                        departure_timeField.getText(),
                        Integer.parseInt(econom_place_priceField.getText()),
                        Integer.parseInt(business_place_priceField.getText()));
                try {
                   parent.SendFlight(flights);
                }catch (IOException E){
                    E.printStackTrace();
                }
                id.setText("");
                aircraftid.setSelectedItem(null);
                deperture.setSelectedItem(null);
                arrive.setSelectedItem(null);
                departure_timeField.setText("");
                econom_place_priceField.setText("");
                business_place_priceField.setText("");
            }
        });

        JButton backBtn= new JButton("Back");
        backBtn.setBounds(500,200,100,40);
        add(backBtn);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getFlightAdd().setVisible(false);
                parent.getAddDb().setVisible(true);
            }
        });






    }
}
