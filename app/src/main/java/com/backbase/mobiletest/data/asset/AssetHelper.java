package com.backbase.mobiletest.data.asset;

import com.backbase.mobiletest.ui.citymap.model.city.Country;
import com.backbase.mobiletest.utils.BaseResponseModel;

import java.util.ArrayList;


public interface AssetHelper {
    ArrayList<Country> getAssetContent(String filename);
    String getJson(String filename);
    BaseResponseModel parse(String json, Class<? extends BaseResponseModel> response);
}
