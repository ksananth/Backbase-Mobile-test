package com.backbase.mobiletest.ui.citymap.contract;

import android.os.Bundle;

public class CityMap {
    public interface Presenter {
        void init();
        String getCity();
        String getCountry();
        String getLatitude();
        String getLongitude();
    }

    public interface View {
        void showMap(String lat, String lon);
    }
}
