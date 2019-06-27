package com.backbase.mobiletest.data;

import android.content.Context;

import com.backbase.mobiletest.data.asset.AppAssetHelper;
import com.backbase.mobiletest.ui.citymap.model.city.Country;

import java.util.ArrayList;

public class AppDataManager implements DataManager {

    private final AppAssetHelper assetHelper;

    public AppDataManager(Context context) {
        this.assetHelper = new AppAssetHelper(context);
    }


    @Override
    public ArrayList<Country> getAssetContent(String filename) {
        return assetHelper.getAssetContent(filename);
    }
}
