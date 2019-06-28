package com.backbase.mobiletest.ui.citymap.contract;

import com.backbase.mobiletest.ui.citymap.model.city.Country;
import com.backbase.mobiletest.ui.citymap.presenter.CityListPresenter;

import java.util.ArrayList;

public interface CityList {
    interface Model {
        void fetchCityList(Presenter.ListCallback callback);
    }

    interface Presenter {
        void init();
        void filterWith(CharSequence filterText);
        ArrayList<Country> getFilteredCountryList();
        ArrayList<Country> getCountryList();
        interface ListCallback {
            void onError();
            void onSuccess(ArrayList<Country> list);
        }
    }

    interface View {
        void updateList(ArrayList<Country> results, String searchedText);
        void showProgressDialog();
        void hideProgressDialog();
        void showError();
    }
}
