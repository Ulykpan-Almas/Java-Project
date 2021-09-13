package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class flightsDate implements Serializable {
    private String operationType;
    ArrayList<flights> flights=new ArrayList<>();
     flights flight;

    public flightsDate(String operationType, ArrayList<com.company.flights> flights, com.company.flights flight) {
        this.operationType = operationType;
        this.flights = flights;
        this.flight = flight;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public ArrayList<com.company.flights> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<com.company.flights> flights) {
        this.flights = flights;
    }

    public com.company.flights getFlight() {
        return flight;
    }


}
