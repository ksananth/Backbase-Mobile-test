package com.backbase.mobiletest.ui.citymap.presenter;

import android.content.Context;

import com.backbase.mobiletest.ui.citymap.contract.CityList;

import java.lang.ref.WeakReference;

public class CityListPresenter implements CityList.Presenter {

    private Context context;
    private WeakReference<CityList.View> view;
    private CityList.Model model;

    public CityListPresenter(Context context, CityList.View view, CityList.Model model) {
        this.context = context;
        this.view = new WeakReference<>(view);
        this.model = model;
    }
}
