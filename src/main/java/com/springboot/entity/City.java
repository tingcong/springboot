package com.springboot.entity;

import java.io.Serializable;

/**
 * Created by htc on 2017/9/28.
 */
public class City implements Serializable {
    private static final long serialVersionUID = -1831306153053771137L;
    private int cityId;
    private String city;
    private int countryId;
    private String lastUpdate;

    public City() {
        super();
    }

    public City(int cityId, String city, int countryId, String lastUpdate) {
        this.cityId = cityId;
        this.city = city;
        this.countryId = countryId;
        this.lastUpdate = lastUpdate;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
