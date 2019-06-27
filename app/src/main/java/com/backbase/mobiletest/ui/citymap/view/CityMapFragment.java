package com.backbase.mobiletest.ui.citymap.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.backbase.mobiletest.R;
import com.backbase.mobiletest.ui.citymap.contract.CityMap;
import com.backbase.mobiletest.ui.citymap.presenter.CityMapPresenter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class CityMapFragment extends Fragment implements CityMap.View, OnMapReadyCallback {

    private CityMapPresenter cityMapPresenter;
    private GoogleMap mMap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Activity activity = this.getActivity();
            //CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar);
            //if (appBarLayout != null) {
              //  appBarLayout.setTitle(cityMapPresenter.getCity() + "," +cityMapPresenter.getCountry());
            //}

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.city_map, container, false);

        cityMapPresenter = new CityMapPresenter(CityMapFragment.this, getArguments());
        cityMapPresenter.init();

        return rootView;
    }

    @Override
    public void initializeMap() {
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(cityMapPresenter.getLatitude(), cityMapPresenter.getLongitude());
        mMap.addMarker(new MarkerOptions().position(sydney).title(cityMapPresenter.getCity()+","+cityMapPresenter.getCountry()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
