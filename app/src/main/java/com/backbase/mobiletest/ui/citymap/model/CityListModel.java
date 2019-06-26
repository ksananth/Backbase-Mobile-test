package com.backbase.mobiletest.ui.citymap.model;

import android.content.Context;

import com.backbase.mobiletest.data.AppDataManager;
import com.backbase.mobiletest.data.DataManager;
import com.backbase.mobiletest.ui.citymap.contract.CityList;
import com.backbase.mobiletest.ui.citymap.model.city.Country;
import com.backbase.mobiletest.ui.citymap.model.city.CountryList;

import java.util.ArrayList;

public class CityListModel implements CityList.Model {

    public static final String CITIES_FILENAME = "cities.json";
    private final DataManager dataManager;

    public CityListModel(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public ArrayList<Country> getCityList() {
        CountryList list = ((CountryList)(dataManager.getAssetContent(CITIES_FILENAME, CountryList.class)));
        return list.getCountryList();
    }
}
