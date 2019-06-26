package com.backbase.mobiletest.data;

import android.content.Context;

import com.backbase.mobiletest.data.asset.AppAssetHelper;
import com.backbase.mobiletest.ui.citymap.model.city.Country;
import com.backbase.mobiletest.utils.BaseResponseModel;

import java.util.ArrayList;
import java.util.List;

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
