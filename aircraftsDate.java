package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class aircraftsDate implements Serializable {
    private String operationType;
    ArrayList<aircrafts> aircrafts=new ArrayList<>();
     aircrafts aircraft;

    public aircraftsDate(String operationType, ArrayList<com.company.aircrafts> aircrafts, aircrafts aircraft) {
        this.operationType = operationType;
        this.aircrafts = aircrafts;
        this.aircraft = aircraft;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public ArrayList<com.company.aircrafts> getAircrafts() {
        return aircrafts;
    }

    public void setAircrafts(ArrayList<com.company.aircrafts> aircrafts) {
        this.aircrafts = aircrafts;
    }

    public aircrafts getAircraft() {
        return aircraft;
    }

    public void setAircraft(aircrafts aircraft) {
        this.aircraft = aircraft;
    }
}
