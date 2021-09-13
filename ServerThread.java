package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServerThread implements Runnable {
    Socket socket;
    Connection connection;

    public ServerThread(Socket socket, Connection connection) {
        this.socket = socket;
        this.connection = connection;
    }


    @Override
    public void run() {
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            while (true) {

                Object object = ois.readObject();

                if(object instanceof aircraftsDate) {

                    aircraftsDate a1 =(aircraftsDate)object;
                    System.out.println(a1.getOperationType());

                    if (a1.getOperationType().equals("ADD AIRCRAFT")) {
                        addaircraft(a1.aircraft);
                    }
                    if (a1.getOperationType().equals("aircraftsList")) {
                        ArrayList<aircrafts> aircrafts = getaircraftslist();
                        a1.setAircrafts(aircrafts);
                        oos.writeObject(a1);
                    }
                    if (a1.getOperationType().equals("aircraftsupdate")) {
                        updateaircraft(a1.getAircraft());
                        oos.writeObject(a1);
                        System.out.println("hello");
                    }
                    if (a1.getOperationType().equals("DELETEAIR")) {
                        deleteaircraft(a1.aircraft);
                    }

                }

                if(object instanceof citiesDate){
                    citiesDate c1=(citiesDate)object;
                    System.out.println(c1.getOperationType());
                    if(c1.getOperationType().equals("ADD CITY")){
                        addcities(c1.city);
                    }
                    if (c1.getOperationType().equals("citiesList")) {
                        ArrayList<cities> cities= getcitieslist();
                        c1.setCities(cities);
                        oos.writeObject(c1);
                    }
                    if (c1.getOperationType().equals("citiesupdate")) {
                        updatecity(c1.getCity());
                        oos.writeObject(c1);
                    }
                    if(c1.getOperationType().equals("DELETECITY"));
                    {
                        deleteCities(c1.city);
                    }

                }

                if(object instanceof  String){
                    if (object.equals("aircrafts")){
                        oos=new ObjectOutputStream(socket.getOutputStream());
                        oos.writeObject(getaircraftslist());
                    }
                    if(object.equals("cities")){
                        oos = new ObjectOutputStream(socket.getOutputStream());
                        oos.writeObject(getcitieslist());
                    }
                    if(object.equals("flights")){
                        oos = new ObjectOutputStream(socket.getOutputStream());
                        oos.writeObject(getflightslist());
                    }
                }


                if(object instanceof flightsDate){
                    flightsDate f1=(flightsDate)object;
                    System.out.println(f1.getOperationType());
                    if(f1.getOperationType().equals("ADD FLIGHT")){
                        addflights(f1.flight);
                    }
                    if (f1.getOperationType().equals("flightslist")) {
                        ArrayList<flights> flights= getflightslist();
                        f1.setFlights(flights);
                        oos.writeObject(f1);
                    }
                    if (f1.getOperationType().equals("flightsupdate")) {
                        updateflight(f1.getFlight());
                        oos.writeObject(f1);
                    }
                    if(f1.getOperationType().equals("DELETEFLIGHT"));
                    {
                        deleteFlights(f1.flight);
                    }

                }

            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addaircraft(aircrafts aircrafts) {
        try {
            PreparedStatement st = connection.prepareStatement("INSERT INTO aircrafts(id,name,model,business_class_capacity,econom_class_capacity) VALUES (NULL,?,?,?,?)");
            st.setString(1, aircrafts.getName());
            st.setString(2, aircrafts.getModel());
            st.setInt(3, aircrafts.getBusiness_class_capacity());
            st.setInt(4, aircrafts.getEconom_class_capacity());
            st.executeUpdate();

            st = connection.prepareStatement("SELECT * FROM aircrafts WHERE name=? AND model=? AND business_class_capacity=? AND econom_class_capacity=?");
            st.setString(1, aircrafts.getName());
            st.setString(2, aircrafts.getModel());
            st.setInt(3, aircrafts.getBusiness_class_capacity());
            st.setInt(4, aircrafts.getEconom_class_capacity());
            ResultSet rs = st.executeQuery();
            rs.next();
            if (rs.next()) System.out.println("aircraft add");
            st.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<aircrafts> getaircraftslist() {
        ArrayList<aircrafts> aircrafts = new ArrayList<>();
        System.out.println("LIST");
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM aircrafts");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String model = rs.getString("model");
                int business_class_capacity = rs.getInt("business_class_capacity");
                int econom_class_capacity = rs.getInt("econom_class_capacity");
                aircrafts.add(new aircrafts(id, name, model, business_class_capacity, econom_class_capacity));
                System.out.println(aircrafts.get(aircrafts.size() - 1));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aircrafts;
    }

    public void addcities(cities cities) {
        try {
            PreparedStatement st = connection.prepareStatement("INSERT INTO cities(id,name,country,short_name) VALUES (NULL,?,?,?)");
            st.setString(1, cities.getName());
            st.setString(2, cities.getCountry());
            st.setString(3, cities.getShort_name());
            st.executeUpdate();

            st = connection.prepareStatement("SELECT * FROM cities WHERE name=? AND country=? AND short_name=?");
            st.setString(1, cities.getName());
            st.setString(2, cities.getCountry());
            st.setString(3, cities.getShort_name());
            ResultSet rs = st.executeQuery();
            rs.next();
            if (rs.next()) System.out.println("cities add");
            st.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<cities> getcitieslist() {
        ArrayList<cities> cities = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM cities");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String country = rs.getString("country");
                String shortname = rs.getString("short_name");
                cities.add(new cities(id, name, country, shortname));
                System.out.println(cities.get(cities.size() - 1));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

    public void addflights(flights flights) {
        try {
            PreparedStatement st = connection.prepareStatement("INSERT INTO flights(id,aircraft_id,departure_city_id,arrival_city_id,departure_time,econom_place_price,business_place_price) VALUES (NULL,?,?,?,?,?,?)");
            st.setLong(1, flights.getAircraft_id());
            st.setLong(2, flights.getDeparture_city_id());
            st.setLong(3, flights.getArrival_city_id());
            st.setString(4, flights.getDeparture_time());
            st.setInt(5, flights.getEconom_place_price());
            st.setInt(6, flights.getBusiness_place_price());
            st.executeUpdate();

            st = connection.prepareStatement("SELECT * FROM flights WHERE aircraft_id=? AND departure_city_id=? AND arrival_city_id=? AND departure_time=? AND econom_place_price=? AND business_place_price=? ");
            st.setLong(1, flights.getAircraft_id());
            st.setLong(2, flights.getDeparture_city_id());
            st.setLong(3, flights.getArrival_city_id());
            st.setString(4, flights.getDeparture_time());
            st.setInt(5, flights.getEconom_place_price());
            st.setInt(6, flights.getBusiness_place_price());
            ResultSet rs = st.executeQuery();
            rs.next();
            if (rs.next()) System.out.println("flights add");
            st.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<flights> getflightslist() {
        ArrayList<flights> flights = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM flights");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                Long aircraft_id = rs.getLong("aircraft_id");
                Long departure_city_id = rs.getLong("departure_city_id");
                Long arrival_city_id = rs.getLong("arrival_city_id");
                String departure_time = rs.getString("departure_time");
                int econom_place_price = rs.getInt("econom_place_price");
                int business_place_price = rs.getInt("business_place_price");
                flights.add(new flights(id, aircraft_id, departure_city_id, arrival_city_id, departure_time, econom_place_price, business_place_price));
                System.out.println(flights.get(flights.size() - 1));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flights;
    }

    public void updateaircraft(aircrafts aircrafts) {
        try {
            PreparedStatement st = connection.prepareStatement("UPDATE aircrafts set name=? , model=? , business_class_capacity=? , econom_class_capacity=? WHERE id=?");
            st.setString(1, aircrafts.getName());
            st.setString(2, aircrafts.getModel());
            st.setInt(3, aircrafts.getBusiness_class_capacity());
            st.setInt(4, aircrafts.getEconom_class_capacity());
            System.out.println(aircrafts.getId());
            st.setLong(5, aircrafts.getId());
            st.executeUpdate();

            st.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    public void updatecity(cities cities) {
        try {
            PreparedStatement st = connection.prepareStatement("UPDATE cities set name=?, country=?, short_name=? WHERE id=?");
            st.setString(1, cities.getName());
            st.setString(2, cities.getCountry());
            st.setString(3, cities.getShort_name());
            System.out.println(cities.getId());
            st.setLong(4,cities.getId());
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateflight(flights flights) {
        try {
            PreparedStatement st = connection.prepareStatement("UPDATE flights set aircraft_id=?, departure_city_id=?, arrival_city_id=?, departure_time=?, econom_place_price=?, business_place_price=? WHERE id=? ");
            st.setLong(1, flights.getAircraft_id());
            st.setLong(2, flights.getDeparture_city_id());
            st.setLong(3, flights.getArrival_city_id());
            st.setString(4, flights.getDeparture_time());
            st.setInt(5, flights.getEconom_place_price());
            st.setInt(6, flights.getBusiness_place_price());
            System.out.println(flights.getId());
            st.setLong(7, flights.getId());
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteaircraft(aircrafts aircrafts){
        try {
            PreparedStatement st=connection.prepareStatement("DELETE from aircraft WHERE id=?");
            st.setLong(1, aircrafts.id);
            st.execute();
            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteCities(cities cities) {
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM cities where id=?");
            st.setLong(1, cities.id);
            st.execute();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteFlights(flights flights) {
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM flights where id=?");
            st.setLong(1, flights.id);
            st.execute();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
