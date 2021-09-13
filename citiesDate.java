package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class citiesDate implements Serializable {
    private String operationType;
    ArrayList<cities> cities=new ArrayList<>();
     cities city;

    public citiesDate(String operationType, ArrayList<com.company.cities> cities, com.company.cities city) {
        this.operationType = operationType;
        this.cities = cities;
        this.city = city;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public ArrayList<com.company.cities> getCities() {
        return cities;
    }

    public void setCities(ArrayList<com.company.cities> cities) {
        this.cities = cities;
    }

    public com.company.cities getCity() {
        return city;
    }

    public void setCity(com.company.cities city) {
        this.city = city;
    }
}
