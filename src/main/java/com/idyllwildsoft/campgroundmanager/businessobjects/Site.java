package com.idyllwildsoft.campgroundmanager.businessobjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Site {
    private long id;
    private Integer width;
    private Integer length;
    private Boolean electricity;
    private Integer electricityAmp;
    private Boolean water;
    private Boolean sewage;
    private Integer slope;
    private String img;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Boolean getElectricity() {
        return electricity;
    }

    public void setElectricity(Boolean electricity) {
        this.electricity = electricity;
    }

    public Integer getElectricityAmp() {
        return electricityAmp;
    }

    public void setElectricityAmp(Integer electricityAmp) {
        this.electricityAmp = electricityAmp;
    }

    public Boolean getWater() {
        return water;
    }

    public void setWater(Boolean water) {
        this.water = water;
    }

    public Boolean getSewage() {
        return sewage;
    }

    public void setSewage(Boolean sewage) {
        this.sewage = sewage;
    }

    public Integer getSlope() {
        return slope;
    }

    public void setSlope(Integer slope) {
        this.slope = slope;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
