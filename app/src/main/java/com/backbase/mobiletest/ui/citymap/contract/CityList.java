package com.backbase.mobiletest.ui.citymap.contract;

import com.backbase.mobiletest.ui.citymap.model.city.Country;
import com.backbase.mobiletest.ui.citymap.model.city.CountryList;

import java.util.ArrayList;

public interface CityList {
    interface Model {
        ArrayList<Country> getCityList();
    }

    interface Presenter {
        void init();
        void filter(CharSequence filterText);
    }

    interface View {
        void updateList(ArrayList<Country> results);
    }
}
