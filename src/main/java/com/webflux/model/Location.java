package com.webflux.model;

/**
 * Created by Administrator on 2017/8/15.
 */
public class Location {
    private String place;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    private String year;

    public Location(String place,String year){
        super();
        this.place = place;
        this.year = year;
    }
}
