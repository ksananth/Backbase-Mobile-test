package com.backbase.mobiletest.ui.citymap.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.backbase.mobiletest.R;
import com.backbase.mobiletest.data.AppDataManager;
import com.backbase.mobiletest.ui.citymap.adapter.CityListAdapter;
import com.backbase.mobiletest.ui.citymap.contract.CityList;
import com.backbase.mobiletest.ui.citymap.model.CityListModel;
import com.backbase.mobiletest.ui.citymap.model.city.Country;
import com.backbase.mobiletest.ui.citymap.presenter.CityListPresenter;

import java.util.ArrayList;

public class CityListActivity extends Activity implements CityList.View {

    private boolean mTwoPane;
    private CityListPresenter cityListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);

        cityListPresenter = new CityListPresenter(this , new CityListModel(new AppDataManager(getApplicationContext())));
        cityListPresenter.init();

        mTwoPane = isTwoPane();


        View recyclerView = findViewById(R.id.item_list);
        setupRecyclerView((RecyclerView) recyclerView);
    }

    private boolean isTwoPane() {
        if (findViewById(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-land layouts
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new CityListAdapter(cityListPresenter.getFilteredCountryList(), mTwoPane));
    }

    @Override
    public void updateList(ArrayList<Country> results) {

    }
}
