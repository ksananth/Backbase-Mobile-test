package com.backbase.mobiletest.ui.citymap.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.backbase.mobiletest.R;
import com.backbase.mobiletest.ui.citymap.contract.CityMap;
import com.backbase.mobiletest.ui.citymap.presenter.CityMapPresenter;

public class CityMapFragment extends Fragment implements CityMap.View{

    private CityMapPresenter cityMapPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cityMapPresenter = new CityMapPresenter(getArguments());
        cityMapPresenter.init();

        Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar);
            if (appBarLayout != null) {
                appBarLayout.setTitle(cityMapPresenter.getCity() + "," +cityMapPresenter.getCountry());
            }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.city_map, container, false);
        ((TextView) rootView.findViewById(R.id.item_detail)).setText(cityMapPresenter.getCountry());
        return rootView;
    }

    @Override
    public void showMap(String lat, String lon) {

    }
}
