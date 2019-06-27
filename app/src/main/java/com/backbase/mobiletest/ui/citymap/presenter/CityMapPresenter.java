package com.backbase.mobiletest.ui.citymap.presenter;

import android.os.Bundle;

import com.backbase.mobiletest.ui.citymap.contract.CityMap;

public class CityMapPresenter implements CityMap.Presenter {

    public static final String KEY_SELECTED_COUNTRY = "KEY_SELECTED_COUNTRY";
    public static final String KEY_SELECTED_CITY= "KEY_SELECTED_CITY";
    public static final String KEY_SELECTED_LAT = "KEY_SELECTED_LAT";
    public static final String KEY_SELECTED_LONG = "KEY_SELECTED_LONG";

    private CityMap.View view;

    private String country;
    private String city;
    private double lat;
    private double lon;
    private Bundle bundle;

    public CityMapPresenter(CityMap.View view, Bundle bundle){
        this.view = view;
        this.bundle = bundle;
    }

    @Override
    public void init() {
        setCountry(KEY_SELECTED_COUNTRY);
        setCity(KEY_SELECTED_CITY);
        setLangitude(KEY_SELECTED_LAT);
        setLongitude(KEY_SELECTED_LONG);

        view.initializeMap();
    }

    @Override
    public String getCity() {
        return this.city;
    }

    @Override
    public String getCountry() {
        return this.country;
    }

    @Override
    public double getLatitude() {
        return this.lat;
    }

    @Override
    public double getLongitude() {
        return this.lon;
    }

    private void setCountry(String key) {
        country = bundle.getString(key);
    }

    private void setCity(String key) {
        city = bundle.getString(key);
    }

    private void setLangitude(String key) {
        lat = Double.parseDouble(bundle.getString(key));
    }

    private void setLongitude(String key) {
        lon = Double.parseDouble(bundle.getString(key));
    }
}
