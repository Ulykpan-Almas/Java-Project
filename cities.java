package com.company;

import java.io.Serializable;

public class cities implements Serializable {
    public Long id;
    private String name;
    private String country;
    private String short_name;

    public cities(Long id, String name, String country, String short_name) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.short_name = short_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    @Override
    public String toString() {
        return "cities{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", short_name='" + short_name + '\'' +
                '}';
    }
}
