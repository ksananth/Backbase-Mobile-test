package com.backbase.mobiletest.ui.citymap.contract;

import com.backbase.mobiletest.ui.citymap.model.city.Country;

import java.util.ArrayList;

public interface CityList {
    interface Model {
        ArrayList<Country> getCityList();
    }

    interface Presenter {
        void init();
        void filterWith(CharSequence filterText);
        ArrayList<Country> getFilteredCountryList();
        ArrayList<Country> getCountryList();
    }

    interface View {
        void updateList(ArrayList<Country> results, String searchedText);
    }
}
