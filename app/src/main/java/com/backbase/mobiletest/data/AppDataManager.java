package com.backbase.mobiletest.data;

import android.content.Context;

import com.backbase.mobiletest.data.asset.AppAssetHelper;
import com.backbase.mobiletest.data.network.ApiHelper;
import com.backbase.mobiletest.utils.BaseResponseModel;

import java.lang.ref.WeakReference;

public class AppDataManager implements DataManager {

    private final WeakReference<Context> context;
    private final AppAssetHelper assetHelper;
    private final ApiHelper apiHelper;

    public AppDataManager(Context context,
                          AppAssetHelper assetHelper,
                          ApiHelper apiHelper) {

        this.context = new WeakReference<>(context);
        this.assetHelper = new AppAssetHelper(context);
        this.apiHelper = apiHelper;
    }

    @Override
    public String getAssetContent(String filename) {
        return assetHelper.getAssetContent(filename);
    }

    @Override
    public BaseResponseModel parseJson(Class<? extends BaseResponseModel> responseModel, String json) {
        return assetHelper.parseJson(responseModel, json);
    }
}
