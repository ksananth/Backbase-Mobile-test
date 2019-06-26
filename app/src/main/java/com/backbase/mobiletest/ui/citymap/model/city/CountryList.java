package com.backbase.mobiletest.ui.citymap.model.city;

import com.backbase.mobiletest.utils.BaseResponseModel;

import java.util.List;

public class CountryList extends BaseResponseModel {

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    List<Country> countryList;
}
