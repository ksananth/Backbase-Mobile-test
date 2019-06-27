package com.backbase.mobiletest.ui.citymap.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import com.backbase.mobiletest.R;
import com.backbase.mobiletest.data.AppDataManager;
import com.backbase.mobiletest.ui.citymap.adapter.CityListAdapter;
import com.backbase.mobiletest.ui.citymap.contract.CityList;
import com.backbase.mobiletest.ui.citymap.model.CityListModel;
import com.backbase.mobiletest.ui.citymap.model.city.Country;
import com.backbase.mobiletest.ui.citymap.presenter.CityListPresenter;

import java.util.ArrayList;

public class CityListActivity extends AppCompatActivity implements CityList.View, SearchView.OnQueryTextListener {

    private boolean mTwoPane;
    private CityListPresenter cityListPresenter;
    private CityListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);

        cityListPresenter = new CityListPresenter(this , new CityListModel(new AppDataManager(getApplicationContext())));
        cityListPresenter.init();

        mTwoPane = isTwoPane();

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.list_city);
        SearchView searchView = (SearchView)findViewById(R.id.search_view);

        setupRecyclerView(recyclerView);
        setUpSearchView(searchView);
    }

    private boolean isTwoPane() {
        if (findViewById(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-land layouts
            // If this view is present, then the
            // activity should be in two-pane mode.
            return true;
        }
        return false;
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        adapter = new CityListAdapter(CityListActivity.this, cityListPresenter.getCountryList(), mTwoPane);
        recyclerView.setAdapter(adapter);
    }

    private void setUpSearchView(SearchView searchView) {
        searchView.setIconified(false);
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
    }

    @Override
    public void updateList(ArrayList<Country> results, String searchedText) {
        adapter.setFilteredList(results, searchedText);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        cityListPresenter.filterWith(newText);
        return false;
    }
}
