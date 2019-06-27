package com.backbase.mobiletest.ui.citymap.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.backbase.mobiletest.R;
import com.backbase.mobiletest.ui.citymap.model.city.Country;
import com.backbase.mobiletest.ui.citymap.view.CityListActivity;
import com.backbase.mobiletest.ui.citymap.view.CityMapActivity;
import com.backbase.mobiletest.ui.citymap.view.CityMapFragment;

import java.util.ArrayList;

import static com.backbase.mobiletest.ui.citymap.presenter.CityMapPresenter.KEY_SELECTED_CITY;
import static com.backbase.mobiletest.ui.citymap.presenter.CityMapPresenter.KEY_SELECTED_COUNTRY;
import static com.backbase.mobiletest.ui.citymap.presenter.CityMapPresenter.KEY_SELECTED_LAT;
import static com.backbase.mobiletest.ui.citymap.presenter.CityMapPresenter.KEY_SELECTED_LONG;

public class CityListAdapter extends RecyclerView.Adapter<CityListAdapter.CityListHolder> {
    private CityListActivity context;
    private ArrayList<Country> countries;
    private String searchedText;
    private boolean mTwoPane;

    public CityListAdapter(CityListActivity context, ArrayList<Country> countryArrayList, boolean mTwoPane)
    {
        this.context = context;
        this.countries = countryArrayList;
        this.mTwoPane = mTwoPane;
    }

    @Override
    public CityListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_list_content,null);
        CityListHolder holder=new CityListHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(CityListHolder holder, int position) {

        String cityName = countries.get(position).getName();
        holder.txtCity.setText(cityName +" , "+countries.get(position).getCountry());
        holder.txtLatCoordinates.setText(countries.get(position).getCoord().getLat().toString());
        holder.txtLongCoordinates.setText(countries.get(position).getCoord().getLon().toString());

        if (searchedText != null && cityName.toLowerCase().contains(searchedText.toLowerCase())) {
            int startPos = cityName.toLowerCase().indexOf(searchedText.toLowerCase());
            int endPos = startPos + searchedText.length();
            Spannable spanString = Spannable.Factory.getInstance().newSpannable(holder.txtCity.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.RED), startPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.txtCity.setText(spanString);
        }


        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Snackbar.make(v, countries.get(pos).getName(),Snackbar.LENGTH_SHORT).show();

                if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putString(KEY_SELECTED_COUNTRY, countries.get(pos).getCountry());
                    arguments.putString(KEY_SELECTED_CITY, countries.get(pos).getName());
                    arguments.putString(KEY_SELECTED_LAT, countries.get(pos).getCoord().getLat().toString());
                    arguments.putString(KEY_SELECTED_LONG, countries.get(pos).getCoord().getLon().toString());
                    CityMapFragment fragment = new CityMapFragment();
                    fragment.setArguments(arguments);
                    context.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.item_detail_container, fragment)
                            .commit();
                } else {
                    Intent intent = new Intent(context, CityMapActivity.class);
                    intent.putExtra(KEY_SELECTED_COUNTRY, countries.get(pos).getCountry());
                    intent.putExtra(KEY_SELECTED_CITY, countries.get(pos).getName());
                    intent.putExtra(KEY_SELECTED_LAT, countries.get(pos).getCoord().getLat().toString());
                    intent.putExtra(KEY_SELECTED_LONG, countries.get(pos).getCoord().getLon().toString());

                    context.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public void setFilteredList(ArrayList<Country> results, String searchedText) {
        countries = results;
        this.searchedText = searchedText;
    }

    public class CityListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtCity;
        TextView txtLatCoordinates;
        TextView txtLongCoordinates;

        ItemClickListener itemClickListener;


        public CityListHolder(View itemView) {
            super(itemView);
            this.txtCity = (TextView) itemView.findViewById(R.id.txt_city);
            this.txtLatCoordinates = (TextView) itemView.findViewById(R.id.txt_lat_coordinates);
            this.txtLongCoordinates = (TextView) itemView.findViewById(R.id.txt_long_coordinates);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClick(v,getLayoutPosition());

        }

        public void setItemClickListener(ItemClickListener ic)
        {
            this.itemClickListener=ic;
        }
    }


    public interface ItemClickListener {
        void onItemClick(View v,int pos);
    }
}
