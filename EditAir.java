package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditAir extends JPanel  {
    AdminGUI parent;
    JTextField tfname;
    JTextField tfmodel;
    JTextField tfbus;
    JTextField tfeco;
    JTextField tfid;


    public EditAir(AdminGUI parent) {
        this.parent = parent;

        setSize(1200,700);
        setLayout(null);

        tfid=new JTextField();
        tfid.setBounds(100,50,200,50);

        

        tfname= new JTextField();
        tfname.setBounds(100,100,200,50);
        add(tfname);

        tfmodel = new JTextField();
        tfmodel.setBounds(100,200,200,50);
        add(tfmodel);

        tfbus = new JTextField();
        tfbus.setBounds(100,300,200,50);
        add(tfbus);

        tfeco = new JTextField();
        tfeco.setBounds(100,400,200,50);
        add(tfeco);

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
                String model= tfmodel.getText();
                tfmodel.setText("");
                int bus= Integer.parseInt(tfbus.getText());
                tfbus.setText("");
                int eco= Integer.parseInt(tfeco.getText());
                tfeco.setText("");
                aircrafts a1= new aircrafts(id,name,model,bus,eco);
                parent.updateair(a1);

            }
        });

        JButton btn1 = new JButton("BACK");
        btn1.setBounds(200,500,100,50);
        add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getEditAir().setVisible(false);
                parent.getUpdateDb().setVisible(true);
            }
        });


    }
}
