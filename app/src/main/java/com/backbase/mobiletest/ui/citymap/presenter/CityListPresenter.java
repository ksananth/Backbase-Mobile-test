package com.backbase.mobiletest.ui.citymap.presenter;

import android.content.Context;
import android.widget.Filter;

import com.backbase.mobiletest.ui.citymap.contract.CityList;
import com.backbase.mobiletest.ui.citymap.model.city.Country;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class CityListPresenter extends Filter implements  CityList.Presenter {

    private WeakReference<Context> context;
    private WeakReference<CityList.View> view;
    private WeakReference<CityList.Model> model;
    private ArrayList<Country> countryLists;

    CityListPresenter(Context context, CityList.View view, CityList.Model model) {
        this.context = new WeakReference<>(context);
        this.view = new WeakReference<>(view);
        this.model = new WeakReference<>(model);
    }


    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if(constraint != null && constraint.length() > 0)
        {
            //CHANGE TO UPPER
            constraint = constraint.toString().toUpperCase();
            ArrayList<Country> filteredCountries = new ArrayList<>();

            for (int i = 0; i<countryLists.size(); i++)
            {
                //CHECK
                if(countryLists.get(i).getName().toUpperCase().contains(constraint))
                {
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
        view.get().updateList((ArrayList<Country>) results.values);
    }

    @Override
    public void init() {
        countryLists = model.get().getCityList();
    }
}
