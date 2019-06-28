package com.backbase.mobiletest.ui.citymap.model;

import android.os.Handler;

import com.backbase.mobiletest.data.DataManager;
import com.backbase.mobiletest.ui.citymap.contract.CityList;
import com.backbase.mobiletest.ui.citymap.model.city.Country;

import java.util.ArrayList;

public class CityListModel implements CityList.Model {

    public static final String CITIES_FILENAME = "cities.json";
    private final DataManager dataManager;
    private CityList.Presenter.ListCallback callback;

    public CityListModel(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void fetchCityList(final CityList.Presenter.ListCallback callback) {
        this.callback = callback;
        ArrayList<Country> list = dataManager.getAssetContent(CITIES_FILENAME);
        if(list == null){
            error();
        } else {
            success(list);
        }
    }

    private void error() {
        callback.onError();
    }

    void success(ArrayList<Country> list){
        callback.onSuccess(list);
    }
}
