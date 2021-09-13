package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditCity extends JPanel {
    AdminGUI parent;
    JTextField tfname;
    JTextField tfcountry;
    JTextField tfshort_name;
    JTextField tfid;

    public EditCity(AdminGUI parent) {
        this.parent = parent;
        setSize(1200,700);
        setLayout(null);

        tfid=new JTextField();
        tfid.setBounds(100,50,200,50);


        tfname= new JTextField();
        tfname.setBounds(100,100,200,50);
        add(tfname);

        tfcountry = new JTextField();
        tfcountry.setBounds(100,200,200,50);
        add(tfcountry);

        tfshort_name = new JTextField();
        tfshort_name.setBounds(100,300,200,50);
        add(tfshort_name);

        JButton btn= new JButton("EDIT");
        btn.setBounds(100,500,100,50);
        add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Long id =Long.parseLong(tfid.getText());
                tfid.setText("");
                String name = tfname.getText();
                tfname.setText("");
                String county = tfcountry.getText();
                tfcountry.setText("");
                String short_name= tfshort_name.getText();
                tfshort_name.setText("");
                cities c1= new cities(id,name,county,short_name);
                parent.updatecity(c1);


            }
        });

        JButton btn1 = new JButton("BACK");
        btn1.setBounds(200,500,100,50);
        add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getEditCity().setVisible(false);
                parent.getUpdateDb().setVisible(true);
            }
        });


    }
}
