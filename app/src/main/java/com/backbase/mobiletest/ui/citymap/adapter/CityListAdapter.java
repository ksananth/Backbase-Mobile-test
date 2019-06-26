package com.backbase.mobiletest.ui.citymap.adapter;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.backbase.mobiletest.R;
import com.backbase.mobiletest.ui.citymap.model.city.Country;

import java.util.ArrayList;

public class CityListAdapter extends RecyclerView.Adapter<CityListAdapter.CityListHolder> implements Filterable {
    private ArrayList<Country> filterList;
    private boolean mTwoPane;

    public CityListAdapter(ArrayList<Country> filterList, boolean mTwoPane)
    {
        this.filterList = filterList;
        this.mTwoPane = mTwoPane;
    }

    @Override
    public CityListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.city_list_content,null);
        CityListHolder holder=new CityListHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(CityListHolder holder, int position) {

        holder.txtCity.setText(filterList.get(position).getCountry());
        holder.txtCoordinates.setText(filterList.get(position).getCoord().getLat().toString());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Snackbar.make(v,filterList.get(pos).getName(),Snackbar.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return filterList.size();
    }

    @Override
    public Filter getFilter() {
        if(filterList == null)
        {
            filterList = new CustomFilter(filterList,this);
        }

        return filter;
    }

    public class CityListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtCity,txtCoordinates;

        ItemClickListener itemClickListener;


        public CityListHolder(View itemView) {
            super(itemView);
            this.txtCity = (TextView) itemView.findViewById(R.id.txt_city);
            this.txtCoordinates = (TextView) itemView.findViewById(R.id.txt_coordinates);

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
