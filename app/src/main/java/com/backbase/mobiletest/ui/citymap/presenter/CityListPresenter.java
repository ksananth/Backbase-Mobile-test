package com.backbase.mobiletest.ui.citymap.presenter;

import android.content.Context;

import com.backbase.mobiletest.ui.citymap.contract.CityList;

public class CityListPresenter implements CityList.Presenter {

    private Context context;
    private CityList.View view;
    private CityList.Model model;

    public CityListPresenter(Context context, CityList.View view, CityList.Model model) {

        this.context = context;
        this.view = view;
        this.model = model;
    }
}
