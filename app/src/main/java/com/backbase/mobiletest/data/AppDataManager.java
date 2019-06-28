package com.backbase.mobiletest.data;

import android.content.Context;

import com.backbase.mobiletest.data.asset.AppAssetHelper;
import com.backbase.mobiletest.ui.citymap.model.city.Country;
import com.backbase.mobiletest.utils.BaseResponseModel;

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

    @Override
    public String getJson(String filename) {
        return assetHelper.getJson(filename);
    }

    @Override
    public BaseResponseModel parse(String json, Class<? extends BaseResponseModel> response) {
        return assetHelper.parse(json, response);
    }
}
