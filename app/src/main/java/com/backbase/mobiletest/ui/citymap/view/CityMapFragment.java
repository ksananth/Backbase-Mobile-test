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

public class CityMapFragment extends Fragment {
    public static final String KEY_SELECTED_COUNTRY = "KEY_SELECTED_COUNTRY";
    public static final String KEY_SELECTED_CITY= "KEY_SELECTED_CITY";
    public static final String KEY_SELECTED_LAT = "KEY_SELECTED_LAT";
    public static final String KEY_SELECTED_LONG = "KEY_SELECTED_LONG";
    private String country;
    private String city;
    private String lat;
    private String lon;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setValue(country, KEY_SELECTED_COUNTRY);
        setValue(city, KEY_SELECTED_CITY);
        setValue(lat, KEY_SELECTED_LAT);
        setValue(lon, KEY_SELECTED_LONG);

        Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar);
            if (appBarLayout != null) {
                appBarLayout.setTitle(city + "," +country);
            }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.city_map, container, false);
        ((TextView) rootView.findViewById(R.id.item_detail)).setText(country);
        return rootView;
    }

    private void setValue(String value, String key) {
        if (getArguments().containsKey(key)) {
            value = getArguments().getString(key);
        }
    }
}
