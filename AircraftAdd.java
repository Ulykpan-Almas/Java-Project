package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AircraftAdd extends JPanel {
    public AdminGUI parent;

    public AircraftAdd(AdminGUI parent ) {
        this.parent = parent;
        setSize(1200,700);
        setLayout(null);

        JLabel nameLbl =new JLabel("Aircraft Name:");
        nameLbl.setBounds(100,100,100,40);
        add( nameLbl);

        JTextField nameField=new JTextField();
        nameField.setBounds(100,150,300,40);
        add( nameField);

        JLabel modelLbl =new JLabel("Aircraft Model:");
        modelLbl.setBounds(100,200,100,40);
        add( modelLbl);

        JTextField modelField=new JTextField();
        modelField.setBounds(100,250,300,40);
        add( modelField);

        JLabel business_class_capacityLbl =new JLabel("Business class capacity:");
        business_class_capacityLbl.setBounds(100,300,100,40);
        add( business_class_capacityLbl);

        JTextField business_class_capacityField=new JTextField();
        business_class_capacityField.setBounds(100,350,300,40);
        add( business_class_capacityField);

        JLabel econom_class_capacityLbl =new JLabel("Econom class capacity:");
        econom_class_capacityLbl.setBounds(100,400,100,40);
        add( econom_class_capacityLbl);

        JTextField econom_class_capacityField=new JTextField();
        econom_class_capacityField.setBounds(100,450,300,40);
        add(econom_class_capacityField);

        JButton addBtn= new JButton("ADD");
        addBtn.setBounds(100,490,100,40);
        add(addBtn);
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String model= modelField.getText();
                int business=Integer.parseInt(business_class_capacityField.getText());
                int econom=Integer.parseInt(econom_class_capacityField.getText());
                aircrafts a1= new aircrafts(null,name,model,business,econom);
                aircraftsDate ad= new aircraftsDate("ADD AIRCRAFT",null,a1);
                parent.addaircraft(ad);

            }
        });

        JButton backBtn= new JButton("Back");
        backBtn.setBounds(210,490,100,40);
        add(backBtn);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getAircraftAdd().setVisible(false);
                parent.getAddDb().setVisible(true);
            }
        });






    }
}
