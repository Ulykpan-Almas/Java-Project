package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UpdateDb extends JPanel {
    AdminGUI parent;
    JTable table;
    JScrollPane scrollPane;
    ObjectInputStream ois;
    String header[] = {"id","Name","Model","Business","Econom"};
    String header1[] = {"id","Name","Country","Short_name"};
    String header2[] = {"id","aircraft_id","departure_city_id","arrival_city_id","departure_time","econom_place","business_place"};


    public UpdateDb(AdminGUI parent) {
        this.parent = parent;
        setSize(1200, 700);
        setLayout(null);




        JComboBox idbox= new JComboBox();

        JButton btn = new JButton("EDIT aircraft");
        btn.setBounds(140, 520, 100, 40);
        add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long aircraftid=(Long) table.getValueAt(table.getSelectedRow(),0);
                System.out.println(aircraftid);
                String aircraftname=(String) table.getValueAt(table.getSelectedRow(),1);
                System.out.println(aircraftname);
                String aircraftmodel=(String) table.getValueAt(table.getSelectedRow(),2);
                System.out.println(aircraftmodel);
                int aircraftbus = (int) table.getValueAt(table.getSelectedRow(),3);
                System.out.println(aircraftbus);
                int aircrafteco = (int) table.getValueAt(table.getSelectedRow(),4);
                System.out.println(aircrafteco);

                parent.getEditAir().tfid.setText(String.valueOf(aircraftid));
                parent.getEditAir().tfname.setText(aircraftname);
                parent.getEditAir().tfmodel.setText(aircraftmodel);
                parent.getEditAir().tfbus.setText(String.valueOf(aircraftbus));
                parent.getEditAir().tfeco.setText(String.valueOf(aircrafteco));


                parent.getUpdateDb().setVisible(false);
                parent.getEditAir().setVisible(true);

            }
        });


        JButton btn1 = new JButton("EDIT city");
        btn1.setBounds(140, 520, 100, 40);
        add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Long cityid=(Long) table.getValueAt(table.getSelectedRow(),0);
                System.out.println(cityid);
                String cityname=(String) table.getValueAt(table.getSelectedRow(),1);
                System.out.println(cityname);
                String citycountry=(String) table.getValueAt(table.getSelectedRow(),2);
                System.out.println(citycountry);
                String cityshort=(String) table.getValueAt(table.getSelectedRow(),3);
                System.out.println(cityshort);

                parent.getEditCity().tfid.setText(String.valueOf(cityid));
                parent.getEditCity().tfname.setText(cityname);
                parent.getEditCity().tfcountry.setText(citycountry);
                parent.getEditCity().tfshort_name.setText(String.valueOf(cityshort));


                parent.getUpdateDb().setVisible(false);
                parent.getEditCity().setVisible(true);

            }
        });

        JButton btn2 = new JButton("EDIT flight");
        btn2.setBounds(140, 520, 100, 40);
        add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Long flightid=(Long) table.getValueAt(table.getSelectedRow(),0);
                System.out.println(flightid);
                Long flightaircraftid = (Long) table.getValueAt(table.getSelectedRow(),1);
                System.out.println(flightaircraftid);
                Long flightdeparture_city_id = (Long) table.getValueAt(table.getSelectedRow(),2);
                System.out.println(flightdeparture_city_id);
                Long flightarrival_city_id = (Long) table.getValueAt(table.getSelectedRow(),3);
                System.out.println(flightarrival_city_id);
                String flightdeparture_time=(String) table.getValueAt(table.getSelectedRow(),4);
                System.out.println(flightdeparture_time);
                int flighteconom_place_price = (int) table.getValueAt(table.getSelectedRow(),5);
                System.out.println(flighteconom_place_price);
                int flightbusiness_place_price = (int) table.getValueAt(table.getSelectedRow(),6);
                System.out.println(flightbusiness_place_price);


                parent.getEditFlight().tfid.setText(String.valueOf(flightid));
                parent.getEditFlight().tfaircraft_id.setText(String.valueOf(flightaircraftid));
                parent.getEditFlight().tfdeparture_city_id.setText(String.valueOf(flightdeparture_city_id));
                parent.getEditFlight().tfarrival_city_id.setText(String.valueOf(flightarrival_city_id));
                parent.getEditFlight().tfdeparture_time.setText(flightdeparture_time);
                parent.getEditFlight().tfeconom_place_price.setText(String.valueOf(flighteconom_place_price));
                parent.getEditFlight().tfbusiness_place_price.setText(String.valueOf(flightbusiness_place_price));

                parent.getUpdateDb().setVisible(false);
                parent.getEditFlight().setVisible(true);
            }
        });



        JButton btnd = new JButton("Delete air");
        btnd.setBounds(750, 500, 100, 40);
        add(btnd);
        btnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getUpdateDb().setVisible(false);
                parent.getDeleteair().setVisible(true);
            }
        });

        JButton btnd1 = new JButton("Delete city");
        btnd1.setBounds(750, 550, 100, 40);
        add(btnd1);
        btnd1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getUpdateDb().setVisible(false);
                parent.getDeletecity().setVisible(true);
            }
        });

        JButton btnd2 = new JButton("Delete flight");
        btnd2.setBounds(750, 600, 100, 40);
        add(btnd2);
        btnd2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getUpdateDb().setVisible(false);
                parent.getDeleteflight().setVisible(true);
            }
        });






        btn.setVisible(false);
        btn1.setVisible(false);
        btn2.setVisible(false);

        JButton addAir = new JButton("List aircraft");
        addAir.setBounds(100, 50, 100, 40);
        add(addAir);
        addAir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn.setVisible(true);
                btn1.setVisible(false);
                btn2.setVisible(false);
                parent.getaircraft();

            }
        });

        JButton addCity = new JButton("List city");
        addCity.setBounds(210, 50, 100, 40);
        add(addCity);
        addCity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn.setVisible(false);
                btn1.setVisible(true);
                btn2.setVisible(false);
                parent.getcities();
            }
        });

        JButton addFlight = new JButton("List flight");
        addFlight.setBounds(320, 50, 100, 40);
        add(addFlight);
        addFlight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn.setVisible(false);
                btn1.setVisible(false);
                btn2.setVisible(true);
                parent.getflight();


            }
        });


        JButton back = new JButton("BACK");
        back.setBounds(1000, 520, 80, 40);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getUpdateDb().setVisible(false);
                parent.getMainPage().setVisible(true);

            }
        });


        table = new JTable();
        table.setFont(new Font("Calibri", Font.PLAIN, 12));
        table.setRowHeight(30);

        //Создаем панель для прокрутки
        scrollPane = new JScrollPane(table);
        scrollPane.setSize(1140, 400);
        scrollPane.setLocation(20, 100);
        add(scrollPane);

    }

    public void generateTableair(ArrayList<aircrafts> aircrafts) {

        //Создаем двумерный массив из нашего массива объектов, чтобы JTable смог его обработать
        //players.length - количество строк, 3 - это количество колонок.
        Object data[][] = new Object[aircrafts.size()][5];

        for (int i = 0; i < aircrafts.size(); i++) {
            data[i][0] = aircrafts.get(i).getId();
            data[i][1] = aircrafts.get(i).getName();
            data[i][2] = aircrafts.get(i).getModel();
            data[i][3] = aircrafts.get(i).getBusiness_class_capacity();
            data[i][4] = aircrafts.get(i).getEconom_class_capacity();
        }

        DefaultTableModel model = new DefaultTableModel(data,header);
        table.setModel(model);

    }

    public void generateTablecity(ArrayList<cities> cities) {

        //Создаем двумерный массив из нашего массива объектов, чтобы JTable смог его обработать
        //players.length - количество строк, 3 - это количество колонок.
        Object data[][] = new Object[cities.size()][4];

        for (int i = 0; i < cities.size(); i++) {
            data[i][0] = cities.get(i).getId();
            data[i][1] = cities.get(i).getName();
            data[i][2] = cities.get(i).getCountry();
            data[i][3] = cities.get(i).getShort_name();

        }

        DefaultTableModel model = new DefaultTableModel(data,header1);
        table.setModel(model);

    }

    public void generateTableflight(ArrayList<flights> flights) {

        //Создаем двумерный массив из нашего массива объектов, чтобы JTable смог его обработать
        //players.length - количество строк, 3 - это количество колонок.
        Object data[][] = new Object[flights.size()][8];

        for (int i = 0; i < flights.size(); i++) {
            data[i][0] = flights.get(i).getId();
            data[i][1] = flights.get(i).getAircraft_id();
            data[i][2] = flights.get(i).getDeparture_city_id();
            data[i][3] =flights.get(i).getArrival_city_id();
            data[i][4] =flights.get(i).getDeparture_time();
            data[i][5] =flights.get(i).getEconom_place_price();
            data[i][6] =flights.get(i).getBusiness_place_price();

        }

        DefaultTableModel model = new DefaultTableModel(data,header2);
        table.setModel(model);

    }



}






























