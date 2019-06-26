package com.backbase.mobiletest.ui.citymap.model.city;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Coordinates {
    @SerializedName("lon")
    @Expose
    private Double lon;
    @SerializedName("lat")
    @Expose
    private Integer lat;

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Integer getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }
}
