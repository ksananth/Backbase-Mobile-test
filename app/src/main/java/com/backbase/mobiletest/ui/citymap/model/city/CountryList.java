package com.backbase.mobiletest.ui.citymap.model.city;

import com.backbase.mobiletest.utils.BaseResponseModel;

import java.util.ArrayList;
import java.util.List;

public class CountryList extends BaseResponseModel {

    public ArrayList<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(ArrayList<Country> countryList) {
        this.countryList = countryList;
    }

    ArrayList<Country> countryList;
}
