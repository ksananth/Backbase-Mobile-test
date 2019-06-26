package com.backbase.mobiletest.data;

import android.content.Context;

import com.backbase.mobiletest.data.asset.AppAssetHelper;
import com.backbase.mobiletest.utils.BaseResponseModel;

public class AppDataManager implements DataManager {

    private final AppAssetHelper assetHelper;

    public AppDataManager(Context context) {
        this.assetHelper = new AppAssetHelper(context);
    }


    @Override
    public BaseResponseModel getAssetContent(String filename, Class<? extends BaseResponseModel> responseModel) {
        return assetHelper.getAssetContent(filename, responseModel);
    }
}
