package com.backbase.mobiletest.ui.citymap.contract;

public class CityMap {
    public interface Presenter {
        void init();
        String getCity();
        String getCountry();
        double getLatitude();
        double getLongitude();
    }

    public interface View {
        void initializeMap();
    }
}
