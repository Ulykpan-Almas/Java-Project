package com.company;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class AdminGUI extends JFrame {
    MainPage mainPage;
    AddDb addDb;
    UpdateDb updateDb;
    DeleteDb deleteDb;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    AircraftAdd aircraftAdd;
    CityAdd cityAdd;
    FlightAdd flightAdd;
    Socket socket;
    EditAir editAir;
    EditCity editCity;
    EditFlight editFlight;
    Long aircraft_id = 0L;
    deleteair deleteair;
    deletecity deletecity;
    deleteflight deleteflight;

    public Long getAircraft_id() {
        return aircraft_id;
    }

    public void setAircraft_id(Long aircraft_id) {
        this.aircraft_id = aircraft_id;
    }

    public AdminGUI(){
             setSize(1200,700);
             setTitle("Almas");
             setDefaultCloseOperation(EXIT_ON_CLOSE);
             setLayout(null);

             try {
                 socket=new Socket("localhost",2030);
                 oos=new ObjectOutputStream(socket.getOutputStream());
                 ois=new ObjectInputStream(socket.getInputStream());
             }catch (Exception e){
                 e.printStackTrace();
             }
             mainPage=new MainPage(this);
             add(mainPage);
             mainPage.setVisible(true);

             addDb=new AddDb(this);
             add(addDb);
             addDb.setVisible(false);

             updateDb=new UpdateDb(this);
             add(updateDb);
             updateDb.setVisible(false);

             deleteDb=new DeleteDb(this);
             add(deleteDb);
             deleteDb.setVisible(false);

             aircraftAdd=new AircraftAdd(this);
             add(aircraftAdd);
             aircraftAdd.setVisible(false);

             cityAdd=new CityAdd(this);
             add(cityAdd);
             cityAdd.setVisible(false);

             flightAdd=new FlightAdd(this);
             add(flightAdd);
             flightAdd.setVisible(false);

             editAir=new EditAir(this);
             add(editAir);
             editAir.setVisible(false);

             editCity=new EditCity(this);
             add(editCity);
             editCity.setVisible(false);

             editFlight=new EditFlight(this);
             add(editFlight);
             editFlight.setVisible(false);

             deleteair=new deleteair(this);
             add(deleteair);
             deleteair.setVisible(false);

             deletecity=new deletecity(this);
             add(deletecity);
             deletecity.setVisible(false);

             deleteflight=new deleteflight(this);
             add(deleteflight);
             deleteflight.setVisible(false);




         }

         public void addaircraft(aircraftsDate ad ){
             try {
                 oos.writeObject(ad);
             }catch (Exception e){
                 e.printStackTrace();
             }
         }


    public void addcities(citiesDate cd ){
        try {
            oos.writeObject(cd);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addflight(flightsDate fd ){
        try {
            oos.writeObject(fd);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getaircraft(){
             aircraftsDate ad= new aircraftsDate("aircraftsList",null,null);
             try {
                 oos.writeObject(ad);
                 System.out.println("SEND");
                 aircraftsDate answer=(aircraftsDate) ois.readObject();
                 System.out.println("Server answer");
                 updateDb.generateTableair(answer.getAircrafts());

             }catch (Exception e){
                 e.printStackTrace();
             }
    }

    public void getcities(){
        citiesDate cd= new citiesDate("citiesList",null,null);
        try {
            oos.writeObject(cd);
            System.out.println("SEND");
            citiesDate answer=(citiesDate) ois.readObject();
            System.out.println("Server answer");
            updateDb.generateTablecity(answer.getCities());


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getflight(){
        flightsDate fd= new flightsDate("flightslist",null,null);
        try {
            oos.writeObject(fd);
            System.out.println("SEND");
            flightsDate answer=(flightsDate) ois.readObject();
            System.out.println("Server answer");
            updateDb.generateTableflight(answer.getFlights());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public  void updateair (aircrafts aircrafts){
             aircraftsDate ad=new aircraftsDate("aircraftsupdate",null,aircrafts);
             try {
                 oos.writeObject(ad);
                 System.out.println("SEND");
                 aircraftsDate answer=(aircraftsDate) ois.readObject();
                 System.out.println("Server answer");
                 updateDb.generateTableair(answer.getAircrafts());
             }catch (Exception e){
                 e.printStackTrace();
             }
    }

    public  void updatecity (cities cities){
        citiesDate cd=new citiesDate("citiesupdate",null,cities);
        try {
            oos.writeObject(cd);
            System.out.println("SEND");
            citiesDate answer=(citiesDate) ois.readObject();
            System.out.println("Server answer");
            updateDb.generateTablecity(answer.getCities());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public  void updateflight (flights flights){
        flightsDate fd=new flightsDate("flightsupdate",null,flights);
        try {
            oos.writeObject(fd);
            System.out.println("SEND");
            flightsDate answer=(flightsDate) ois.readObject();
            System.out.println("Server answer");
            updateDb.generateTableflight(answer.getFlights());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<aircrafts> sendlistair(String string){
        ArrayList<aircrafts> aircrafts =null;
        try{
            oos.writeObject(string);
            ois=new ObjectInputStream(socket.getInputStream());
            aircrafts=(ArrayList<aircrafts>) ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  aircrafts;
    }

    public ArrayList<cities> sendlistcity(String string){
        ArrayList<cities> cities =null;
        try{
            oos.writeObject(string);
            ois=new ObjectInputStream(socket.getInputStream());
            cities=(ArrayList<cities>) ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  cities;
    }

    public ArrayList<flights> sendlistflight(String string){
        ArrayList<flights> flights =null;
        try{
            oos.writeObject(string);
            ois=new ObjectInputStream(socket.getInputStream());
            flights=(ArrayList<flights>) ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  flights;
    }

    public void SendFlight(flights flights) throws IOException{
        try{
            flightsDate flightsDate=new flightsDate("ADD",null,flights);
            oos.writeObject(flightsDate);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void DeleteAircraft(aircrafts aircraft){
        try{
            aircraftsDate ap = new aircraftsDate("DELETEAIR",null,aircraft);
            oos.writeObject(ap);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void DeleteCities(cities city){
        try{
            citiesDate cd = new citiesDate("DELETECITY",null,city);
            oos.writeObject(cd);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void DeleteFlight(flights flights){
        try{
            flightsDate fd = new flightsDate("DELETEFLIGHT",null,flights);
            oos.writeObject(fd);
        }catch (Exception e){
            e.printStackTrace();
        }
    }









    public AddDb getAddDb() {
        return addDb;
    }

    public AircraftAdd getAircraftAdd() {
        return aircraftAdd;
    }

    public CityAdd getCityAdd() {
        return cityAdd;
    }

    public FlightAdd getFlightAdd() {
        return flightAdd;
    }

    public UpdateDb getUpdateDb() {        return updateDb;
    }

    public MainPage getMainPage() {
        return mainPage;
    }

    public EditAir getEditAir() {
        return editAir;
    }

    public void setEditAir(EditAir editAir) {
        this.editAir = editAir;
    }

    public EditCity getEditCity() {
        return editCity;
    }

    public EditFlight getEditFlight() {
        return editFlight;
    }

    public com.company.deleteair getDeleteair() {
        return deleteair;
    }

    public com.company.deletecity getDeletecity() {
        return deletecity;
    }

    public com.company.deleteflight getDeleteflight() {
        return deleteflight;
    }
}

