package com.backbase.mobiletest.ui.citymap.presenter;

import android.widget.Filter;

import com.backbase.mobiletest.ui.citymap.contract.CityList;
import com.backbase.mobiletest.ui.citymap.model.city.Country;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class CityListPresenter extends Filter implements  CityList.Presenter {

    private WeakReference<CityList.View> view;
    private WeakReference<CityList.Model> model;
    private ArrayList<Country> countryLists;
    private ArrayList<Country> filteredCountryList;

    CityListPresenter(CityList.View view, CityList.Model model) {
        this.view = new WeakReference<>(view);
        this.model = new WeakReference<>(model);
    }


    @Override
    protected FilterResults performFiltering(CharSequence text) {
        FilterResults results = new FilterResults();

        if(text != null && text.length() > 0) {
            //CHANGE TO UPPER
            text = text.toString().toUpperCase();
            ArrayList<Country> filteredCountries = new ArrayList<>();

            for (int i = 0; i<countryLists.size(); i++) {
                //CHECK
                if(countryLists.get(i).getCountry().toUpperCase().contains(text)) {
                    filteredCountries.add(countryLists.get(i));
                }
            }

            results.count = filteredCountries.size();
            results.values = filteredCountries;
        } else {
            results.count = countryLists.size();
            results.values = countryLists;

        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        filteredCountryList = (ArrayList<Country>) results.values;
        view.get().updateList(filteredCountryList);
    }

    @Override
    public ArrayList<Country> getFilteredCountryList() {
        return filteredCountryList;
    }

    @Override
    public void init() {
        countryLists = model.get().getCityList();
    }

    @Override
    public void filterWith(CharSequence filterText) {
        publishResults(filterText, performFiltering(filterText));
    }
}
