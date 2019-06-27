package com.backbase.mobiletest.ui.citymap.view;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.backbase.mobiletest.R;

import static com.backbase.mobiletest.ui.citymap.presenter.CityMapPresenter.KEY_SELECTED_CITY;
import static com.backbase.mobiletest.ui.citymap.presenter.CityMapPresenter.KEY_SELECTED_COUNTRY;
import static com.backbase.mobiletest.ui.citymap.presenter.CityMapPresenter.KEY_SELECTED_LAT;
import static com.backbase.mobiletest.ui.citymap.presenter.CityMapPresenter.KEY_SELECTED_LONG;

public class CityMapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        toolbar.setTitle(getIntent().getStringExtra(KEY_SELECTED_CITY));


        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(KEY_SELECTED_CITY, getIntent().getStringExtra(KEY_SELECTED_CITY));
            arguments.putString(KEY_SELECTED_COUNTRY, getIntent().getStringExtra(KEY_SELECTED_COUNTRY));
            arguments.putString(KEY_SELECTED_LAT, getIntent().getStringExtra(KEY_SELECTED_LAT));
            arguments.putString(KEY_SELECTED_LONG, getIntent().getStringExtra(KEY_SELECTED_LONG));
            CityMapFragment fragment = new CityMapFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().add(R.id.item_detail_container, fragment).commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
